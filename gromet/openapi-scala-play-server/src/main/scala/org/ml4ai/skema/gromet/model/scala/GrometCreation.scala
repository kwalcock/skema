package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometCreation(
  metadataTypeOpt: Option[String] = None,
  grometVersionOpt: Option[String] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import GrometCreation._

  // TODO: accessors

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (GROMET_VERSION -> grometVersionOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object GrometCreation {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val GROMET_VERSION = "grometVersion"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): GrometCreation = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val grometVersionOpt = (jValue \ GROMET_VERSION).extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    GrometCreation(
      metadataTypeOpt,
      grometVersionOpt,
      provenanceOpt
    )
  }
}
