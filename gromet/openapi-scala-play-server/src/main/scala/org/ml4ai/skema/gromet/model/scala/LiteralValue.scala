package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class LiteralValue(
  valueTypeOpt: Option[String] = None,
  valueOpt: Option[String] = None // TODO: What is this?
) extends Model {
  import LiteralValue._

  def toJson: JValue = {
    (VALUE_TYPE -> valueTypeOpt) ~
    (VALUE -> valueOpt)
  }
}

object LiteralValue extends ModelBuilder {
  val VALUE_TYPE = "value_type"
  val VALUE = "value"

  def fromJson(jValue: JValue): LiteralValue = {
    val valueTypeOpt = (jValue \ VALUE_TYPE).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[String] // TODO

    LiteralValue(
      valueTypeOpt,
      valueOpt
    )
  }
}
