package org.ml4ai.skema.gromet.model.scala

// TODO: This is the complex one

import org.json4s.JValue
import org.json4s.JsonDSL._

case class GrometFNModule(
  metadataOpt: Option[Int] = None, // GrometObject
  schemaOpt: Option[String] = Some("FN"),
  schemaVersionOpt: Option[String] = Some("0.1.4"),
  nameOpt: Option[String] = None,
  fnOpt: Option[GrometFN] = None,
  attributesOpt: Option[List[TypedValue]] = None,
  metadataCollectionOpt: Option[List[List[Metadata]]] = None,
) extends Model {
  import GrometFNModule._

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (SCHEMA -> schemaOpt) ~
    (SCHEMA_VERSION -> schemaVersionOpt) ~
    (NAME -> nameOpt) ~
    (FN -> fnOpt.map(_.toJson)) ~
    (ATTRIBUTES -> "TODO") ~
    (METADATA_COLLECTION -> "TODO")
  }
}

object GrometFNModule extends ModelBuilder {
  val METADATA = "metadata"
  val SCHEMA = "schema"
  val SCHEMA_VERSION = "schema_version"
  val NAME = "name"
  val FN = "fn"
  val ATTRIBUTES = "attributes"
  val METADATA_COLLECTION = "metadata_collection"

  def fromJson(jValue: JValue): GrometFNModule = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val schemaOpt = (jValue \ SCHEMA).extractOpt[String]
    val schemaVersionOpt = (jValue \ SCHEMA_VERSION).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val fnOpt = (jValue \ FN).extractOpt[JValue].map(GrometFN.fromJson)
    // TODO: These are arrays.  How many arrays?
    val attributesOpt = (jValue \ ATTRIBUTES).extractOpt[JValue].map()
    val metadataCollectionOpt = (jValue \ METADATA_COLLECTION).extractOpt[JValue].map()
  }

  GrometFNModule(
    metadataOpt,
    schemaOpt,
    schemaVersionOpt,
    nameOpt,
    fnOpt,
    attributesOpt,
    metadataCollectionOpt
  )
}
