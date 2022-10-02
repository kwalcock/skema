# GrometFNModule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schema** | **String** |  |  [optional]
**schemaVersion** | **String** |  |  [optional]
**name** | **String** | The name of the Function Network Module.  |  [optional]
**fn** | [**GrometFN**](GrometFN.md) |  |  [optional]
**attributes** | [**List&lt;TypedValue&gt;**](TypedValue.md) | (sum-type) Array of TypedValues. Currently expect:&lt;br&gt; (1) other GrometFN (type &#x3D; \&quot;FN\&quot;)&lt;br&gt; (2) references to ImportReference (type &#x3D; \&quot;IMPORT\&quot;)  |  [optional]
**metadataCollection** | [**List&lt;List&lt;Metadata&gt;&gt;**](List.md) | Table (array) of lists (arrays) of metadata, where each list in the Table-array represents the collection of metadata associated with a GroMEt object.  |  [optional]
