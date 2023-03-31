
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object detail extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, userinfo: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <body>
        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #57a957">
                <strong>Play User Detail Page Demo</strong>
            </h1>
            <p class="focused" style="font-size: 20px;
                color: #3F51B5">"""),_display_(/*12.34*/message),format.raw/*12.41*/("""</p>
        </header>

        """),_display_(/*15.10*/if(userinfo.getId()!=null)/*15.36*/ {_display_(Seq[Any](format.raw/*15.38*/("""
            """),format.raw/*16.13*/("""<div class="row">
                <div class="col s12">
                    <h6>User Account ID: </h6>
                    <p>"""),_display_(/*19.25*/userinfo/*19.33*/.getId),format.raw/*19.39*/("""</p>
                </div>
            </div>
        """)))}),format.raw/*22.10*/("""

        """),_display_(/*24.10*/if(userinfo.getUsername()!=null && !userinfo.getUsername.isEmpty)/*24.75*/ {_display_(Seq[Any](format.raw/*24.77*/("""
            """),format.raw/*25.13*/("""<div class="row">
                <div class="col s12">
                    <h6>User Account Name: </h6>
                    <p>"""),_display_(/*28.25*/userinfo/*28.33*/.getUsername),format.raw/*28.45*/("""</p>
                </div>
            </div>
        """)))}),format.raw/*31.10*/("""
        """),_display_(/*32.10*/if(userinfo.getFirstName()!=null && !userinfo.getFirstName.isEmpty)/*32.77*/ {_display_(Seq[Any](format.raw/*32.79*/("""
            """),format.raw/*33.13*/("""<div class="row">
                <div class="col s12">
                    <h6>User First Name: </h6>
                    <p>"""),_display_(/*36.25*/userinfo/*36.33*/.getFirstName),format.raw/*36.46*/("""</p>
                </div>
            </div>
        """)))}),format.raw/*39.10*/("""
        """),_display_(/*40.10*/if(userinfo.getLastName()!=null && !userinfo.getLastName.isEmpty)/*40.75*/ {_display_(Seq[Any](format.raw/*40.77*/("""
            """),format.raw/*41.13*/("""<div class="row">
                <div class="col s12">
                    <h6>User Last Name: </h6>
                    <p>"""),_display_(/*44.25*/userinfo/*44.33*/.getLastName),format.raw/*44.45*/("""</p>
                </div>
            </div>
        """)))}),format.raw/*47.10*/("""


        """),format.raw/*50.9*/("""<div class="row">
            <a id="api-search-button" class="btn col s4 offset-s4" type="submit" href=""""),_display_(/*51.89*/routes/*51.95*/.UserController.editPage()),format.raw/*51.121*/("""">Edit User Info</a>
        </div>
        <div class="row">
            <a id="api-search-button" class="btn col s4 offset-s4" type="submit" href=""""),_display_(/*54.89*/routes/*54.95*/.UserController.loginHandler()),format.raw/*54.125*/("""">Back To Login Page</a>
        </div>

    </body>
</html>
"""))
      }
    }
  }

  def render(message:String,userinfo:User): play.twirl.api.HtmlFormat.Appendable = apply(message,userinfo)

  def f:((String,User) => play.twirl.api.HtmlFormat.Appendable) = (message,userinfo) => apply(message,userinfo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2023-03-31T16:17:19.531
                  SOURCE: /Users/beichenhu/IntelliJProjects/Lab-2-Ebean/Frontend/app/views/detail.scala.html
                  HASH: f8f8f0b781797478eff39e3d42de0d487ff50307
                  MATRIX: 954->1|1081->35|1108->36|1456->357|1484->364|1544->397|1579->423|1619->425|1660->438|1814->565|1831->573|1858->579|1945->635|1983->646|2057->711|2097->713|2138->726|2294->855|2311->863|2344->875|2431->931|2468->941|2544->1008|2584->1010|2625->1023|2779->1150|2796->1158|2830->1171|2917->1227|2954->1237|3028->1302|3068->1304|3109->1317|3262->1443|3279->1451|3312->1463|3399->1519|3437->1530|3570->1636|3585->1642|3633->1668|3810->1818|3825->1824|3877->1854
                  LINES: 28->1|33->2|34->3|43->12|43->12|46->15|46->15|46->15|47->16|50->19|50->19|50->19|53->22|55->24|55->24|55->24|56->25|59->28|59->28|59->28|62->31|63->32|63->32|63->32|64->33|67->36|67->36|67->36|70->39|71->40|71->40|71->40|72->41|75->44|75->44|75->44|78->47|81->50|82->51|82->51|82->51|85->54|85->54|85->54
                  -- GENERATED --
              */
          