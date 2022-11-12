version := "1.0.0"
name := "swagger-scala-client"
// organization := "io.swagger"
// scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.2",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.9.2",
  "com.sun.jersey" % "jersey-core" % "1.19.4",
  "com.sun.jersey" % "jersey-client" % "1.19.4",
  "com.sun.jersey.contribs" % "jersey-multipart" % "1.19.4",
  "org.jfarcand" % "jersey-ahc-client" % "1.0.5",
  "io.swagger" % "swagger-core" % "1.5.8",
  "joda-time" % "joda-time" % "2.9.9",
  "org.joda" % "joda-convert" % "1.9.2",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "junit" % "junit" % "4.12" % "test",
  // This one is no longer available as a library, but the source is included directly.
  // All its dependencies need to be added here.
  "com.wordnik.swagger" %% "swagger-async-httpclient" % "0.3.5"
//  "org.scalatra.rl" %% "rl" % "0.4.10",
//  "org.slf4j" % "slf4j-api" % "1.7.7",
//  "org.json4s" %% "json4s-jackson" % "3.4.2", // "3.2.10"
//  "com.googlecode.juniversalchardet" % "juniversalchardet" % "1.0.3",
//  "eu.medsea.mimeutil" % "mime-util" % "2.1.3", // exclude some things
//  "com.ning" % "async-http-client" % "1.8.14",
//  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
)

resolvers ++= Seq(
  Resolver.mavenLocal
)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature"
)

Compile / packageDoc / publishArtifact := false

