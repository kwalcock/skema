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
import io.swagger.client.model.TextualDocumentReference;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A collection of textual document references (e.g., documentation, scientific publication, etc.). 
 */
@Schema(description = "A collection of textual document references (e.g., documentation, scientific publication, etc.). ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-09T12:36:06.656-07:00[America/Phoenix]")
public class TextualDocumentCollection extends Metadata {
  @SerializedName("metadata_type")
  private String metadataType = "textual_document_collection";

  @SerializedName("documents")
  private List<TextualDocumentReference> documents = null;

  public TextualDocumentCollection metadataType(String metadataType) {
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

  public TextualDocumentCollection documents(List<TextualDocumentReference> documents) {
    this.documents = documents;
    return this;
  }

  public TextualDocumentCollection addDocumentsItem(TextualDocumentReference documentsItem) {
    if (this.documents == null) {
      this.documents = new ArrayList<TextualDocumentReference>();
    }
    this.documents.add(documentsItem);
    return this;
  }

   /**
   * List of document references
   * @return documents
  **/
  @Schema(description = "List of document references")
  public List<TextualDocumentReference> getDocuments() {
    return documents;
  }

  public void setDocuments(List<TextualDocumentReference> documents) {
    this.documents = documents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextualDocumentCollection textualDocumentCollection = (TextualDocumentCollection) o;
    return Objects.equals(this.metadataType, textualDocumentCollection.metadataType) &&
        Objects.equals(this.documents, textualDocumentCollection.documents) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataType, documents, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TextualDocumentCollection {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    documents: ").append(toIndentedString(documents)).append("\n");
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
