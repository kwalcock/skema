# NAME

Grounded Model Exchange (GroMEt) schema for Function Networks

This document defines the GroMEt Function Network data model. Note that Metadata is defined in separate spec.  __Using Swagger to Generate Class Structure__  To automatically generate Python or Java models corresponding to this document, you can use [swagger-codegen](https://swagger.io/tools/swagger-codegen/). This can be used to generate the client code based off of this spec, and in the process this will generate the data model class structure.  1. Install via the method described for your operating system    [here](https://github.com/swagger-api/swagger-codegen#Prerequisites).    Make sure to install a version after 3.0 that will support openapi 3. 2. Run swagger-codegen with the options in the example below.    The URL references where the yaml for this documentation is stored on    github. Make sure to replace CURRENT_VERSION with the correct version.    (The current version is `0.1.4`.)    To generate Java classes rather, change the `-l python` to `-l java`.    Change the value to the `-o` option to the desired output location.    ```    swagger-codegen generate -l python -o ./client -i https://raw.githubusercontent.com/ml4ai/automates-v2/master/docs/source/gromet_FN_v{CURRENT_VERSION}.yaml    ``` 3. Once it executes, the client code will be generated at your specified    location.    For python, the classes will be located in    `$OUTPUT_PATH/swagger_client/models/`.    For java, they will be located in    `$OUTPUT_PATH/src/main/java/io/swagger/client/model/`  If generating GroMEt schema data model classes in SKEMA (AutoMATES), then afer generating the above, follow the instructions here: ``` <automates>/automates/model_assembly/gromet/model/README.md ``` 

# VERSION

Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 0.1.4
- Package version: 
- Build package: io.swagger.codegen.v3.generators.scala.ScalaClientCodegen

# Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-scala-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-scala-client:1.0.0"
```

### SBT users

```scala
libraryDependencies += "io.swagger" % "swagger-scala-client" % "1.0.0"
```

## Documentation for API Endpoints

All URIs are relative to */*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------

## Documentation for Models

 - [AttributeType](AttributeType.md)
 - [FunctionType](FunctionType.md)
 - [GrometBox](GrometBox.md)
 - [GrometBoxConditional](GrometBoxConditional.md)
 - [GrometBoxFunction](GrometBoxFunction.md)
 - [GrometBoxLoop](GrometBoxLoop.md)
 - [GrometFN](GrometFN.md)
 - [GrometFNModule](GrometFNModule.md)
 - [GrometObject](GrometObject.md)
 - [GrometPort](GrometPort.md)
 - [GrometWire](GrometWire.md)
 - [ImportReference](ImportReference.md)
 - [ImportType](ImportType.md)
 - [LiteralValue](LiteralValue.md)
 - [Metadata](Metadata.md)
 - [SourceType](SourceType.md)
 - [TypedValue](TypedValue.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:


# BUILDING YOUR LIBRARY

See the homepage `https://github.com/swagger-api/swagger-codegen` for full details.
But briefly, clone the git repository, build the codegen codebase, set up your build
config file, then run the API build script. You will need git, Java 7 or 8 and Apache
maven 3.0.3 or better already installed.

Your library files will be built under `WWW::MyProjectName`.

          $ git clone https://github.com/swagger-api/swagger-codegen.git
          $ cd swagger-codegen
          $ mvn package
          $ java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i [URL or file path to JSON swagger API spec] \
    -l akka-scala \
    -c /path/to/config/file.json \
    -o /path/to/output/folder

Bang, all done. Run the `autodoc` script in the `bin` directory to see the API
you just built.

## Author
