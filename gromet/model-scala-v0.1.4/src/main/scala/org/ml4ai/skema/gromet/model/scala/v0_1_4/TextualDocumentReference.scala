package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class TextualDocumentReference(
  uidOpt: Option[String] = None,
  globalReferenceIdOpt: Option[String] = None,
  cosmosIdOpt: Option[String] = None,
  cosmosVersionNumberOpt: Option[String] = None,
  skemaIdOpt: Option[String] = None,
  skemaVersionNumberOpt: Option[String] = None
//  bibjson: Option[OasAnyTypeNotMapped]
) extends Model {
  import TextualDocumentReference._

  def toJson: JValue = {
    (UID -> uidOpt) ~
    (GLOBAL_REFERENCE_ID -> globalReferenceIdOpt) ~
    (COSMOS_ID -> cosmosIdOpt) ~
    (COSMOS_VERSION_NUMBER -> cosmosVersionNumberOpt) ~
    (SKEMA_ID -> skemaIdOpt) ~
    (SKEMA_VERSION_NUMBER -> skemaVersionNumberOpt)
  }
}

object TextualDocumentReference extends ModelBuilder {
  val UID = "uid"
  val GLOBAL_REFERENCE_ID = "global_reference_id"
  val COSMOS_ID = "cosmos_id"
  val COSMOS_VERSION_NUMBER = "cosmos_version_number"
  val SKEMA_ID = "skema_id"
  val SKEMA_VERSION_NUMBER = "skema_version_number"

  def fromJson(jValue: JValue): TextualDocumentReference = {
    val uidOpt = (jValue \ UID).extractOpt[String]
    val globalReferenceIdOpt = (jValue \ GLOBAL_REFERENCE_ID).extractOpt[String]
    val cosmosIdOpt = (jValue \ COSMOS_ID).extractOpt[String]
    val cosmosVersionNumberOpt = (jValue \ COSMOS_VERSION_NUMBER).extractOpt[String]
    val skemaIdOpt = (jValue \ SKEMA_ID).extractOpt[String]
    val skemaVersionNumberOpt = (jValue \ SKEMA_VERSION_NUMBER).extractOpt[String]

    TextualDocumentReference(
      uidOpt,
      globalReferenceIdOpt,
      cosmosIdOpt,
      cosmosVersionNumberOpt,
      skemaIdOpt,
      skemaVersionNumberOpt
    )
  }
}
