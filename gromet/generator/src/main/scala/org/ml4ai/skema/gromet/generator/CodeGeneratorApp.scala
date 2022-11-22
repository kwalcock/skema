package org.ml4ai.skema.gromet.generator

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.{BufferedOutputStream, File, FileOutputStream, OutputStreamWriter, PrintWriter, StringWriter}
import java.nio.charset.StandardCharsets
import java.util.{LinkedHashMap => JLinkedHashMap}
import java.util.{Map => JMap}
import scala.io.{Codec, Source}
import scala.collection.JavaConverters._

object CodeGeneratorApp extends App {
  val useOpen = true
  val version = "0.1.4"
  val fnFilename = s"./gromet_FN_v$version.yaml"
  val metadataFilename = s"./gromet_metadata_v$version.yaml"
  val outputDirname =
      if (useOpen) "../../openapi/"
      else "../../swagger/"

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

    val fnInfo = fnYaml.get("info").asInstanceOf[JMap[String, Object]]
    val contact = fnInfo.get("contact").asInstanceOf[JMap[String, Object]]
    val license = fnInfo.get("license").asInstanceOf[JMap[String, Object]]
    val version = fnInfo.get("version").asInstanceOf[String]
    val fnTitle = fnInfo.get("title").asInstanceOf[String]

    val metadataInfo = metadataYaml.get("info").asInstanceOf[JMap[String, Object]]
    val metadataTitle = metadataInfo.get("title").asInstanceOf[String]

    val fnPaths = fnYaml.get("paths").asInstanceOf[JMap[String, Object]]

    val title = s"""Combined "$fnTitle" and "$metadataTitle""""
    // TODO Make sure openapi, contact, version are the same.  So make them into classes
    // Issue a warning if they differ
    val fnSchemas = fnYaml
        .get("components").asInstanceOf[JMap[String, Object]]
        .get("schemas").asInstanceOf[JMap[String, Object]]
    val metadataSchemas = metadataYaml
        .get("components").asInstanceOf[JMap[String, Object]]
        .get("schemas").asInstanceOf[JMap[String, Object]]
    val combinedSchema = {
      val combinedSchema = new JLinkedHashMap[String, Object](fnSchemas)

      metadataSchemas.asScala.foreach { case (key, value) =>
        // Metadata and LiteralValue of metadataSchemas will overwrite that of fnSchemas.
        // TODO: Check that only these keys overlap.
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
        info.put("license", license)
        info.put("version", version)
        info.put("title", title)
        info
      })
      combinedYaml.put("paths", fnPaths)
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

//  val inputSpec = mkInputSpec(fnFilename)
  val inputSpec = mkInputSpec(fnFilename, metadataFilename)
  val codeGenerators =
    if (useOpen) {
      val tmpFile = {
        val tmpFile = File.createTempFile("CodeGeneratorApp-", ".yaml")
        tmpFile.deleteOnExit()

        val printWriter = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(tmpFile)), StandardCharsets.UTF_8))
        printWriter.println(inputSpec)
        printWriter.close()

        tmpFile
      }
      Seq(
//        OpenApiCodeGenerator.newJavaGenerator(tmpFile.getAbsolutePath(), outputDirname + "java") //,
    //    OpenApiCodeGenerator.newPythonGenerator(tmpFile.getAbsolutePath(), outputDirname + "python"),
        OpenApiCodeGenerator.newScalaGenerator(tmpFile.getAbsolutePath(), outputDirname + "scala")
      )
    }
    else
      Seq(
//        SwagCodeGenerator.newJavaGenerator(inputSpec, outputDirname + "java") //,
        //    SwagCodeGenerator.newPythonGenerator(inputSpec, outputDirname + "python"),
            SwagCodeGenerator.newScalaGenerator(inputSpec, outputDirname + "scala")
      )

  codeGenerators.foreach(_.generate)
}
