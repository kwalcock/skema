# ImportReference

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The qualified name of the import. The qualified name includes the module path to the element being imported. E.g., \&quot;numpy.concatenate\&quot; is the qualified name for importing the concatenate function from numpy. If the element being imported is from an existing GROMET_FN_MODULE, then the qualified names ends in a colon followed by the integer, where the integer references the index in the GrometFNModule.attributes for the corresponding FN.  |  [optional]
**srcLanguage** | **String** | The programming language of the imported module |  [optional]
**type** | [**ImportType**](ImportType.md) |  |  [optional]
**version** | **String** | The import source name and version (if available) of the element being imported. For example, if important a native library from Python 3.10, then this would be \&quot;Python 3.10\&quot;.  |  [optional]
**uri** | [**TypedValue**](TypedValue.md) |  |  [optional]
