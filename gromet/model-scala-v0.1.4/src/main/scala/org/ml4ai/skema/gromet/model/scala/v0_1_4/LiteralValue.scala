package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class LiteralValue(
  valueTypeOpt: Option[String] = None,
  valueOpt: Option[JValue] = None // TODO
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

  override val keys = Set(
    VALUE_TYPE,
    VALUE
  )

  def fromJson(jValue: JValue): LiteralValue = {
    checkKeys(jValue)

    val valueTypeOpt = (jValue \ VALUE_TYPE).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue]

    LiteralValue(
      valueTypeOpt,
      valueOpt
    )
  }
}
