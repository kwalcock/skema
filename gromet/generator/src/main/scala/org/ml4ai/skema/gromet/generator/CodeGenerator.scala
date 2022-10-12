package org.ml4ai.skema.gromet.generator

import io.swagger.codegen.v3.{ClientOptInput, DefaultGenerator, Generator}
import io.swagger.codegen.v3.config.CodegenConfigurator

import scala.collection.JavaConverters._
import java.io.File

abstract class CodeGenerator(val generator: Generator) {

  def generateFiles(): Seq[File] = {
    val generatedFiles = generator.generate.asScala

    generatedFiles
  }

  def generate(): Unit = {
    generateFiles()
  }
}

class JavaGenerator(generator: Generator) extends CodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class PythonGenerator(generator: Generator) extends CodeGenerator(generator) {

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

class ScalaGenerator(generator: Generator) extends CodeGenerator(generator) {
  //  cliOptions.add(new CliOption(CodegenConstants.MODEL_PACKAGE, CodegenConstants.MODEL_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.API_PACKAGE, CodegenConstants.API_PACKAGE_DESC));
  //  cliOptions.add(new CliOption(CodegenConstants.SOURCE_FOLDER, CodegenConstants.SOURCE_FOLDER_DESC));

  override def generate(): Unit = {
    val generatedFiles = generateFiles()
    // Now do something with the files.

  }
}

object CodeGenerator {

  def newGenerator(lang: String, inputFilename: String, outputDirname: String): Generator = {
    val configurator = {
      val configurator = new CodegenConfigurator()

      configurator.setLang(lang)
      configurator.setInputSpec(inputFilename)
      configurator.setOutputDir(outputDirname)
      configurator
    }
    val clientOptInput = configurator.toClientOptInput
    val generator = new DefaultGenerator().opts(clientOptInput)

    generator
  }

  def newJavaGenerator(inputFilename: String, outputDirname: String): CodeGenerator =
      new JavaGenerator(newGenerator("java", inputFilename, outputDirname))

  def newPythonGenerator(inputFilename: String, outputDirname: String): CodeGenerator =
      new PythonGenerator(newGenerator("python", inputFilename, outputDirname))

  def newScalaGenerator(inputFilename: String, outputDirname: String): CodeGenerator =
      new ScalaGenerator(newGenerator("scala", inputFilename, outputDirname))
}
