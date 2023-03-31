// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/beichenhu/IntelliJProjects/play-java-twirl-seed/conf/routes
// @DATE:Fri Mar 31 16:59:19 CDT 2023

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:13
  Assets_0: controllers.Assets,
  // @LINE:18
  UserController_2: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:13
    Assets_0: controllers.Assets,
    // @LINE:18
    UserController_2: controllers.UserController
  ) = this(errorHandler, HomeController_1, Assets_0, UserController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, UserController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.loginHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """detail/""" + "$" + """message<[^/]+>""", """controllers.UserController.detailPage(message:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.UserController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.UserController.signupHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edit""", """controllers.UserController.editPage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editPOST""", """controllers.UserController.editHandler()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page
######################################## Home Page ####################################################################""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """######################################## Assets #######################################################################
 Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UserController_loginHandler2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_loginHandler2_invoker = createInvoker(
    UserController_2.loginHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "loginHandler",
      Nil,
      "GET",
      this.prefix + """login""",
      """######################################## Login Page ###################################################################""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UserController_detailPage3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("detail/"), DynamicPart("message", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_detailPage3_invoker = createInvoker(
    UserController_2.detailPage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "detailPage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """detail/""" + "$" + """message<[^/]+>""",
      """######################################## Users #### ###################################################################""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_UserController_signup4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_UserController_signup4_invoker = createInvoker(
    UserController_2.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signup",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_UserController_signupHandler5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_UserController_signupHandler5_invoker = createInvoker(
    UserController_2.signupHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signupHandler",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_UserController_editPage6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edit")))
  )
  private[this] lazy val controllers_UserController_editPage6_invoker = createInvoker(
    UserController_2.editPage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "editPage",
      Nil,
      "GET",
      this.prefix + """edit""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_UserController_editHandler7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editPOST")))
  )
  private[this] lazy val controllers_UserController_editHandler7_invoker = createInvoker(
    UserController_2.editHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "editHandler",
      Nil,
      "GET",
      this.prefix + """editPOST""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index())
      }
  
    // @LINE:13
    case controllers_Assets_at1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_0.at(path, file))
      }
  
    // @LINE:18
    case controllers_UserController_loginHandler2_route(params@_) =>
      call { 
        controllers_UserController_loginHandler2_invoker.call(UserController_2.loginHandler())
      }
  
    // @LINE:23
    case controllers_UserController_detailPage3_route(params@_) =>
      call(params.fromPath[String]("message", None)) { (message) =>
        controllers_UserController_detailPage3_invoker.call(UserController_2.detailPage(message))
      }
  
    // @LINE:24
    case controllers_UserController_signup4_route(params@_) =>
      call { 
        controllers_UserController_signup4_invoker.call(UserController_2.signup())
      }
  
    // @LINE:25
    case controllers_UserController_signupHandler5_route(params@_) =>
      call { 
        controllers_UserController_signupHandler5_invoker.call(UserController_2.signupHandler())
      }
  
    // @LINE:26
    case controllers_UserController_editPage6_route(params@_) =>
      call { 
        controllers_UserController_editPage6_invoker.call(UserController_2.editPage())
      }
  
    // @LINE:27
    case controllers_UserController_editHandler7_route(params@_) =>
      call { 
        controllers_UserController_editHandler7_invoker.call(UserController_2.editHandler())
      }
  }
}
