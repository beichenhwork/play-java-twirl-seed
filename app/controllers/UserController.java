package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import models.User;

import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;

import utils.Constants;
import utils.RESTfulCalls;
import views.html.*;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @description: user service functions
 * @author: Junhao Shen, Beichen Hu
 * @create: 2023-03-30
 */
@Singleton
public class UserController extends Controller {

    @Inject
    HttpExecutionContext ec;

    @Inject
    Config config;

    @Inject RESTfulCalls restfulCalls;

    private FormFactory formFactory;
    private Form<User> userForm;


    /********************************************** CONSTRUCTOR *******************************************************/
    @Inject
    public UserController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.userForm = formFactory.form(User.class);
    }
    /********************************************** END CONSTRUCTOR ***************************************************/


    /********************************************** USER SERVICE PAGE *************************************************/

    /**
     * render user signup page
     */
    public Result signup(Http.Request request) {
        return ok(views.html.register.render(request));
    }

    /**
     * render user detail page
     * @return
     */
    public Result detailPage(Http.Request request) {
        return request.session().get("id").map(id -> {
            JsonNode userNode = restfulCalls.getAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_DETAIL_BY_ID + id));
            if(userNode == null || userNode.has("error")){
                Logger.debug("UserController.detailPage cannot find user from backend");
                return redirect("/login").flashing("error", "There is no user, please log in again.");
            }else{
                Logger.info("Current User Info: " + userNode.toString());
                User curUser = Json.fromJson(userNode, User.class);
                return ok(views.html.detail.render(curUser));
            }
        }).orElseGet(() -> {
            return redirect("/login").flashing("error", "Cannot go to detail page, please log in again.");
        });

    }

    /**
     * render user edit page
     * @return
     */
    public Result editPage(Http.Request request) {
        return request.session().get("id")
                .map(id -> {
                    String userId = id;
                    JsonNode userNode = restfulCalls.getAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_DETAIL_BY_ID + userId));
                    if(userNode == null || userNode.has("error")){
                        Logger.debug("UserController.editPage cannot find user from backend");
                        return redirect("/login").flashing("error", "There is no user, please log in again.");
                    }else{
                        Logger.info("Current Edit User Info: " + userNode.toString());
                        User curUser = Json.fromJson(userNode, User.class);
                        return ok(edit.render(curUser));
                    }
                })
                .orElseGet(() -> redirect("/login").flashing("error", "Cannot go to edit page, please log in again."));
    }

    /******************************************* END USER SERVICE PAGE ************************************************/


    /*************************************************** USER LOGIN ***************************************************/
    /**
     * render user login page
     * @return login page
     */
    public Result loginPage(Http.Request request) {
        return ok(views.html.login.render(request));
    }

    public Result logout() {
        return redirect("/").withNewSession();
    }

    /**
     * This method is login handler, check username and password then login to user detail page.
     * @return
     */
    public Result loginHandler(Http.Request request) {
        try {
            Form loginForm = userForm.bindFromRequest(request);
            if (loginForm.hasErrors()) {
                return redirect("/login").flashing("error","login form errors");  // send parameter like register so that user could know
            } else {
                String username = loginForm.field("username").value().get();
                String password = loginForm.field("password").value().get();
                ObjectNode jsonData = Json.newObject();
                jsonData.put("username", username);
                jsonData.put("password", password);
                JsonNode response = restfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_LOGIN), jsonData);
                System.out.println("Response: " + response.toString());
                if (response.has("false") || response.has("error")) {
                    return redirect("/login").flashing("error", response.get("error").asText());
                } else {
                    System.out.println("Pass User Authenticate... And User info: " + response.toString());
                    User curUser = Json.fromJson(response, User.class);
                    return redirect("/detail").addingToSession(request, "id", curUser.getId().toString());
                }

            }
        } catch (Exception e){
            Logger.debug("UserController.loginHandler exception: " + e);
            return redirect("/");
        }
    }
    /*********************************************** END USER LOGIN ***************************************************/

    /************************************************* USER SIGN UP ***************************************************/
    /**
     * This method intends to help user register a new account in system.
     * @return
     */
    public Result signupHandler(Http.Request request) {
        try{
            Form<User> registrationForm = formFactory.form(User.class).bindFromRequest(request);
            if (registrationForm.hasErrors()){
                return badRequest(views.html.register.render(request));
            }

            ObjectNode jsonData = (ObjectNode)(Json.toJson(registrationForm.rawData()));
            JsonNode response = restfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_REGISTER_POST), jsonData);
            if(!response.has("error")){
                return redirect("/login").flashing("success", "Register successfully, please log in.");
            } else{
                Logger.debug("UserController user sign up backend error");
                return redirect("/signup").flashing("error", "Register failed, please try again.");
            }

        } catch (Exception e){
            e.printStackTrace();
            Logger.debug("UserController user sign up Exception: " + e.toString());
            return redirect("/singup").flashing("error", "Register failed, please try again.");
        }
    }
    /********************************************** END USER SIGN UP **************************************************/

    /********************************************** USER EDIT ****** **************************************************/
    /**
     * This method receives user's information and updates user's profile
     *
     * @return redirect to user detail page if the update succeeds or to log in page if update failed
     */
    public Result editHandler(Http.Request request){
        try {
            Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);
            if (userForm.hasErrors()){
                return redirect("/login").flashing("error","Fail to update User Info Sorry! Please log in again. ");
            } else{
                ObjectNode jsonData = (ObjectNode)(Json.toJson(userForm.rawData()));
                // jsonData.put("id", session("id"));
                System.out.println("User Edit Info From Page: " + jsonData.toString());
                JsonNode response = restfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_UPDATE_POST), jsonData);
                if(response == null || response.has("error")){
                    Logger.debug("User Edit Failed.");
                    return redirect("/login").flashing("error","Fail to update User Info Sorry! Please log in again. ");
                } else{
                    User currentUser = Json.fromJson(response, User.class);
                    return ok(views.html.detail.render(currentUser));
                }
            }
        } catch (Exception e) {
            Logger.debug("UserController.editHandler exception: " + e.toString());
            return redirect("/login").flashing("error","Fail to update User Info Sorry! Please log in again. ");
        }
    }
    /******************************************* END USER EDIT ****** *************************************************/

}