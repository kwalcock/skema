package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometBoxFunction(
  functionTypeOpt: Option[FunctionType] = None,
  contentsOpt: Option[Int] = None,
  valueOpt: Option[LiteralValue] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometBoxFunction._

  def toJson: JValue = {
    (FUNCTION_TYPE -> functionTypeOpt.map(_.toJson)) ~
    (CONTENTS -> contentsOpt) ~
    (VALUE -> valueOpt.map(_.toJson)) ~
    (METADATA -> metadataOpt)
  }
}

object GrometBoxFunction {
  implicit val formats: Formats = DefaultFormats

  val FUNCTION_TYPE = "functionType"
  val CONTENTS = "contents"
  val VALUE = "value"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometBoxFunction = {
    val functionTypeOpt = (jValue \ FUNCTION_TYPE).extractOpt[JValue].map(FunctionType.fromJson)
    val contentsOpt = (jValue \ CONTENTS).extractOpt[Int]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometBoxFunction(
      functionTypeOpt,
      contentsOpt,
      valueOpt,
      metadataOpt
    )
  }
}
