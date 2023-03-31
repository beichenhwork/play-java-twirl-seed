
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(authorizeMessage: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Play User Sign Up Page Demo</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

            <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
    </head>
    <body>

        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #57a957">
                <strong>Play User Sign Up Page Demo</strong>
            </h1>
        </header>


        <div class="row">
            <div class="card col s4 offset-s4 ">
                <div class="card-panel">
                    <form action=""""),_display_(/*31.36*/routes/*31.42*/.UserController.signupHandler()),format.raw/*31.73*/("""" method="GET">

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="username" name="username" type="text" class="validate">
                                <label for="username">Username</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">

                                <input id="password" name="password" type="password" class="validate">
                                <label for="password">Password</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">

                                <input id="firstName" name="firstName" type="text" class="validate">
                                <label for="firstName">First Name</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">

                                <input id="lastName" name="lastName" type="text" class="validate">
                                <label for="lastName">Last Name</label>
                            </div>
                        </div>
                        """),_display_(/*62.26*/if(authorizeMessage!= null)/*62.53*/{_display_(Seq[Any](format.raw/*62.54*/("""
                            """),format.raw/*63.29*/("""<div class="alert alert-primary" role="alert">
                            """),_display_(/*64.30*/authorizeMessage),format.raw/*64.46*/("""
                            """),format.raw/*65.29*/("""</div>
                            <br>
                        """)))}),format.raw/*67.26*/("""

                        """),format.raw/*69.25*/("""<div class="center actions row">
                            <div class="input-field col s12">
                                <button id="api-search-button" class="btn waves-effect waves-light blue darken-2" type="submit">Submit</button>
                                <a href=""""),_display_(/*72.43*/routes/*72.49*/.HomeController.index()),format.raw/*72.72*/("""" class ="btn waves-effect waves-light green darken-2">Cancel</a>
                            </div>
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(authorizeMessage:String): play.twirl.api.HtmlFormat.Appendable = apply(authorizeMessage)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (authorizeMessage) => apply(authorizeMessage)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2023-03-31T16:18:43
                  SOURCE: /Users/beichenhu/IntelliJProjects/Lab-2-Ebean/Frontend/app/views/register.scala.html
                  HASH: 1861a2289d3fa000f92bc94eb44457696894ea70
                  MATRIX: 951->1|1071->28|2683->1615|2698->1621|2750->1652|4194->3069|4230->3096|4269->3097|4326->3126|4429->3202|4466->3218|4523->3247|4619->3312|4673->3338|4981->3619|4996->3625|5040->3648
                  LINES: 28->1|33->2|62->31|62->31|62->31|93->62|93->62|93->62|94->63|95->64|95->64|96->65|98->67|100->69|103->72|103->72|103->72
                  -- GENERATED --
              */
          