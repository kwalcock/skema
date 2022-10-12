name := "gromet"
version := "1.0.0"

val scala11 = "2.11.12" // up to 2.11.12
val scala12 = "2.12.16" // up to 2.12.16
val scala13 = "2.13.8"  // up to 2.13.8

ThisBuild / crossScalaVersions := Seq(scala12, scala11, scala13)
ThisBuild / scalaVersion := scala12

libraryDependencies ++= {
  Seq(
  )
}

lazy val root = (project in file("."))
  .aggregate(common, generator, java, scala)
  .dependsOn(/*common % "compile -> compile; test -> test"*/)
  .settings(
    publish / skip := true
  )

lazy val common = project

lazy val generator = project
  .dependsOn(common % "compile -> compile; test -> test")

lazy val java = project
 .dependsOn(common % "compile -> compile; test -> test")

lazy val scala = project
 .dependsOn(common % "compile -> compile; test -> test")
