package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometFNModule(
  schemaOpt: Option[String] = None,
  schemaVersionOpt: Option[String] = None,
  nameOpt: Option[String] = None,
  fnOpt: Option[GrometFN] = None,
  attributesOpt: Option[List[TypedValue]] = None,
  metadataCollectionOpt: Option[List[List[Metadata]]] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometFNModule._

  def toJson: JValue = {
    ???
  }
}

object GrometFNModule {
  implicit val formats: Formats = DefaultFormats

  val SCHEMA = "schema"
  val SCHEMA_VERSION = "schemaVersion"
  val NAME = "name"
  val FN = "fn"
  val ATTRIBUTES = "attributes"
  val METADATA_COLLECTION = "metadataCollection"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometFNModule = {
    val schemaOpt = (jValue \ SCHEMA).extractOpt[String]
    val schemaVersionOpt = (jValue \ SCHEMA_VERSION).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val fnOpt = (jValue \ FN).extractOpt[JValue].map(GrometFN.fromJson)
    // TODO: These are arrays.  How many arrays?
    val attributesOpt = (jValue \ ATTRIBUTES).extractOpt[JValue].map()
    val metadataCollectionOpt = (jValue \ METADATA_COLLECTION).extractOpt[JValue].map()
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
  }

  GrometFNModule(
    schemaOpt,
    schemaVersionOpt,
    nameOpt,
    fnOpt,
    attributesOpt,
    metadataCollectionOpt,
    metadataOpt
  )
}
