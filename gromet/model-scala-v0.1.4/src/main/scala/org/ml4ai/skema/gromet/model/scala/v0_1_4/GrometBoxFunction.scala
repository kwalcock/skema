package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JObject, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometBoxFunction(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None, // GrometBox
  functionTypeOpt: Option[FunctionType] = None,
  contentsOpt: Option[Int] = None,
  valueOpt: Option[LiteralValue] = None,
) extends Model {
  import GrometBoxFunction._

  def metadata: Int =  metadataOpt.get
  def name: String = nameOpt.get
  def functionType: FunctionType = functionTypeOpt.get
  def contents: Int = contentsOpt.get
  def value: LiteralValue = valueOpt.get

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

  override val keys = Set(
    METADATA,
    NAME,
    FUNCTION_TYPE,
    CONTENTS,
    VALUE
  )

  def fromJson(jValue: JValue): GrometBoxFunction = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val functionTypeOpt = (jValue \ FUNCTION_TYPE).extractOpt[JValue].map(FunctionType.fromJson)
    val contentsOpt = (jValue \ CONTENTS).extractOpt[Int]

    val valueOpt = (jValue \ VALUE).extractOpt[JObject].map(LiteralValue.fromJson) // JValue might be JNothing

    GrometBoxFunction(
      metadataOpt,
      nameOpt,
      functionTypeOpt,
      contentsOpt,
      valueOpt
    )
  }
}
