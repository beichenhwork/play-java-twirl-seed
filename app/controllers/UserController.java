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
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSResponse;
import services.UserService;
import utils.Constants;
import utils.RESTfulCalls;
import views.html.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static controllers.Applications.*;

/**
 * @description: user service functions
 * @author: Junhao Shen, Beichen Hu
 * @create: 2023-03-30
 */
public class UserController extends Controller {

    @Inject
    HttpExecutionContext ec;

    @Inject
    Config config;

    private FormFactory formFactory;
    private  Form<User> userForm;
    private UserService userService;

    /********************************************** CONSTRUCTOR *******************************************************/
    @Inject
    public UserController(FormFactory formFactory, UserService userService) {
        this.userService = userService;
        this.formFactory = formFactory;
        this.userForm = formFactory.form(User.class);
    }
    /********************************************** END CONSTRUCTOR ***************************************************/


    /********************************************** USER SERVICE PAGE *************************************************/

    /**
     * render user signup page
     */
    public Result signup() {
        return ok(views.html.register.render("Welcome to register new account in SMU-CS-HUB!"));
    }

    /**
     * render user detail page
     * @return
     */
    public Result detailPage(String message){
        try{
            checkLoginStatus();
            String userId = session("id");

            JsonNode userNode = RESTfulCalls.getAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_DETAIL_BY_ID + userId));

            if(userNode == null || userNode.has("error")){
                Logger.debug("UserController.detailPage cannot find user from backend");
                return ok(login.render("Cannot go to detail page, please log in again."));
            }else{
                Logger.info("Current User Info: " + userNode.toString());
                User curUser = Json.fromJson(userNode, User.class);
                return ok(detail.render(message, curUser));
            }
        } catch (Exception e){
            Logger.debug("UserController.detailPage exception: "+ e.toString());
            return ok(login.render("Fail to edit, please log in again. "));
        }

    }

    /**
     * render user edit page
     * @return
     */
    public Result editPage() {
        checkLoginStatus();
        String userId = session("id");
        try{
            JsonNode userNode = RESTfulCalls.getAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_DETAIL_BY_ID + userId));
            if(userNode == null || userNode.has("error")){
                Logger.debug("UserController.editPage cannot find user from backend");
                return ok(login.render("Update failed, please log in again."));
            }else{
                Logger.info("Current Edit User Info: " + userNode.toString());
                User curUser = Json.fromJson(userNode, User.class);
                return ok(edit.render(curUser));
            }
        } catch (Exception e){
            Logger.debug("UserController.editPage exception: "+ e.toString());
            return ok(login.render("Fail to edit, please log in again. "));
        }
    }

    /******************************************* END USER SERVICE PAGE ************************************************/


    /*************************************************** USER LOGIN ***************************************************/
    /**
     * This method is login handler, check username and password then login to user detail page.
     * @return
     */
    public Result loginHandler() {
        try {
            Form loginForm = formFactory.form().bindFromRequest();

            if (loginForm.hasErrors()) {
                return badRequest(login.render("Cannot Login."));  // send parameter like register so that user could know
            } else {

                String username = loginForm.field("username").value().get();
                String password = loginForm.field("password").value().get();

                ObjectNode jsonData = Json.newObject();
                jsonData.put("username", username);
                jsonData.put("password", password);

                JsonNode response = RESTfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_LOGIN), jsonData);
                if (response.has("false") || response.has("error")) {
                    flash("error", "Invalid email or password");
                    return ok(login.render("Invalid email or password"));
                } else {
                    System.out.println("Pass User Authenticate... And User info: " + response.toString());
                    User curUser = Json.fromJson(response, User.class);
                    session().clear();
                    session("username", curUser.getUsername());
                    session("id", curUser.getId()+"");
                    return ok(detail.render("Login Successful", curUser));
                }

            }
        } catch (Exception e){
            Logger.debug("UserController.loginHandler exception: " + e);
            return redirect(routes.HomeController.index());
        }
    }
    /*********************************************** END USER LOGIN ***************************************************/

    /************************************************* USER SIGN UP ***************************************************/
    /**
     * This method intends to help user register a new account in system.
     * @return
     */
    public Result signupHandler() {
        try{
            Form<User> registrationForm = formFactory.form(User.class).bindFromRequest();
            if (registrationForm.hasErrors()){
                return badRequest(register.render("Fields error, please sign up again."));
            }

            ObjectNode jsonData = (ObjectNode)(Json.toJson(registrationForm.rawData()));
            JsonNode response = RESTfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_REGISTER_POST), jsonData);
            if(!response.has("error")){
                return ok(login.render("Register successfully!"));
            } else{
                Logger.debug("UserController user sign up backend error");
                return badRequest(login.render(response.get("error").asText()));
            }

        } catch (Exception e){
            e.printStackTrace();
            Logger.debug("UserController user sign up Exception: " + e.toString());
            return badRequest(login.render("Register failed, please try it again."));
        }
    }
    /********************************************** END USER SIGN UP **************************************************/

    /********************************************** USER EDIT ****** **************************************************/
    /**
     * This method receives user's information and updates user's profile
     *
     * @return redirect to user detail page if the update succeeds or to log in page if update failed
     */
    public Result editHandler() {
        try {
            checkLoginStatus();
            Form<User> userForm = formFactory.form(User.class).bindFromRequest();
            if (userForm.hasErrors()){
                return badRequest(login.render("Fail to update User Info Sorry! Please log in again. "));
            } else{
                ObjectNode jsonData = (ObjectNode)(Json.toJson(userForm.rawData()));
                // jsonData.put("id", session("id"));
                System.out.println("User Edit Info From Page: " + jsonData.toString());
                JsonNode response = RESTfulCalls.postAPI(RESTfulCalls.getBackendAPIUrl(config, Constants.USER_UPDATE_POST), jsonData);
                if(response == null || response.has("error")){
                    Logger.debug("User Edit Failed.");
                    return badRequest(login.render("Update User Info failed. Please log in again. "));
                } else{
                    User currentUser = Json.fromJson(response, User.class);
                    return ok(detail.render("Update successfully. ", currentUser));
                }
            }
        } catch (Exception e) {
            Logger.debug("UserController.editHandler exception: " + e.toString());
            return ok(login.render("Fail to update User Info Sorry! Please log in again. "));
        }
    }
    /******************************************* END USER EDIT ****** *************************************************/

}