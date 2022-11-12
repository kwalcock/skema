package org.ml4ai.skema.gromet.generator

import org.openapitools.codegen.{DefaultGenerator, Generator}
import org.openapitools.codegen.config.CodegenConfigurator

import java.io.File
import scala.collection.JavaConverters._

abstract class OpenApiCodeGenerator(val generator: Generator) extends CodeGenerator {

  def generateFiles(): Seq[File] = {
    val generatedFiles = generator.generate.asScala

    generatedFiles
  }

  def generate(): Unit = {
    generateFiles()
  }
}

class JavaOpenApiGenerator(generator: Generator) extends OpenApiCodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class PythonOpenApiGenerator(generator: Generator) extends OpenApiCodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class ScalaOpenApiGenerator(generator: Generator) extends OpenApiCodeGenerator(generator) {
  //  cliOptions.add(new CliOption(CodegenConstants.MODEL_PACKAGE, CodegenConstants.MODEL_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.API_PACKAGE, CodegenConstants.API_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.SOURCE_FOLDER, CodegenConstants.SOURCE_FOLDER_DESC));

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

object OpenApiCodeGenerator extends TripleCodeGenerator {

  def newGenerator(lang: String, inputSpec: String, outputDirname: String): Generator = {
    val configurator = {
      val configurator = new CodegenConfigurator()
          .setGeneratorName(lang)
          .setInputSpec(inputSpec)
          .setModelNamePrefix("io.swagger")
          .setOutputDir(outputDirname)

      configurator
    }
    val clientOptInput = configurator.toClientOptInput
    val generator = new DefaultGenerator().opts(clientOptInput)

    generator
  }

  def newJavaGenerator(inputSpec: String, outputDirname: String): OpenApiCodeGenerator =
      new JavaOpenApiGenerator(newGenerator("java", inputSpec, outputDirname))

  def newPythonGenerator(inputSpec: String, outputDirname: String): OpenApiCodeGenerator =
      new PythonOpenApiGenerator(newGenerator("python", inputSpec, outputDirname))

  def newScalaGenerator(inputSpec: String, outputDirname: String): OpenApiCodeGenerator =
      new ScalaOpenApiGenerator(newGenerator("scala", inputSpec, outputDirname))
}
