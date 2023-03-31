// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/beichenhu/IntelliJProjects/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Fri Mar 31 15:28:48 CDT 2023


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
