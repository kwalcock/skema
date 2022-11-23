package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class GrometCreation(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some("promet_creation"),
  grometVersionOpt: Option[String] = Some("0.1.2")
) extends Model {
  import GrometCreation._

  // TODO: accessors

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (GROMET_VERSION -> grometVersionOpt)
  }
}

object GrometCreation extends ModelBuilder {
  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val GROMET_VERSION = "gromet_version"

  def fromJson(jValue: JValue): GrometCreation = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val grometVersionOpt = (jValue \ GROMET_VERSION).extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    GrometCreation(
      provenanceOpt,
      metadataTypeOpt,
      grometVersionOpt
    )
  }
}
