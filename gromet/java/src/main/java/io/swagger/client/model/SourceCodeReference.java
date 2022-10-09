/*
 * GroMEt Metadata spec
 * Grounded Model Exchange (GroMEt) Metadata schema specification  __Using Swagger to Generate Class Structure__  To automatically generate Python or Java models corresponding to this document, you can use [swagger-codegen](https://swagger.io/tools/swagger-codegen/). We can use this to generate client code based off of this spec that will also generate the class structure.  1. Install via the method described for your operating system    [here](https://github.com/swagger-api/swagger-codegen#Prerequisites).    Make sure to install a version after 3.0 that will support openapi 3. 2. Run swagger-codegen with the options in the example below.    The URL references where the yaml for this documentation is stored on    github. Make sure to replace CURRENT_VERSION with the correct version.    (The current version is `0.1.4`.)    To generate Java classes rather, change the `-l python` to `-l java`.    Change the value to the `-o` option to the desired output location.    ```    swagger-codegen generate -l python -o ./client -i https://raw.githubusercontent.com/ml4ai/automates-v2/master/docs/source/gromet_metadata_v{CURRENT_VERSION}.yaml    ``` 3. Once it executes, the client code will be generated at your specified    location.    For python, the classes will be located in    `$OUTPUT_PATH/swagger_client/models/`.    For java, they will be located in    `$OUTPUT_PATH/src/main/java/io/swagger/client/model/`  If generating GroMEt Metadata schema data model classes in SKEMA (AutoMATES), then afer generating the above, follow the instructions here: ``` <automates>/automates/model_assembly/gromet/metadata/README.md ``` 
 *
 * OpenAPI spec version: 0.1.4
 * Contact: claytonm@email.arizona.edu
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
import io.swagger.client.model.Metadata;
import io.swagger.client.model.Provenance;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.UUID;
/**
 * Reference to a source code span (sub-line, line, block). 
 */
@Schema(description = "Reference to a source code span (sub-line, line, block). ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-09T12:36:06.656-07:00[America/Phoenix]")
public class SourceCodeReference extends Metadata {
  @SerializedName("metadata_type")
  private String metadataType = "source_code_reference";

  @SerializedName("code_file_reference_uid")
  private UUID codeFileReferenceUid = null;

  @SerializedName("line_begin")
  private Integer lineBegin = null;

  @SerializedName("line_end")
  private Integer lineEnd = null;

  @SerializedName("col_begin")
  private Integer colBegin = null;

  @SerializedName("col_end")
  private Integer colEnd = null;

  public SourceCodeReference metadataType(String metadataType) {
    this.metadataType = metadataType;
    return this;
  }

   /**
   * Get metadataType
   * @return metadataType
  **/
  @Schema(description = "")
  public String getMetadataType() {
    return metadataType;
  }

  public void setMetadataType(String metadataType) {
    this.metadataType = metadataType;
  }

  public SourceCodeReference codeFileReferenceUid(UUID codeFileReferenceUid) {
    this.codeFileReferenceUid = codeFileReferenceUid;
    return this;
  }

   /**
   * uid for the source code file CodeFileReference
   * @return codeFileReferenceUid
  **/
  @Schema(description = "uid for the source code file CodeFileReference")
  public UUID getCodeFileReferenceUid() {
    return codeFileReferenceUid;
  }

  public void setCodeFileReferenceUid(UUID codeFileReferenceUid) {
    this.codeFileReferenceUid = codeFileReferenceUid;
  }

  public SourceCodeReference lineBegin(Integer lineBegin) {
    this.lineBegin = lineBegin;
    return this;
  }

   /**
   * The line number where the identifier name string occurs
   * @return lineBegin
  **/
  @Schema(description = "The line number where the identifier name string occurs")
  public Integer getLineBegin() {
    return lineBegin;
  }

  public void setLineBegin(Integer lineBegin) {
    this.lineBegin = lineBegin;
  }

  public SourceCodeReference lineEnd(Integer lineEnd) {
    this.lineEnd = lineEnd;
    return this;
  }

   /**
   * The line number where the identifier name string occurs
   * @return lineEnd
  **/
  @Schema(description = "The line number where the identifier name string occurs")
  public Integer getLineEnd() {
    return lineEnd;
  }

  public void setLineEnd(Integer lineEnd) {
    this.lineEnd = lineEnd;
  }

  public SourceCodeReference colBegin(Integer colBegin) {
    this.colBegin = colBegin;
    return this;
  }

   /**
   * The start column of the identifier name string instance
   * @return colBegin
  **/
  @Schema(description = "The start column of the identifier name string instance")
  public Integer getColBegin() {
    return colBegin;
  }

  public void setColBegin(Integer colBegin) {
    this.colBegin = colBegin;
  }

  public SourceCodeReference colEnd(Integer colEnd) {
    this.colEnd = colEnd;
    return this;
  }

   /**
   * The end column of the identifier name string instance
   * @return colEnd
  **/
  @Schema(description = "The end column of the identifier name string instance")
  public Integer getColEnd() {
    return colEnd;
  }

  public void setColEnd(Integer colEnd) {
    this.colEnd = colEnd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceCodeReference sourceCodeReference = (SourceCodeReference) o;
    return Objects.equals(this.metadataType, sourceCodeReference.metadataType) &&
        Objects.equals(this.codeFileReferenceUid, sourceCodeReference.codeFileReferenceUid) &&
        Objects.equals(this.lineBegin, sourceCodeReference.lineBegin) &&
        Objects.equals(this.lineEnd, sourceCodeReference.lineEnd) &&
        Objects.equals(this.colBegin, sourceCodeReference.colBegin) &&
        Objects.equals(this.colEnd, sourceCodeReference.colEnd) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataType, codeFileReferenceUid, lineBegin, lineEnd, colBegin, colEnd, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceCodeReference {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    codeFileReferenceUid: ").append(toIndentedString(codeFileReferenceUid)).append("\n");
    sb.append("    lineBegin: ").append(toIndentedString(lineBegin)).append("\n");
    sb.append("    lineEnd: ").append(toIndentedString(lineEnd)).append("\n");
    sb.append("    colBegin: ").append(toIndentedString(colBegin)).append("\n");
    sb.append("    colEnd: ").append(toIndentedString(colEnd)).append("\n");
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
