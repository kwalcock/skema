package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JObject, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class TypedValue(
  typeOpt: Option[String] = None,
  valueOpt: Option[JObject] = None, // TODO
  indexOpt: Option[Int] = None
) extends Model {
  import TypedValue._

  def toJson: JValue = {
    (TYPE -> typeOpt) ~
    (VALUE -> valueOpt) ~
    (INDEX -> indexOpt)
  }
}

object TypedValue extends ModelBuilder {
  val TYPE = "type"
  val VALUE = "value"
  val INDEX = "index"

  def fromJson(jValue: JValue): TypedValue = {
    val typeOpt = (jValue \ TYPE).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JObject]
    val indexOpt = (jValue \ INDEX).extractOpt[Int]

    TypedValue(
      typeOpt,
      valueOpt,
      indexOpt
    )
  }
}
