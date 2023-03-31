// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/beichenhu/IntelliJProjects/play-java-twirl-seed/conf/routes
// @DATE:Fri Mar 31 16:59:19 CDT 2023


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
