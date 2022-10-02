# GrometPort

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | The Port id is a natural number that represent the order of the Port on the Box. This enables the following: (1) BoxFunctions with FN context will be able to unambiguously match the \&quot;calling\&quot; BoxFunction Port Inputs (pif) (and Port Outputs, pof) to their corresonding Outer Port Inputs (opi) (and Outer Port Outputs, opo) based in the ordering of the ids of each Port. (2) Loop Port Input (pil) id ordering will match the Loop Port Output (pol) as well as the ordering of the Port Inputs and Port Outputs of the calling loop body Function.  |  [optional]
**name** | **String** |  |  [optional]
**box** | **Integer** | Index to the Box that the Port belongs to. |  [optional]
