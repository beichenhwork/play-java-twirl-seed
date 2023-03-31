package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;

/**
 * Application tools and functions for current project.
 * @author: Beichen Hu
 * @create: 2023-03-30
 */
public class Applications extends Controller {
    public static Result checkLoginStatus(){
        if(session("id") == null || session("username") == null){
            Logger.debug("User has not logged in. ");
            return redirect(routes.HomeController.index());
        }
        return ok();
    }
}
