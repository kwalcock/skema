package org.ml4ai.skema.gromet.model.openapi.scala

import org.json4s.{DefaultFormats, Formats, JArray, JField, JObject, JString }
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization
import org.ml4ai.skema.gromet.common.utils.FileUtils
import org.ml4ai.skema.gromet.model.scala.GrometFN
import org.ml4ai.skema.gromet.test.Test

import play.api.libs.json.{Json => PlayJson}

class ModelTest extends Test {

  behavior of "org/ml4ai/skema/gromet/model"

  def sortObject(jObject: JObject): JObject = {
    val sorted = jObject.transform {
      case JObject(list) => JObject(list.sortBy { case (key, _) => key })
    }

    sorted.asInstanceOf[JObject]
  }

  def dateObject(jObject: JObject): JObject = {
    val dated = jObject.transformField {
      case JField(key, JString(value)) if key == "timestamp" =>
        JField(key, JString(value.replace(" ", "T")))
    }

    dated.asInstanceOf[JObject]
  }

  def undateObject(jObject: JObject): JObject = {
    val undated = jObject.transformField {
      case JField(key, JString(value)) if key == "timestamp" =>
        JField(key, JString(value.replace("T", " ")))
    }

    undated.asInstanceOf[JObject]
  }

  def run(name: String): Unit = {
    implicit val formats: Formats = DefaultFormats

    it should s"deserialize $name" in {
      val resourceName =  s"/examples/$name/FN_0.1.4/$name--Gromet-FN-auto.json"
      val (serializedPython, serializedScala) = {
        val uglyPython = FileUtils.textFromResource(resourceName)
        val parsed = JsonMethods.parse(uglyPython).asInstanceOf[JObject]
        val sorted = sortObject(parsed)
        val prettyPython = Serialization.writePretty(sorted)
        val dated = prettyPython // dateObject(sorted)
        val prettyScala = Serialization.writePretty(dated) //.camelizeKeys)

        (prettyPython, prettyScala)
      }
      val result = PlayJson.fromJson[GrometFN](PlayJson.parse(serializedScala))
      val deserialized = result.get
      val (reserializedPython, reserializedScala) = {
        val uglyScala = PlayJson.prettyPrint(PlayJson.toJson(deserialized))
        val parsed = JsonMethods.parse(uglyScala).asInstanceOf[JObject]
        val sorted = sortObject(parsed)
        val prettyScala = Serialization.writePretty(sorted)
        val undated = sorted // undateObject(sorted)
        val prettyPython = Serialization.writePretty(undated.snakizeKeys)

        (prettyPython, prettyScala)
      }
      println(serializedPython)
      println(serializedScala)
      println(reserializedScala)
      println(reserializedPython)
      reserializedScala should be (serializedScala)
      reserializedPython should be (serializedPython)
    }
  }

  val tests = Array(
    "cond1",
    "dict1",
    "exp0",
    "exp1",
    "exp2",
    "for1",
    "fun1",
    "fun2",
    "fun3",
    "fun4",
    "while1",
    "while2",
    "while3"
  )

  tests.foreach {test =>
    run(test)
  }
}
