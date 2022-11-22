package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JArray, JValue}
import org.json4s.JsonDSL._

case class TextualDocumentCollection(
  metadataTypeOpt: Option[String] = None,
  documentsOpt: Option[List[TextualDocumentReference]] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import TextualDocumentCollection._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (DOCUMENTS -> documentsOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object TextualDocumentCollection {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val DOCUMENTS = "documents"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): TextualDocumentCollection = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val documentsOpt = (jValue \ DOCUMENTS).extractOpt[JArray].asInstanceOf[Tex]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.toJson)

    TextualDocumentCollection(
      metadataTypeOpt,
      documentsOpt,
      provenanceOpt
    )
  }
}
