version := "1.0.0"
name := "swagger-java-client"
organization := "io.swagger"
// scalaVersion := "2.11.4",

libraryDependencies ++= Seq(
  "io.swagger.core.v3"   % "swagger-annotations"  % "2.0.0",
  "com.squareup.okhttp"  % "okhttp"               % "2.7.5",
  "com.squareup.okhttp"  % "logging-interceptor"  % "2.7.5",
  "com.google.code.gson" % "gson"                 % "2.8.1",
  "io.gsonfire"          % "gson-fire"            % "1.8.3"  % "compile",
  "org.threeten"         % "threetenbp"           % "1.3.5"  % "compile",
  "javax.annotation"     % "javax.annotation-api" % "1.3.2"  % "compile",
  "junit"                % "junit"                % "4.12"   % "test",
  "com.novocode"         % "junit-interface"      % "0.10"   % "test",
  "org.scalatest"       %% "scalatest"            % "3.0.4"  % "test"

)

resolvers += Resolver.mavenLocal

scalacOptions ++= Seq("-feature")

compile / javacOptions ++= Seq("-Xlint:deprecation")

Compile / packageDoc / publishArtifact := false
