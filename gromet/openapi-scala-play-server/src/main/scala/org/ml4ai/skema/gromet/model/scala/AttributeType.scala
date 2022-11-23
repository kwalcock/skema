package org.ml4ai.skema.gromet.model.scala

import org.json4s.JString
import org.json4s.JValue
import org.json4s.JsonDSL._

case class AttributeType(
  value: String
) extends Model {
  import AttributeType._

  require(values(value))

  def toJson: JValue = JString(value)
}

object AttributeType extends ModelBuilder {
  val values = Set(
    "FN",
    "IMPORT"
  )

  def fromJson(jValue: JValue): AttributeType = {
    val value = jValue.extract[String]

    AttributeType(value)
  }
}

