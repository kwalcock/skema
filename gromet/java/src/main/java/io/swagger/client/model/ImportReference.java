/*
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

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.client.model.ImportType;
import io.swagger.client.model.TypedValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * ImportReference
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-02T01:18:52.196-07:00[America/Phoenix]")
public class ImportReference {
  @SerializedName("name")
  private String name = null;

  @SerializedName("src_language")
  private String srcLanguage = null;

  @SerializedName("type")
  private ImportType type = null;

  @SerializedName("version")
  private String version = null;

  @SerializedName("uri")
  private TypedValue uri = null;

  public ImportReference name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The qualified name of the import. The qualified name includes the module path to the element being imported. E.g., \&quot;numpy.concatenate\&quot; is the qualified name for importing the concatenate function from numpy. If the element being imported is from an existing GROMET_FN_MODULE, then the qualified names ends in a colon followed by the integer, where the integer references the index in the GrometFNModule.attributes for the corresponding FN. 
   * @return name
  **/
  @Schema(description = "The qualified name of the import. The qualified name includes the module path to the element being imported. E.g., \"numpy.concatenate\" is the qualified name for importing the concatenate function from numpy. If the element being imported is from an existing GROMET_FN_MODULE, then the qualified names ends in a colon followed by the integer, where the integer references the index in the GrometFNModule.attributes for the corresponding FN. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImportReference srcLanguage(String srcLanguage) {
    this.srcLanguage = srcLanguage;
    return this;
  }

   /**
   * The programming language of the imported module
   * @return srcLanguage
  **/
  @Schema(description = "The programming language of the imported module")
  public String getSrcLanguage() {
    return srcLanguage;
  }

  public void setSrcLanguage(String srcLanguage) {
    this.srcLanguage = srcLanguage;
  }

  public ImportReference type(ImportType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public ImportType getType() {
    return type;
  }

  public void setType(ImportType type) {
    this.type = type;
  }

  public ImportReference version(String version) {
    this.version = version;
    return this;
  }

   /**
   * The import source name and version (if available) of the element being imported. For example, if important a native library from Python 3.10, then this would be \&quot;Python 3.10\&quot;. 
   * @return version
  **/
  @Schema(description = "The import source name and version (if available) of the element being imported. For example, if important a native library from Python 3.10, then this would be \"Python 3.10\". ")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ImportReference uri(TypedValue uri) {
    this.uri = uri;
    return this;
  }

   /**
   * Get uri
   * @return uri
  **/
  @Schema(description = "")
  public TypedValue getUri() {
    return uri;
  }

  public void setUri(TypedValue uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportReference importReference = (ImportReference) o;
    return Objects.equals(this.name, importReference.name) &&
        Objects.equals(this.srcLanguage, importReference.srcLanguage) &&
        Objects.equals(this.type, importReference.type) &&
        Objects.equals(this.version, importReference.version) &&
        Objects.equals(this.uri, importReference.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, srcLanguage, type, version, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportReference {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    srcLanguage: ").append(toIndentedString(srcLanguage)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}