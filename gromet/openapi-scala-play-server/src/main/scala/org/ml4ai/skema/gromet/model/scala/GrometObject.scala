package org.ml4ai.skema.gromet.model.scala

import play.api.libs.json._

/**
  * Generic base class for any GroMEt object
  * @param metadata Index (integer) into the metadata_collection table in GrometFNModule.
  * @param additionalProperties Any additional properties this model may have.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"), date = "2022-11-19T21:45:59.222-07:00[America/Phoenix]")
case class GrometObject(
  metadata: Option[Int]
//  additionalProperties:
)

object GrometObject {
  implicit lazy val grometObjectJsonFormat: Format[GrometObject] = {
    val realJsonFormat = Json.format[GrometObject]
val declaredPropNames = Set("metadata")

Format(
  Reads {
    case JsObject(xs) =>
      val declaredProps = xs.filterKeys(declaredPropNames)
      val additionalProps = JsObject(xs -- declaredPropNames)
      val restructuredProps = declaredProps + ("additionalProperties" -> additionalProps)
      val newObj = JsObject(restructuredProps)
      realJsonFormat.reads(newObj)
    case _ =>
      JsError("error.expected.jsobject")
  },
  Writes { grometObject =>
    val jsObj = realJsonFormat.writes(grometObject)
    val additionalProps = jsObj.value("additionalProperties").as[JsObject]
    val declaredProps = jsObj - "additionalProperties"
    val newObj = declaredProps ++ additionalProps
    newObj
  }
)
  }
}

