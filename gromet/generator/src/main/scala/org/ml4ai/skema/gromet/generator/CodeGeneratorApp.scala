package org.ml4ai.skema.gromet.generator

import io.swagger.codegen.v3.generators.java.JavaClientCodegen
import io.swagger.codegen.v3.generators.python.PythonClientCodegen
import io.swagger.codegen.v3.generators.scala.ScalaClientCodegen

object CodeGeneratorApp extends App {
  val version = "0.1.4"
  val fnFilename = s"../gromet_FN_v$version.yaml"
  val metadataFilename = s"../gromet_metadata_v$version.yaml"
  // combine the files above into a single file

  val generators = Seq() // Make classes for each, each having own directories
  val javaGenerator = new JavaClientCodegen()
  val pythonGenerator = new PythonClientCodegen()
  val scalaGenerator = new ScalaClientCodegen()

//  cliOptions.add(new CliOption(CodegenConstants.MODEL_PACKAGE, CodegenConstants.MODEL_PACKAGE_DESC));
//  cliOptions.add(new CliOption(CodegenConstants.API_PACKAGE, CodegenConstants.API_PACKAGE_DESC));
//  cliOptions.add(new CliOption(CodegenConstants.SOURCE_FOLDER, CodegenConstants.SOURCE_FOLDER_DESC));
}
