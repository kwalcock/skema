package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JArray, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometFN(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None,
  bOpt: Option[List[GrometBoxFunction]] = None,
  opiOpt: Option[List[GrometPort]] = None,
  opoOpt: Option[List[GrometPort]] = None,
  wopioOpt: Option[List[GrometWire]] = None,
  bfOpt: Option[List[GrometBoxFunction]] = None,
  pifOpt: Option[List[GrometPort]] = None,
  pofOpt: Option[List[GrometPort]] = None,
  wfopiOpt: Option[List[GrometWire]] = None,
  wflOpt: Option[List[GrometWire]] = None,
  wffOpt: Option[List[GrometWire]] = None,
  wfcOpt: Option[List[GrometWire]] = None,
  wfopoOpt: Option[List[GrometWire]] = None,
  blOpt: Option[List[GrometBoxLoop]] = None,
  pilOpt: Option[List[GrometPort]] = None,
  polOpt: Option[List[GrometPort]] = None,
  wlopiOpt: Option[List[GrometWire]] = None,
  wllOpt: Option[List[GrometWire]] = None,
  wlfOpt: Option[List[GrometWire]] = None,
  wlcOpt: Option[List[GrometWire]] = None,
  wlopoOpt: Option[List[GrometWire]] = None,
  wlIiargsOpt: Option[List[GrometWire]] = None,
  wlIoargsOpt: Option[List[GrometWire]] = None,
  wlCargsOpt: Option[List[GrometWire]] = None,
  bcOpt: Option[List[GrometBoxConditional]] = None,
  picOpt: Option[List[GrometPort]] = None,
  pocOpt: Option[List[GrometPort]] = None,
  wcopiOpt: Option[List[GrometWire]] = None,
  wclOpt: Option[List[GrometWire]] = None,
  wcfOpt: Option[List[GrometWire]] = None,
  wccOpt: Option[List[GrometWire]] = None,
  wcopoOpt: Option[List[GrometWire]] = None,
  wcCargsOpt: Option[List[GrometWire]] = None
) extends Model {
  import GrometFN._
  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (NAME -> nameOpt) ~
    (B -> bOpt.map(value => JArray(value.map(_.toJson)))) ~
    (OPI -> opiOpt.map(value => JArray(value.map(_.toJson)))) ~
    (OPO -> opoOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WOPIO -> wopioOpt.map(value => JArray(value.map(_.toJson)))) ~
    (BF -> bfOpt.map(value => JArray(value.map(_.toJson)))) ~
    (PIF -> pifOpt.map(value => JArray(value.map(_.toJson)))) ~
    (POF -> pofOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WFOPI -> wfopiOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WFL -> wflOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WFF -> wffOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WFC -> wfcOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WFOPO -> wfopoOpt.map(value => JArray(value.map(_.toJson)))) ~
    (BL -> blOpt.map(value => JArray(value.map(_.toJson)))) ~
    (PIL -> pilOpt.map(value => JArray(value.map(_.toJson)))) ~
    (POL -> polOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WLOPI -> wlopiOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WLL -> wllOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WLF -> wlfOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WLC -> wlcOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WLOPO -> wlopoOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WL_IIARGS -> wlIiargsOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WL_IOARGS -> wlIoargsOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WL_CARGS -> wlCargsOpt.map(value => JArray(value.map(_.toJson)))) ~
    (BC -> bcOpt.map(value => JArray(value.map(_.toJson)))) ~
    (PIC -> picOpt.map(value => JArray(value.map(_.toJson)))) ~
    (POC -> pocOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WCOPI -> wcopiOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WCL -> wclOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WCF -> wcfOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WCC -> wccOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WCOPO -> wcopoOpt.map(value => JArray(value.map(_.toJson)))) ~
    (WC_CARGS -> wcCargsOpt.map(value => JArray(value.map(_.toJson))))
  }
}

object GrometFN extends ModelBuilder {
  val METADATA = "metadata"
  val NAME = "name"
  val B = "b"
  val OPI = "opi"
  val OPO = "opo"
  val WOPIO = "wopio"
  val BF = "bf"
  val PIF = "pif"
  val POF = "pof"
  val WFOPI = "wfopi"
  val WFL = "wfl"
  val WFF = "wff"
  val WFC = "wfc"
  val WFOPO = "wfopo"
  val BL = "bl"
  val PIL = "pil"
  val POL = "pol"
  val WLOPI = "wlopi"
  val WLL = "wll"
  val WLF = "wlf"
  val WLC = "wlc"
  val WLOPO = "wlopo"
  val WL_IIARGS = "wl_iiargs"
  val WL_IOARGS = "wl_ioargs"
  val WL_CARGS = "wl_cargs"
  val BC = "bc"
  val PIC = "pic"
  val POC = "poc"
  val WCOPI = "wcopi"
  val WCL = "wcl"
  val WCF = "wcf"
  val WCC = "wcc"
  val WCOPO = "wcopo"
  val WC_CARGS = "wc_cargs"

  override val keys = Set(
    METADATA,
    NAME,
    B,
    OPI,
    OPO,
    WOPIO,
    BF,
    PIF,
    POF,
    WFOPI,
    WFL,
    WFF,
    WFC,
    WFOPO,
    BL,
    PIL,
    POL,
    WLOPI,
    WLL,
    WLF,
    WLC,
    WLOPO,
    WL_IIARGS,
    WL_IOARGS,
    WL_CARGS,
    BC,
    PIC,
    POC,
    WCOPI,
    WCL,
    WCF,
    WCC,
    WCOPO,
    WC_CARGS
  )

  def fromJson(jValue: JValue): GrometFN = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val bOpt = (jValue \ B).extractOpt[JArray].map(_.arr.map(GrometBoxFunction.fromJson))
    val opiOpt = (jValue \ OPI).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val opoOpt = (jValue \ OPO).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val wopioOpt = (jValue \ WOPIO).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val bfOpt = (jValue \ BF).extractOpt[JArray].map(_.arr.map(GrometBoxFunction.fromJson))
    val pifOpt = (jValue \ PIF).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val pofOpt = (jValue \ POF).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val wfopiOpt = (jValue \ WFOPI).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wflOpt = (jValue \ WFL).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wffOpt = (jValue \ WFF).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wfcOpt = (jValue \ WFC).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wfopoOpt = (jValue \ WFOPO).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val blOpt = (jValue \ BL).extractOpt[JArray].map(_.arr.map(GrometBoxLoop.fromJson))
    val pilOpt = (jValue \ PIL).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val polOpt = (jValue \ POL).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val wlopiOpt = (jValue \ WLOPI).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wllOpt = (jValue \ WLL).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlfOpt = (jValue \ WLF).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlcOpt = (jValue \ WLC).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlopoOpt = (jValue \ WLOPO).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlIiargsOpt = (jValue \ WL_IIARGS).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlIoargsOpt = (jValue \ WL_IOARGS).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wlCargsOpt = (jValue \ WL_CARGS).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val bcOpt = (jValue \ BC).extractOpt[JArray].map(_.arr.map(GrometBoxConditional.fromJson))
    val picOpt = (jValue \ PIC).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val pocOpt = (jValue \ POC).extractOpt[JArray].map(_.arr.map(GrometPort.fromJson))
    val wcopiOpt = (jValue \ WCOPI).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wclOpt = (jValue \ WCL).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wcfOpt = (jValue \ WCF).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wccOpt = (jValue \ WCC).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wcopoOpt = (jValue \ WCOPO).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))
    val wcCargsOpt = (jValue \ WC_CARGS).extractOpt[JArray].map(_.arr.map(GrometWire.fromJson))

    GrometFN(
      metadataOpt,
      nameOpt,
      bOpt,
      opiOpt,
      opoOpt,
      wopioOpt,
      bfOpt,
      pifOpt,
      pofOpt,
      wfopiOpt,
      wflOpt,
      wffOpt,
      wfcOpt,
      wfopoOpt,
      blOpt,
      pilOpt,
      polOpt,
      wlopiOpt,
      wllOpt,
      wlfOpt,
      wlcOpt,
      wlopoOpt,
      wlIiargsOpt,
      wlIoargsOpt,
      wlCargsOpt,
      bcOpt,
      picOpt,
      pocOpt,
      wcopiOpt,
      wclOpt,
      wcfOpt,
      wccOpt,
      wcopoOpt,
      wcCargsOpt,
    )
  }
}
