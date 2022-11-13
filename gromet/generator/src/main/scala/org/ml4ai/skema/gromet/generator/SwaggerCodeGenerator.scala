package org.ml4ai.skema.gromet.generator

import io.swagger.codegen.v3.{CodegenArgument, DefaultGenerator, Generator}
import io.swagger.codegen.v3.config.CodegenConfigurator

import scala.collection.JavaConverters._
import java.io.File
import scala.collection.mutable

abstract class SwaggerCodeGenerator(val generator: Generator) extends CodeGenerator {

  def generateFiles(): Seq[File] = {
    val generatedFiles = generator.generate.asScala

    generatedFiles
  }

  def generate(): Unit = {
    generateFiles()
  }
}

class JavaSwaggerGenerator(generator: Generator) extends SwaggerCodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class PythonSwaggerGenerator(generator: Generator) extends SwaggerCodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class ScalaSwaggerGenerator(generator: Generator) extends SwaggerCodeGenerator(generator) {
  //  cliOptions.add(new CliOption(CodegenConstants.MODEL_PACKAGE, CodegenConstants.MODEL_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.API_PACKAGE, CodegenConstants.API_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.SOURCE_FOLDER, CodegenConstants.SOURCE_FOLDER_DESC));

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

object SwagCodeGenerator extends TripleCodeGenerator {

  def newGenerator(lang: String, inputSpec: String, outputDirname: String): Generator = {
    val configurator = {
      val configurator = new CodegenConfigurator()
      val additionalProperties = mutable.Map[String, AnyRef](
//        "modelPropertyNaming" -> "original"
      ).asJava

      configurator.setLang(lang)
      configurator.setInputSpec(inputSpec)
      configurator.setOutputDir(outputDirname)
      configurator.setModelPackage(s"org.ml4ai.skema.gromet.model.swagger.$lang")
      configurator.setAdditionalProperties(additionalProperties)
      configurator.setVerbose(true)
      configurator
    }
    val clientOptInput = configurator.toClientOptInput
    val generator = new DefaultGenerator().opts(clientOptInput)

    generator
  }

  def newJavaGenerator(inputSpec: String, outputDirname: String): SwaggerCodeGenerator =
      new JavaSwaggerGenerator(newGenerator("java", inputSpec, outputDirname))

  def newPythonGenerator(inputSpec: String, outputDirname: String): SwaggerCodeGenerator =
      new PythonSwaggerGenerator(newGenerator("python", inputSpec, outputDirname))

  def newScalaGenerator(inputSpec: String, outputDirname: String): SwaggerCodeGenerator =
      new ScalaSwaggerGenerator(newGenerator("scala", inputSpec, outputDirname))
}
