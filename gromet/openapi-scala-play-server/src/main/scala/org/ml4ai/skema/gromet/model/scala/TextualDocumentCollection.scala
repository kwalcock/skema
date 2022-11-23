package org.ml4ai.skema.gromet.model.scala

import org.json4s.{JArray, JValue}
import org.json4s.JsonDSL._

case class TextualDocumentCollection(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some("textual_document_collection"),
  documentsOpt: Option[List[TextualDocumentReference]] = None
) extends Model {
  import TextualDocumentCollection._

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (DOCUMENTS -> documentsOpt) // TODO
  }
}

object TextualDocumentCollection extends ModelBuilder {
  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val DOCUMENTS = "documents"

  def fromJson(jValue: JValue): TextualDocumentCollection = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.toJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val documentsOpt = (jValue \ DOCUMENTS).extractOpt[JArray].asInstanceOf[Tex]

    TextualDocumentCollection(
      provenanceOpt
      metadataTypeOpt,
      documentsOpt
    )
  }
}
