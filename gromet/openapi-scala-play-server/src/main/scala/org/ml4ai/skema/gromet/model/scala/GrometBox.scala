package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometBox(
  nameOpt: Option[String],
  metadataOpt: Option[Int]
) extends Model {
  import GrometBox._

  def name: String = nameOpt.get
  def metadata: Int = metadataOpt.get

  def toJson: JValue = {
    (NAME -> nameOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometBox {
  implicit val formats: Formats = DefaultFormats

  val NAME = "name"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometBox = {
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometBox(
      nameOpt,
      metadataOpt
    )
  }
}
