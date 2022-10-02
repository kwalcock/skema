/**
 * Grounded Model Exchange (GroMEt) schema for Function Networks
 * This document defines the GroMEt Function Network data model. Note that Metadata is defined in separate spec.  __Using Swagger to Generate Class Structure__  To automatically generate Python or Java models corresponding to this document, you can use [swagger-codegen](https://swagger.io/tools/swagger-codegen/). This can be used to generate the client code based off of this spec, and in the process this will generate the data model class structure.  1. Install via the method described for your operating system    [here](https://github.com/swagger-api/swagger-codegen#Prerequisites).    Make sure to install a version after 3.0 that will support openapi 3. 2. Run swagger-codegen with the options in the example below.    The URL references where the yaml for this documentation is stored on    github. Make sure to replace CURRENT_VERSION with the correct version.    (The current version is `0.1.4`.)    To generate Java classes rather, change the `-l python` to `-l java`.    Change the value to the `-o` option to the desired output location.    ```    swagger-codegen generate -l python -o ./client -i https://raw.githubusercontent.com/ml4ai/automates-v2/master/docs/source/gromet_FN_v{CURRENT_VERSION}.yaml    ``` 3. Once it executes, the client code will be generated at your specified    location.    For python, the classes will be located in    `$OUTPUT_PATH/swagger_client/models/`.    For java, they will be located in    `$OUTPUT_PATH/src/main/java/io/swagger/client/model/`  If generating GroMEt schema data model classes in SKEMA (AutoMATES), then afer generating the above, follow the instructions here: ``` <automates>/automates/model_assembly/gromet/model/README.md ``` 
 *
 * OpenAPI spec version: 0.1.4
 * Contact: claytonm@arizona.edu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.model


/**
 * @param name The qualified name of the import. The qualified name includes the module path to the element being imported. E.g., \"numpy.concatenate\" is the qualified name for importing the concatenate function from numpy. If the element being imported is from an existing GROMET_FN_MODULE, then the qualified names ends in a colon followed by the integer, where the integer references the index in the GrometFNModule.attributes for the corresponding FN. 
 * @param srcLanguage The programming language of the imported module
 * @param `type` 
 * @param version The import source name and version (if available) of the element being imported. For example, if important a native library from Python 3.10, then this would be \"Python 3.10\". 
 * @param uri 
 */
case class ImportReference (
  name: Option[String] = None,
  srcLanguage: Option[String] = None,
  `type`: Option[ImportType] = None,
  version: Option[String] = None,
  uri: Option[TypedValue] = None
)
