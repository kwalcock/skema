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
import io.swagger.client.model.CodeFileReference;
import io.swagger.client.model.Metadata;
import io.swagger.client.model.Provenance;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Reference to a source code collection (e.g., a repository)
 */
@Schema(description = "Reference to a source code collection (e.g., a repository)")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-09T12:36:06.656-07:00[America/Phoenix]")
public class SourceCodeCollection extends Metadata {
  @SerializedName("metadata_type")
  private String metadataType = "source_code_collection";

  @SerializedName("name")
  private String name = null;

  @SerializedName("global_reference_id")
  private String globalReferenceId = null;

  @SerializedName("files")
  private List<CodeFileReference> files = null;

  public SourceCodeCollection metadataType(String metadataType) {
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

  public SourceCodeCollection name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Code Collection name
   * @return name
  **/
  @Schema(description = "Code Collection name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SourceCodeCollection globalReferenceId(String globalReferenceId) {
    this.globalReferenceId = globalReferenceId;
    return this;
  }

   /**
   * URL (e.g., GitHub url), or aske_id 
   * @return globalReferenceId
  **/
  @Schema(description = "URL (e.g., GitHub url), or aske_id ")
  public String getGlobalReferenceId() {
    return globalReferenceId;
  }

  public void setGlobalReferenceId(String globalReferenceId) {
    this.globalReferenceId = globalReferenceId;
  }

  public SourceCodeCollection files(List<CodeFileReference> files) {
    this.files = files;
    return this;
  }

  public SourceCodeCollection addFilesItem(CodeFileReference filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<CodeFileReference>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @Schema(description = "")
  public List<CodeFileReference> getFiles() {
    return files;
  }

  public void setFiles(List<CodeFileReference> files) {
    this.files = files;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceCodeCollection sourceCodeCollection = (SourceCodeCollection) o;
    return Objects.equals(this.metadataType, sourceCodeCollection.metadataType) &&
        Objects.equals(this.name, sourceCodeCollection.name) &&
        Objects.equals(this.globalReferenceId, sourceCodeCollection.globalReferenceId) &&
        Objects.equals(this.files, sourceCodeCollection.files) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataType, name, globalReferenceId, files, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceCodeCollection {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    globalReferenceId: ").append(toIndentedString(globalReferenceId)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
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