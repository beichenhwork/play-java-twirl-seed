package controllers;

import play.mvc.Http;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * @description: index page controller
 * @author: Junhao Shen, Beichen Hu
 * @create: 2023-03-30
 */
public class HomeController extends Controller {
    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * Index page
     */
    public Result index(Http.Request request) {
        return redirect("/login").flashing("success", "Welcome to SMU-CS-HUB!");
    }

}