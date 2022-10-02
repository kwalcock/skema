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
import io.swagger.client.model.GrometBox;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * FN Box Loop. __Loop execution semantics__: The Boolean output Port of the condition Predicate represents the loop *exit condition*. Loop execution starts by first evaluating the init Function, if it is available. The output ports of the referenced init Function are mapped to the input ports to the Loop by the wl_iargs Wires: src Loop Port Inputs (pil) and tgt init BoxFunction Port Outputs (pof); these set the initial values as input to the loop. The init Function is evaluated only during the first iteration through the loop. Next (and on every subsequent iteration), the loop condition Predicate is evalutated. The Loop condition input Ports get their values by by Wires in the wl_cargs table that have as their src the loop condition Port Inputs (pif) and as tgt the Loop Port Inputs (pil). If the exit condition Port evaluates to True, then the current values at the input Ports to the Loop are copied to the output Ports and the execution moves past the Loop. Else, if the exit condition is False, then the values at the Outer Port Inputs are copied to the Loop body Input Ports, the body executes, and the resulting Output Ports of the body are copied to the Port Inputs (pil) of the loop and execution advances to the next round of Loop evaluation (which after the first iteration will go directly to evaluating the loop condition). &lt;br&gt; The Port Input (pil) Ports correspond 1-1 with Port Output (pol) Ports of the BoxLoop, as well as 1-1 with the Port Input Ports (pif) and Port Output Ports (pof) of the loop body BoxFunction Ports -- the indices of each of these Ports within all four tables (pil, pol, pif, pof) are the same (e.g., if index 22 is the Port Input of the loop, then that same index will be the corresponding Port in the Port Output (pol) of the loop as well as the Port Input (pif) and Port Output (pif) of the BoxFunction). 
 */
@Schema(description = "FN Box Loop. __Loop execution semantics__: The Boolean output Port of the condition Predicate represents the loop *exit condition*. Loop execution starts by first evaluating the init Function, if it is available. The output ports of the referenced init Function are mapped to the input ports to the Loop by the wl_iargs Wires: src Loop Port Inputs (pil) and tgt init BoxFunction Port Outputs (pof); these set the initial values as input to the loop. The init Function is evaluated only during the first iteration through the loop. Next (and on every subsequent iteration), the loop condition Predicate is evalutated. The Loop condition input Ports get their values by by Wires in the wl_cargs table that have as their src the loop condition Port Inputs (pif) and as tgt the Loop Port Inputs (pil). If the exit condition Port evaluates to True, then the current values at the input Ports to the Loop are copied to the output Ports and the execution moves past the Loop. Else, if the exit condition is False, then the values at the Outer Port Inputs are copied to the Loop body Input Ports, the body executes, and the resulting Output Ports of the body are copied to the Port Inputs (pil) of the loop and execution advances to the next round of Loop evaluation (which after the first iteration will go directly to evaluating the loop condition). <br> The Port Input (pil) Ports correspond 1-1 with Port Output (pol) Ports of the BoxLoop, as well as 1-1 with the Port Input Ports (pif) and Port Output Ports (pof) of the loop body BoxFunction Ports -- the indices of each of these Ports within all four tables (pil, pol, pif, pof) are the same (e.g., if index 22 is the Port Input of the loop, then that same index will be the corresponding Port in the Port Output (pol) of the loop as well as the Port Input (pif) and Port Output (pif) of the BoxFunction). ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-10-02T01:18:52.196-07:00[America/Phoenix]")
public class GrometBoxLoop extends GrometBox {
  @SerializedName("condition")
  private Integer condition = null;

  @SerializedName("init")
  private Integer init = null;

  @SerializedName("body")
  private Integer body = null;

  public GrometBoxLoop condition(Integer condition) {
    this.condition = condition;
    return this;
  }

   /**
   * The index to the entry in the BF table (array) of *this* GrometFN representing the loop condition Predicate of the Loop. 
   * @return condition
  **/
  @Schema(description = "The index to the entry in the BF table (array) of *this* GrometFN representing the loop condition Predicate of the Loop. ")
  public Integer getCondition() {
    return condition;
  }

  public void setCondition(Integer condition) {
    this.condition = condition;
  }

  public GrometBoxLoop init(Integer init) {
    this.init = init;
    return this;
  }

   /**
   * The index to the entry in the BF table (array) of *this* GrometFN representing the init (Function) of the Loop. This is primarily for the support of for-loops, cases where most languages have provided an extension to loops that have an initialization that is only in the scope of the loop, but not part of the loop body. 
   * @return init
  **/
  @Schema(description = "The index to the entry in the BF table (array) of *this* GrometFN representing the init (Function) of the Loop. This is primarily for the support of for-loops, cases where most languages have provided an extension to loops that have an initialization that is only in the scope of the loop, but not part of the loop body. ")
  public Integer getInit() {
    return init;
  }

  public void setInit(Integer init) {
    this.init = init;
  }

  public GrometBoxLoop body(Integer body) {
    this.body = body;
    return this;
  }

   /**
   * The index to the entry in the BF table (array) of *this* GrometFN representing the body (Function) of the Loop. 
   * @return body
  **/
  @Schema(description = "The index to the entry in the BF table (array) of *this* GrometFN representing the body (Function) of the Loop. ")
  public Integer getBody() {
    return body;
  }

  public void setBody(Integer body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrometBoxLoop grometBoxLoop = (GrometBoxLoop) o;
    return Objects.equals(this.condition, grometBoxLoop.condition) &&
        Objects.equals(this.init, grometBoxLoop.init) &&
        Objects.equals(this.body, grometBoxLoop.body) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(condition, init, body, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrometBoxLoop {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    init: ").append(toIndentedString(init)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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