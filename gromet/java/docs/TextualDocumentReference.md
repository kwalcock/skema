# TextualDocumentReference

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **String** | Unique identifier of the DocumentReference |  [optional]
**globalReferenceId** | **String** | Identifier of source document.&lt;br&gt; Rank preference of identifier type:&lt;br&gt; (1) DOI (digital object identifier) recognized by COSMOS&lt;br&gt; (2) PMID (Pubmed ID) or other DOI&lt;br&gt; (3) aske_id (ASKE unique identifier)  |  [optional]
**cosmosId** | **String** | ID of COSMOS component used to process document. |  [optional]
**cosmosVersionNumber** | **String** | Version number of COSMOS component. |  [optional]
**skemaId** | **String** | ID of SKEMA component used to process document. |  [optional]
**skemaVersionNumber** | **String** | Version number of SKEMA component. |  [optional]
**bibjson** | [**Bibjson**](Bibjson.md) |  |  [optional]
