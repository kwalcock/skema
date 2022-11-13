package org.ml4ai.skema.gromet.model.swagger.scala

import io.swagger.client.ApiInvoker
import org.json4s.{DefaultFormats, Formats, JArray, JObject, JValue, JsonDSL }
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization
import org.ml4ai.skema.gromet.common.utils.FileUtils
import org.ml4ai.skema.gromet.test.Test

class ModelTest extends Test {

  behavior of "model"

  def sortObject(jObject: JObject): JObject = {
    val sorted = new JObject(jObject.obj.sortBy { case (key, _) => key })
    val transformed = sorted.transform { case jArray: JArray => sortArray(jArray) }

    transformed.asInstanceOf[JObject]
  }

  def sortArray(jArray: JArray): JArray = {
    val transformed = jArray.transform { case jObject: JObject => sortObject(jObject) }

    transformed.asInstanceOf[JArray]
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
        val prettyScala = Serialization.writePretty(sorted.camelizeKeys)

        (prettyPython, prettyScala)
      }

      val deserialized = ApiInvoker.deserialize(serializedScala, "", classOf[GrometFNModule]).asInstanceOf[GrometFNModule]
      val (reserializedPython, reserializedScala) = {
        val uglyScala = ApiInvoker.serialize(deserialized)
        val parsed = JsonMethods.parse(uglyScala).asInstanceOf[JObject]
        val sorted = sortObject(parsed)
        val prettyScala = Serialization.writePretty(sorted)
        val prettyPython = Serialization.writePretty(sorted.snakizeKeys)

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
