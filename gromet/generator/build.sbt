name := "gromet-generator"

libraryDependencies ++= {
  Seq(
    "io.swagger.codegen.v3" % "swagger-codegen-cli"   % "3.0.35",
    "org.openapitools"      % "openapi-generator-cli" % "6.2.0",
    "org.yaml"              % "snakeyaml"             % "1.14"
  )
}
