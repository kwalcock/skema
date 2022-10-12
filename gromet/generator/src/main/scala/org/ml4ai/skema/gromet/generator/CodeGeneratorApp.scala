package org.ml4ai.skema.gromet.generator

import scala.io.{Codec, Source}

object CodeGeneratorApp extends App {
  val version = "0.1.4"
  val fnFilename = s"./gromet_FN_v$version.yaml"
  val metadataFilename = s"./gromet_metadata_v$version.yaml"
  val outputDirname = "../../exampleoutput/"
  // combine the files above into a single file
  // maybe move it to temp

  val source = Source.fromFile(fnFilename)(Codec.UTF8)
  val text = source.mkString
  source.close()

  //  inputFilename: String, outputDirname: String
  val codeGenerators = Seq(
    CodeGenerator.newJavaGenerator(text, outputDirname + "java") //,
//    CodeGenerator.newPythonGenerator(fnFilename, outputDirname + "python"),
//    CodeGenerator.newScalaGenerator(fnFilename, outputDirname + "scala")
  )

  codeGenerators.foreach(_.generate)
}
