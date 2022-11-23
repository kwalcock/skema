package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class GrometBoxFunction(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None, // GrometBox
  functionTypeOpt: Option[FunctionType] = None,
  contentsOpt: Option[Int] = None,
  valueOpt: Option[LiteralValue] = None,
) extends Model {
  import GrometBoxFunction._

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (NAME -> nameOpt) ~
    (FUNCTION_TYPE -> functionTypeOpt.map(_.toJson)) ~
    (CONTENTS -> contentsOpt) ~
    (VALUE -> valueOpt.map(_.toJson))
  }
}

object GrometBoxFunction extends ModelBuilder {
  val METADATA = "metadata"
  val NAME = "name"
  val FUNCTION_TYPE = "function_type"
  val CONTENTS = "contents"
  val VALUE = "value"

  def fromJson(jValue: JValue): GrometBoxFunction = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val functionTypeOpt = (jValue \ FUNCTION_TYPE).extractOpt[JValue].map(FunctionType.fromJson)
    val contentsOpt = (jValue \ CONTENTS).extractOpt[Int]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)

    GrometBoxFunction(
      metadataOpt,
      nameOpt,
      functionTypeOpt,
      contentsOpt,
      valueOpt
    )
  }
}
