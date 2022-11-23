package org.ml4ai.skema.gromet.model.scala

import play.api.libs.json._

// TODO: This is the big one!

/**
  * A Function Network (FN). 
  * @param name The name of the Function Network 
  * @param b b: The FN Outer Box (although not enforced, there is always only 1). 
  * @param opi opi: The Outer Port Inputs of the FN Outer Box (b) 
  * @param opo opo: The Outer Port Outputs of the FN Outer Box (b) 
  * @param wopio wopio: The Wires from (src) Outer Box Outer Port Inputs (opi) to (tgt) Outer Box Outer Port Outputs (opo). (AKA: Passthrough.) 
  * @param bf bf: The GrometBoxFunctions within this GrometFN. 
  * @param pif pif: The Port Inputs of the GrometBoxFunctions (bf). 
  * @param pof pof: The Port Outputs of the GrometBoxFunctions (bf). 
  * @param wfopi wfopi: The Wires from (src) GrometBoxFunctions Port Inputs (pif) to (tgt) Outer Box Outer Port Inputs (opi). 
  * @param wfl wfl: The Wires from (src) GrometBoxLoops Port Inputs (pil) to (tgt) GrometBoxFunctions Port Outputs (pof). 
  * @param wff wff: The Wires from (src) GrometBoxFunctions Port Inputs (pif) to (tgt) GrometBoxFunctions Port Outputs (pof). 
  * @param wfc wfc: The Wires from (src) GrometBoxConditionals Port Inputs (pic) to (tgt) GrometBoxFunctions Port Outputs (pof). 
  * @param wfopo wfopo: The Wires from (src) Outer Box Outer Port Outputs (opo) to (tgt) GrometBoxFunctions Port Outputs (pof). 
  * @param bl bl: The FN GrometBoxLoops within this GrometFN. 
  * @param pil pil: The Port Inputs of the GrometBoxLoops (bl) 
  * @param pol pol: The Port Outputs of the GrometBoxLoops (bl) 
  * @param wlopi wlopi: The Wires from (src) GrometBoxLoops Port Inputs (pil) to (tgt) the Outer Box Outer Port Inputs (opi). 
  * @param wll wll: The Wires from (src) the GrometBoxLoops Port Inputs (pil) to (tgt) the GrometBoxLoops Port Outputs (pol). 
  * @param wlf wlf: The Wires from (src) the GrometBoxFunctions Port Inputs (pif) to (tgt) the GrometBoxLoops Port Outputs (pol). 
  * @param wlc wlc: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the GrometBoxLoops Port Outputs (pol). 
  * @param wlopo wlopo: The Wires from (src) Outer Box Outer Port Outputs (opo) to (tgt) GrometBoxLoops Port Outputs (pol). 
  * @param wlIiargs wl_iiargs: The Wires from (src) the arguments (the Port Inputs) of the Loop init (itself a Function, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Loop (pil). It is through these Wires that the Loop init Function gets its input argument values before the init Function is evaluated; these values originate from outside of the Loop. 
  * @param wlIoargs wl_ioargs: The Wires from (src) the Port Inputs of the Loop (pil) to (tgt) the Port Outputs of the Loop init (itself a Function, a type of GrometBoxFunction) (pof). It is through these Wires that the Loop Port Inputs get their values initialized after evaluation of the init Function. 
  * @param wlCargs wl_cargs: The Wires from (src) the arguments (the Port Inputs) of the Loop condition (itself a Predicate, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Loop (pil). It is through these Wires that the Loop condition Predicate gets its input argument values from the current state of the Loop Input Ports. 
  * @param bc bc: The FN GrometBoxConditionals within this GrometFN. 
  * @param pic pic: The Port Inputs of the GrometBoxConditionals (bc) 
  * @param poc poc: The Port Outputs of the GrometBoxConditionals (bc) 
  * @param wcopi wcopi: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the Outer Box Outer Port Inputs (opi). 
  * @param wcl wcl: The Wires from (src) the GrometBoxLoops Port Inputs (pil) to (tgt) the GrometBoxConditionals Port Outputs (poc). 
  * @param wcf wcf: The Wires from (src) the GrometBoxFunctions Port Inputs (pif) to (tgt) the GrometBoxConditionals Port Outputs (poc). 
  * @param wcc wcc: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the GrometBoxConditionals Port Outputs (poc). 
  * @param wcopo wcopo: The Wires from (src) the Outer Box Outer Port Outputs (opo) to (tgt) the GrometBoxConditionals Port Outputs (poc). 
  * @param wcCargs wc_cargs: The Wires from (src) the arguments (the Port Inputs) of the Conditional condition (itself a Predicate, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Conditional (pic). It is through these Wires that the Conditional condition Predicate gets its input argument values from the Conditional Input Ports. 
  * @param metadata Index (integer) into the metadata_collection table in GrometFNModule.
  */
@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"), date = "2022-11-19T21:45:59.222-07:00[America/Phoenix]")
case class GrometFN(
  name: Option[String],
  b: Option[List[GrometBoxFunction]],
  opi: Option[List[GrometPort]],
  opo: Option[List[GrometPort]],
  wopio: Option[List[GrometWire]],
  bf: Option[List[GrometBoxFunction]],
  pif: Option[List[GrometPort]],
  pof: Option[List[GrometPort]] /*,
  wfopi: Option[List[GrometWire]],
  wfl: Option[List[GrometWire]],
  wff: Option[List[GrometWire]],
  wfc: Option[List[GrometWire]],
  wfopo: Option[List[GrometWire]],
  bl: Option[List[GrometBoxLoop]],
  pil: Option[List[GrometPort]],
  pol: Option[List[GrometPort]],
  wlopi: Option[List[GrometWire]],
  wll: Option[List[GrometWire]],
  wlf: Option[List[GrometWire]],
  wlc: Option[List[GrometWire]],
  wlopo: Option[List[GrometWire]],
  wlIiargs: Option[List[GrometWire]],
  wlIoargs: Option[List[GrometWire]],
  wlCargs: Option[List[GrometWire]],
  bc: Option[List[GrometBoxConditional]],
  pic: Option[List[GrometPort]],
  poc: Option[List[GrometPort]],
  wcopi: Option[List[GrometWire]],
  wcl: Option[List[GrometWire]],
  wcf: Option[List[GrometWire]],
  wcc: Option[List[GrometWire]],
  wcopo: Option[List[GrometWire]],
  wcCargs: Option[List[GrometWire]],
  metadata: Option[Int] */
)

object GrometFN {
  implicit lazy val grometFNJsonFormat: Format[GrometFN] = Json.format[GrometFN]
}

