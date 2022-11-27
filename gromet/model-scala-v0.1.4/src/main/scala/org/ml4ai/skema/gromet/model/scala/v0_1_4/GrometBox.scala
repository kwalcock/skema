package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometBox(
  metadataOpt: Option[Int], // GrometObject
  nameOpt: Option[String]
) extends Model {
  import GrometBox._

  def name: String = nameOpt.get
  def metadata: Int = metadataOpt.get

  def toJson: JValue = {
    (NAME -> nameOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometBox extends ModelBuilder {
  val NAME = "name"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometBox = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]

    GrometBox(
      metadataOpt,
      nameOpt
    )
  }
}
