/**
 * This is an example Play project that uses Twirl templates.
 */
name := "play-java-twirl-seed"
version := "1.0"
scalaVersion := "2.13.10"

lazy val `client` = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(ehcache , javaWs , specs2 % Test , guice )

//unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )


      