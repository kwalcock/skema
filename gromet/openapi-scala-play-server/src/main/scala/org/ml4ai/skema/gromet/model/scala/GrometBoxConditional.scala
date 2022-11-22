package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometBoxConditional(
  conditionOpt: Option[Int] = None,
  bodyIfOpt: Option[Int] = None,
  bodyElseOpt: Option[Int] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometBoxConditional._

  def condition: Int = conditionOpt.get
  def bodyIf: Int = bodyIfOpt.get
  def bodyElse: Int = bodyElseOpt.get
  def metadata: Int = metadataOpt.get

  def toJson: JValue = {
    (CONDITION -> conditionOpt) ~
    (BODY_IF -> bodyIfOpt) ~
    (BODY_ELSE -> bodyElseOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometBoxConditional {
  implicit val formats: Formats = DefaultFormats

  val CONDITION = "condition"
  val BODY_IF = "bodyIf"
  val BODY_ELSE = "bodyElse"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometBoxConditional = {
    val conditionOpt = (jValue \ CONDITION).extractOpt[Int]
    val bodyIfOpt = (jValue \ BODY_IF).extractOpt[Int]
    val bodyElseOpt = (jValue \ BODY_ELSE).extractOpt[Int]
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometBoxConditional(
      conditionOpt,
      bodyIfOpt,
      bodyElseOpt,
      metadataOpt
    )
  }
}
