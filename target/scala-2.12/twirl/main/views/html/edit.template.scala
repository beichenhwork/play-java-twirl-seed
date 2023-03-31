
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

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[models.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Play User Edit Page Demo</title>
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
                <strong>Play User Edit Page Demo</strong>
            </h1>
        </header>


        <div class="row">
            <div class="card col s4 offset-s4 ">
                <div class="card-panel">
                    <form action=""""),_display_(/*31.36*/routes/*31.42*/.UserController.editHandler()),format.raw/*31.71*/("""" method="GET">

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="id" name="id" type="text" class="validate" value=""""),_display_(/*35.95*/user/*35.99*/.getId),format.raw/*35.105*/("""" readonly>
                                <label for="id">User ID</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="username" name="username" type="text" class="validate" value=""""),_display_(/*41.107*/user/*41.111*/.getUsername),format.raw/*41.123*/("""" readonly>
                                <label for="username">User Name</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" name="password" type="text" class="validate" value=""""),_display_(/*48.107*/user/*48.111*/.getPassword),format.raw/*48.123*/("""" readonly>
                                <label for="password">Password</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="firstName" name="firstName" type="text" class="validate" value=""""),_display_(/*55.109*/user/*55.113*/.getFirstName),format.raw/*55.126*/("""">
                                <label for="firstName">First Name</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">

                                <input id="lastName" name="lastName" type="text" class="validate" value=""""),_display_(/*63.107*/user/*63.111*/.getLastName),format.raw/*63.123*/("""">
                                <label for="lastName">Last Name</label>
                            </div>
                        </div>


                        <div class="center actions row">
                            <div class="input-field col s12">
                                <button id="api-search-button" class="btn waves-effect waves-light blue darken-2" type="submit">Update</button>
                                <a href=""""),_display_(/*72.43*/routes/*72.49*/.UserController.detailPage("Edit User Canceled")),format.raw/*72.97*/("""" class ="btn waves-effect waves-light green darken-2">Cancel</a>
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

  def render(user:models.User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((models.User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2023-03-31T16:59:20.002974
                  SOURCE: /Users/beichenhu/IntelliJProjects/play-java-twirl-seed/app/views/edit.scala.html
                  HASH: d124a64d7d51139ab94e193773e61a2b441711dd
                  MATRIX: 952->1|1065->21|2671->1602|2686->1608|2736->1637|2978->1852|2991->1856|3019->1862|3399->2214|3413->2218|3447->2230|3836->2591|3850->2595|3884->2607|4274->2969|4288->2973|4323->2986|4706->3341|4720->3345|4754->3357|5229->3805|5244->3811|5313->3859
                  LINES: 28->1|33->2|62->31|62->31|62->31|66->35|66->35|66->35|72->41|72->41|72->41|79->48|79->48|79->48|86->55|86->55|86->55|94->63|94->63|94->63|103->72|103->72|103->72
                  -- GENERATED --
              */
          