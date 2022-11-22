package org.ml4ai.skema.gromet.model.scala

import org.json4s.JsonAST.JString
import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class AttributeType(
  value: String
) extends Model {
  import AttributeType._

  require(values(value))

  def toJson: JValue = JString(value)
}

object AttributeType {
  implicit val formats: Formats = DefaultFormats

  val values = Set(
    "FN",
    "IMPORT"
  )

  def fromJson(jValue: JValue): AttributeType = {
    val value = jValue.extract[String]

    AttributeType(value)
  }
}

