package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.{JString, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

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

