package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._

case class GrometBoxConditional(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None, // GrometBox
  conditionOpt: Option[Int] = None,
  bodyIfOpt: Option[Int] = None,
  bodyElseOpt: Option[Int] = None
) extends Model {
  import GrometBoxConditional._

  def metadata: Int = metadataOpt.get
  def name: String = nameOpt.get
  def condition: Int = conditionOpt.get
  def bodyIf: Int = bodyIfOpt.get
  def bodyElse: Int = bodyElseOpt.get

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (NAME -> nameOpt) ~
    (CONDITION -> conditionOpt) ~
    (BODY_IF -> bodyIfOpt) ~
    (BODY_ELSE -> bodyElseOpt)
  }
}

object GrometBoxConditional extends ModelBuilder {
  val METADATA = "metadata"
  val NAME = "name"
  val CONDITION = "condition"
  val BODY_IF = "body_if"
  val BODY_ELSE = "body_else"

  def fromJson(jValue: JValue): GrometBoxConditional = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val conditionOpt = (jValue \ CONDITION).extractOpt[Int]
    val bodyIfOpt = (jValue \ BODY_IF).extractOpt[Int]
    val bodyElseOpt = (jValue \ BODY_ELSE).extractOpt[Int]

    GrometBoxConditional(
      metadataOpt,
      nameOpt,
      conditionOpt,
      bodyIfOpt,
      bodyElseOpt
    )
  }
}
