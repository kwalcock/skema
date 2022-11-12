package org.ml4ai.skema.gromet.generator

trait TripleCodeGenerator {
  def newJavaGenerator(inputSpec: String, outputDirname: String): CodeGenerator
  def newPythonGenerator(inputSpec: String, outputDirname: String): CodeGenerator
  def newScalaGenerator(inputSpec: String, outputDirname: String): CodeGenerator
}
