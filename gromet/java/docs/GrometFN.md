# GrometFN

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of the Function Network  |  [optional]
**b** | [**List&lt;GrometBoxFunction&gt;**](GrometBoxFunction.md) | b: The FN Outer Box (although not enforced, there is always only 1).  |  [optional]
**opi** | [**List&lt;GrometPort&gt;**](GrometPort.md) | opi: The Outer Port Inputs of the FN Outer Box (b)  |  [optional]
**opo** | [**List&lt;GrometPort&gt;**](GrometPort.md) | opo: The Outer Port Outputs of the FN Outer Box (b)  |  [optional]
**wopio** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wopio: The Wires from (src) Outer Box Outer Port Inputs (opi) to (tgt) Outer Box Outer Port Outputs (opo). (AKA: Passthrough.)  |  [optional]
**bf** | [**List&lt;GrometBoxFunction&gt;**](GrometBoxFunction.md) | bf: The GrometBoxFunctions within this GrometFN.  |  [optional]
**pif** | [**List&lt;GrometPort&gt;**](GrometPort.md) | pif: The Port Inputs of the GrometBoxFunctions (bf).  |  [optional]
**pof** | [**List&lt;GrometPort&gt;**](GrometPort.md) | pof: The Port Outputs of the GrometBoxFunctions (bf).  |  [optional]
**wfopi** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wfopi: The Wires from (src) GrometBoxFunctions Port Inputs (pif) to (tgt) Outer Box Outer Port Inputs (opi).  |  [optional]
**wfl** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wfl: The Wires from (src) GrometBoxLoops Port Inputs (pil) to (tgt) GrometBoxFunctions Port Outputs (pof).  |  [optional]
**wff** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wff: The Wires from (src) GrometBoxFunctions Port Inputs (pif) to (tgt) GrometBoxFunctions Port Outputs (pof).  |  [optional]
**wfc** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wfc: The Wires from (src) GrometBoxConditionals Port Inputs (pic) to (tgt) GrometBoxFunctions Port Outputs (pof).  |  [optional]
**wfopo** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wfopo: The Wires from (src) Outer Box Outer Port Outputs (opo) to (tgt) GrometBoxFunctions Port Outputs (pof).  |  [optional]
**bl** | [**List&lt;GrometBoxLoop&gt;**](GrometBoxLoop.md) | bl: The FN GrometBoxLoops within this GrometFN.  |  [optional]
**pil** | [**List&lt;GrometPort&gt;**](GrometPort.md) | pil: The Port Inputs of the GrometBoxLoops (bl)  |  [optional]
**pol** | [**List&lt;GrometPort&gt;**](GrometPort.md) | pol: The Port Outputs of the GrometBoxLoops (bl)  |  [optional]
**wlopi** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wlopi: The Wires from (src) GrometBoxLoops Port Inputs (pil) to (tgt) the Outer Box Outer Port Inputs (opi).  |  [optional]
**wll** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wll: The Wires from (src) the GrometBoxLoops Port Inputs (pil) to (tgt) the GrometBoxLoops Port Outputs (pol).  |  [optional]
**wlf** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wlf: The Wires from (src) the GrometBoxFunctions Port Inputs (pif) to (tgt) the GrometBoxLoops Port Outputs (pol).  |  [optional]
**wlc** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wlc: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the GrometBoxLoops Port Outputs (pol).  |  [optional]
**wlopo** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wlopo: The Wires from (src) Outer Box Outer Port Outputs (opo) to (tgt) GrometBoxLoops Port Outputs (pol).  |  [optional]
**wlIiargs** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wl_iiargs: The Wires from (src) the arguments (the Port Inputs) of the Loop init (itself a Function, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Loop (pil). It is through these Wires that the Loop init Function gets its input argument values before the init Function is evaluated; these values originate from outside of the Loop.  |  [optional]
**wlIoargs** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wl_ioargs: The Wires from (src) the Port Inputs of the Loop (pil) to (tgt) the Port Outputs of the Loop init (itself a Function, a type of GrometBoxFunction) (pof). It is through these Wires that the Loop Port Inputs get their values initialized after evaluation of the init Function.  |  [optional]
**wlCargs** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wl_cargs: The Wires from (src) the arguments (the Port Inputs) of the Loop condition (itself a Predicate, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Loop (pil). It is through these Wires that the Loop condition Predicate gets its input argument values from the current state of the Loop Input Ports.  |  [optional]
**bc** | [**List&lt;GrometBoxConditional&gt;**](GrometBoxConditional.md) | bc: The FN GrometBoxConditionals within this GrometFN.  |  [optional]
**pic** | [**List&lt;GrometPort&gt;**](GrometPort.md) | pic: The Port Inputs of the GrometBoxConditionals (bc)  |  [optional]
**poc** | [**List&lt;GrometPort&gt;**](GrometPort.md) | poc: The Port Outputs of the GrometBoxConditionals (bc)  |  [optional]
**wcopi** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wcopi: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the Outer Box Outer Port Inputs (opi).  |  [optional]
**wcl** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wcl: The Wires from (src) the GrometBoxLoops Port Inputs (pil) to (tgt) the GrometBoxConditionals Port Outputs (poc).  |  [optional]
**wcf** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wcf: The Wires from (src) the GrometBoxFunctions Port Inputs (pif) to (tgt) the GrometBoxConditionals Port Outputs (poc).  |  [optional]
**wcc** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wcc: The Wires from (src) the GrometBoxConditionals Port Inputs (pic) to (tgt) the GrometBoxConditionals Port Outputs (poc).  |  [optional]
**wcopo** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wcopo: The Wires from (src) the Outer Box Outer Port Outputs (opo) to (tgt) the GrometBoxConditionals Port Outputs (poc).  |  [optional]
**wcCargs** | [**List&lt;GrometWire&gt;**](GrometWire.md) | wc_cargs: The Wires from (src) the arguments (the Port Inputs) of the Conditional condition (itself a Predicate, a type of GrometBoxFunction) (pif) to (tgt) the Port Inputs of the Conditional (pic). It is through these Wires that the Conditional condition Predicate gets its input argument values from the Conditional Input Ports.  |  [optional]