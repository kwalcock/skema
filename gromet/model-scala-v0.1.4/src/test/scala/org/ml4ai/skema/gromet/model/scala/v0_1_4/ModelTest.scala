package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.jackson.{JsonMethods, Serialization}
import org.json4s.{DefaultFormats, Formats, JObject}
import org.ml4ai.skema.gromet.common.utils.FileUtils
import org.ml4ai.skema.gromet.test.Test

class ModelTest extends Test {

  behavior of "org/ml4ai/skema/gromet/model"

  def sortObject(jObject: JObject): JObject = {
    val sorted = jObject.transform {
      case JObject(list) => JObject(list.sortBy { case (key, _) => key })
    }

    sorted.asInstanceOf[JObject]
  }

  def run(name: String): Unit = {
    implicit val formats: Formats = DefaultFormats

    it should s"deserialize $name" in {
      val resourceName =  s"/examples/$name/FN_0.1.4/$name--Gromet-FN-auto.json"
      val serialized = {
        val ugly = FileUtils.textFromResource(resourceName)
        val parsed = JsonMethods.parse(ugly).asInstanceOf[JObject]
        val sorted = sortObject(parsed)
        val pretty = Serialization.writePretty(sorted)

        pretty
      }
      val deserialized = GrometFNModule.fromJson(JsonMethods.parse(serialized))
      val reserialized = {
        val uglyScala = Serialization.writePretty(deserialized.toJson)
        val parsed = JsonMethods.parse(uglyScala).asInstanceOf[JObject]
        val sorted = sortObject(parsed)
        val pretty = Serialization.writePretty(sorted)

        pretty
      }

      reserialized should be (serialized)
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
