package org.ml4ai.skema.gromet.generator

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.StringWriter
import java.util.{LinkedHashMap => JLinkedHashMap }
import java.util.{Map => JMap}
import scala.io.{Codec, Source}

object CodeGeneratorApp extends App {
  val version = "0.1.4"
  val fnFilename = s"./gromet_FN_v$version.yaml"
  val metadataFilename = s"./gromet_metadata_v$version.yaml"
  val outputDirname = "../../exampleoutput/"

  def mkInputSpec(filename: String): String = {
    val source = Source.fromFile(filename)(Codec.UTF8)
    val inputSpec =
        try {
          source.mkString
        }
        finally {
          source.close()
        }

    inputSpec
  }
  def mkInputSpec(fnFilename: String, metadataFilename: String): String = {
    val fnInput = mkInputSpec(fnFilename)
    val metadataInput = mkInputSpec(metadataFilename)
    val yaml = new Yaml(new Constructor(classOf[JMap[String, String]]))
    val fnYaml = yaml.load(fnInput).asInstanceOf[JMap[String, String]]
    val metadataYaml = yaml.load(metadataInput).asInstanceOf[JMap[String, Object]]
    val openapi = fnYaml.get("openapi").asInstanceOf[String]
    val info = fnYaml.get("info").asInstanceOf[JMap[String, Object]]
    val contact = info.get("contact").asInstanceOf[JMap[String, String]]
    val version = info.get("version").asInstanceOf[String]
    // TODO Make sure openapi, contact, version are the same.  So make them into classes
    val fnSchemas = fnYaml
        .get("components").asInstanceOf[JMap[String, Object]]
        .get("schemas").asInstanceOf[JMap[String, Object]]
    val metadataSchemas = metadataYaml
        .get("components").asInstanceOf[JMap[String, Object]]
        .get("schemas").asInstanceOf[JMap[String, Object]]
    val combinedSchema = {
      val combinedSchema = new JLinkedHashMap[String, Object](fnSchemas)

      metadataSchemas.forEach { (key, value) =>
        combinedSchema.put(key, value)
      }
      combinedSchema
    }
    val combinedYaml = {
      val combinedYaml = new JLinkedHashMap[String, Object]()
      combinedYaml.put("openapi", openapi)
      combinedYaml.put("info", {
        val info = new JLinkedHashMap[String, Object]()

        info.put("contact", contact)
        info.put("version", version)
        info
      })
      combinedYaml.put("components", {
        val schemas = new JLinkedHashMap[String, Object]()

        schemas.put("schemas", combinedSchema)
        schemas
      })

      combinedYaml
    }
    val writer = new StringWriter()
    val inputSpec = {
      yaml.dump(combinedYaml, writer)
      writer.toString
    }

    inputSpec
  }

  val inputSpec = mkInputSpec(fnFilename, metadataFilename)
  val codeGenerators = Seq(
    CodeGenerator.newJavaGenerator(inputSpec, outputDirname + "java") //,
//    CodeGenerator.newPythonGenerator(inputSpec, outputDirname + "python"),
//    CodeGenerator.newScalaGenerator(inputSpec, outputDirname + "scala")
  )

  codeGenerators.foreach(_.generate)
}
