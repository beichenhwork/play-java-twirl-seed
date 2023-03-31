
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,User,play.twirl.api.HtmlFormat.Appendable] {

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
                <strong>Login Message</strong>
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
                  DATE: 2023-03-31T14:55:26.398
                  SOURCE: /Users/beichenhu/IntelliJProjects/Lab-2-Ebean/Frontend/app/views/detail.scala.html
                  HASH: c46f2b1e7153a35b4628fc2cf419ad9e15e4d8ee
                  MATRIX: 953->1|1080->35|1107->36|1442->344|1470->351|1530->384|1565->410|1605->412|1646->425|1800->552|1817->560|1844->566|1931->622|1969->633|2043->698|2083->700|2124->713|2280->842|2297->850|2330->862|2417->918|2454->928|2530->995|2570->997|2611->1010|2765->1137|2782->1145|2816->1158|2903->1214|2940->1224|3014->1289|3054->1291|3095->1304|3248->1430|3265->1438|3298->1450|3385->1506|3423->1517|3556->1623|3571->1629|3619->1655|3796->1805|3811->1811|3863->1841
                  LINES: 28->1|33->2|34->3|43->12|43->12|46->15|46->15|46->15|47->16|50->19|50->19|50->19|53->22|55->24|55->24|55->24|56->25|59->28|59->28|59->28|62->31|63->32|63->32|63->32|64->33|67->36|67->36|67->36|70->39|71->40|71->40|71->40|72->41|75->44|75->44|75->44|78->47|81->50|82->51|82->51|82->51|85->54|85->54|85->54
                  -- GENERATED --
              */
          