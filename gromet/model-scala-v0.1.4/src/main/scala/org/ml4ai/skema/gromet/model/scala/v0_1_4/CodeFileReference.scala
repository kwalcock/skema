package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class CodeFileReference (
  uidOpt: Option[String] = None,
  nameOpt: Option[String] = None,
  pathOpt: Option[String] = None
) extends Model {
  import CodeFileReference._

  def uid: String = uidOpt.get
  def name: String = nameOpt.get
  def path: String = pathOpt.get

  def toJson: JValue = {
    (UID -> uidOpt) ~
    (NAME -> nameOpt) ~
    (PATH -> pathOpt)
  }
}

object CodeFileReference extends ModelBuilder {
  val UID = "uid"
  val NAME = "name"
  val PATH = "path"
  override val keys = Set(
    UID,
    NAME,
    PATH
  )

  def fromJson(jValue: JValue): CodeFileReference = {
    checkKeys(jValue)

    val uidOpt = (jValue \ UID).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val pathOpt = (jValue \ PATH).extractOpt[String]

    CodeFileReference(
      uidOpt,
      nameOpt,
      pathOpt
    )
  }
}
