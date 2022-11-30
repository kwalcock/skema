package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class GrometCreation(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(GrometCreation.TYPE),
  grometVersionOpt: Option[String] = Some("0.1.2")
) extends MetadataModel {
  import GrometCreation._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def grometVersion: String = grometVersionOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (GROMET_VERSION -> grometVersionOpt)
  }
}

object GrometCreation extends MetadataModelBuilder {
  val TYPE = "gromet_creation"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val GROMET_VERSION = "gromet_version"

  override val keys = Set(
    PROVENANCE,
    METADATA_TYPE,
    GROMET_VERSION
  )

  def fromJson(jValue: JValue): GrometCreation = {
    checkKeys(jValue)

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
