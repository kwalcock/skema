package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JArray, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class TextualDocumentCollection(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TextualDocumentCollection.TYPE),
  documentsOpt: Option[List[TextualDocumentReference]] = None
) extends MetadataModel {
  import TextualDocumentCollection._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def documents: List[TextualDocumentReference] = documentsOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (DOCUMENTS -> documentsOpt.map { documents =>
      JArray(documents.map(_.toJson))
    })
  }
}

object TextualDocumentCollection extends MetadataModelBuilder {
  val TYPE = "textual_document_collection"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val DOCUMENTS = "documents"

  override val keys = Set(
    PROVENANCE,
    METADATA_TYPE,
    DOCUMENTS
  )

  def fromJson(jValue: JValue): TextualDocumentCollection = {
    checkKeys(jValue)

    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val documentsOpt = (jValue \ DOCUMENTS).extractOpt[JArray].map { jArray =>
      jArray.arr.map(TextualDocumentReference.fromJson)
    }
    TextualDocumentCollection(
      provenanceOpt,
      metadataTypeOpt,
      documentsOpt
    )
  }
}
