name := "gromet-generator"

libraryDependencies ++= {
  Seq(
    // "io.swagger.codegen.v3" % "swagger-codegen-generators" % "1.0.35",
    "io.swagger.codegen.v3" % "swagger-codegen-cli" % "3.0.35",
    "org.yaml"              % "snakeyaml"           % "1.14"
  )
}
