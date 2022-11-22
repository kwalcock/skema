package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometPort(
  idOpt: Option[Int] = None,
  nameOpt: Option[String] = None,
  boxOpt: Option[Int] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometPort._

  def toJson: JValue = {
    (ID -> idOpt) ~
    (NAME -> nameOpt) ~
    (BOX -> boxOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometPort {
  implicit val formats: Formats = DefaultFormats

  val ID = "id"
  val NAME = "name"
  val BOX = "box"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometPort = {
    val idOpt = (jValue \ ID).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val boxOpt = (jValue \ BOX).extractOpt[Int]
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometPort(
      idOpt,
      nameOpt,
      boxOpt,
      metadataOpt
    )
  }
}
