package org.ml4ai.skema.gromet.model.swagger.scala

import io.swagger.client.ApiInvoker
import org.json4s.{DefaultFormats, Formats, JArray, JObject, JValue, JsonDSL }
import org.json4s.jackson.JsonMethods
import org.json4s.jackson.Serialization
import org.ml4ai.skema.gromet.common.utils.FileUtils
import org.ml4ai.skema.gromet.test.Test

class ModelTest extends Test {

  behavior of "model"

  def toOther(jObject: JObject, converter: String => String): JObject = {

    def innerObject(jObject: JObject): JObject = {
      val newMap = jObject.values.map { case (key: String, value: JValue) =>
        val newKey = converter(key)
        val newValue: JValue = value match {
          case value: JObject => innerObject(value)
          case value: JArray => innerArray(value)
          case value: JValue => value
        }

        newKey -> newValue
      }

      new JObject(newMap.toList)
    }

    def innerArray(jArray: JArray): JArray = {
      val newArray = jArray.arr.map { case value =>
        val newValue: JValue = value match {
          case value: JObject => innerObject(value)
          case value: JArray => innerArray(value)
          case value: JValue => value
        }

        newValue
      }

      new JArray(newArray.toList)
    }

    innerObject(jObject)
  }

  def toScala(jObject: JObject): JObject = {
    jObject.camelizeKeys.asInstanceOf[JObject]
//    toOther(jObject, (string: String) => string.toUpperCase)
  }

  def toPython(jObject: JObject): JObject = {
    jObject.snakizeKeys.asInstanceOf[JObject]
    // toOther(jObject, (string: String) => string.toLowerCase)
  }

  def run(name: String): Unit = {
    implicit val formats: Formats = DefaultFormats

    it should s"deserialize $name" in {
      val resourceName =  s"/examples/$name/FN_0.1.4/$name--Gromet-FN-auto.json"
      val (serializedPython, serializedScala) = {
        val uglyPython = FileUtils.textFromResource(resourceName)
        val jObject = JsonMethods.parse(uglyPython).asInstanceOf[JObject]
        val prettyPython = Serialization.writePretty(jObject)
        val prettyScala = Serialization.writePretty(toScala(jObject))

        (prettyPython, prettyScala)
      }

      // Read in the json, change keys, format
      val deserialized = ApiInvoker.deserialize(serializedScala, "", classOf[GrometFNModule]).asInstanceOf[GrometFNModule]
      val (reserializedPython, reserializedScala) = {
        val uglyScala = ApiInvoker.serialize(deserialized)
        val jObject = JsonMethods.parse(uglyScala).asInstanceOf[JObject]
        val prettyScala = Serialization.writePretty(jObject)
        val prettyPython = Serialization.writePretty(toPython(jObject))

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
