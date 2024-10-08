package com.redhat.composer.model.mongo;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.redhat.composer.config.retriever.contentRetriever.ContentRetrieverClientFactory;
import com.redhat.composer.config.retriever.embeddingModel.EmbeddingModelFactory;

import io.quarkus.mongodb.panache.common.MongoEntity;


@MongoEntity(collection = "retriever_connection")
public class RetrieverConnectionEntity extends BaseEntity {

  String contentRetrieverType;
  String embeddingType;

  String name;
  private String description;
  
  // Key of the value containing the text used for retrieval and passed into the LLM
  String textKey;

  // List of metadata fields to be retrieved as part of the content
  List<String> metadataFields = List.of("source");

  String index;

  String scheme;

  String host;

  String apiKey;

  public RetrieverConnectionEntity() {
  }

  public RetrieverConnectionEntity(String contentRetrieverType, String embeddingType, String name, String description, String textKey, List<String> metadataFields, String index, String scheme, String host, String apiKey) {
    this.contentRetrieverType = contentRetrieverType;
    this.embeddingType = embeddingType;
    this.name = name;
    this.description = description;
    this.textKey = textKey;
    this.metadataFields = metadataFields;
    this.index = index;
    this.scheme = scheme;
    this.host = host;
    this.apiKey = apiKey;
  }

  public String getContentRetrieverType() {
    return this.contentRetrieverType;
  }

  public void setContentRetrieverType(String contentRetrieverType) {
    this.contentRetrieverType = contentRetrieverType;
  }

  public String getEmbeddingType() {
    return this.embeddingType;
  }

  public void setEmbeddingType(String embeddingType) {
    this.embeddingType = embeddingType;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTextKey() {
    return this.textKey;
  }

  public void setTextKey(String textKey) {
    this.textKey = textKey;
  }

  public List<String> getMetadataFields() {
    return this.metadataFields;
  }

  public void setMetadataFields(List<String> metadataFields) {
    this.metadataFields = metadataFields;
  }

  public String getIndex() {
    return this.index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public String getScheme() {
    return this.scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getApiKey() {
    return this.apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public RetrieverConnectionEntity contentRetrieverType(String contentRetrieverType) {
    setContentRetrieverType(contentRetrieverType);
    return this;
  }

  public RetrieverConnectionEntity embeddingType(String embeddingType) {
    setEmbeddingType(embeddingType);
    return this;
  }

  public RetrieverConnectionEntity name(String name) {
    setName(name);
    return this;
  }

  public RetrieverConnectionEntity description(String description) {
    setDescription(description);
    return this;
  }

  public RetrieverConnectionEntity textKey(String textKey) {
    setTextKey(textKey);
    return this;
  }

  public RetrieverConnectionEntity metadataFields(List<String> metadataFields) {
    setMetadataFields(metadataFields);
    return this;
  }

  public RetrieverConnectionEntity index(String index) {
    setIndex(index);
    return this;
  }

  public RetrieverConnectionEntity scheme(String scheme) {
    setScheme(scheme);
    return this;
  }

  public RetrieverConnectionEntity host(String host) {
    setHost(host);
    return this;
  }

  public RetrieverConnectionEntity apiKey(String apiKey) {
    setApiKey(apiKey);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentRetrieverType, embeddingType, name, description, textKey, metadataFields, index, scheme, host, apiKey);
  }

  @Override
  public String toString() {
    return "{" +
      " contentRetrieverType='" + getContentRetrieverType() + "'" +
      ", embeddingType='" + getEmbeddingType() + "'" +
      ", name='" + getName() + "'" +
      ", description='" + getDescription() + "'" +
      ", textKey='" + getTextKey() + "'" +
      ", metadataFields='" + getMetadataFields() + "'" +
      ", index='" + getIndex() + "'" +
      ", scheme='" + getScheme() + "'" +
      ", host='" + getHost() + "'" +
      ", apiKey='" + getApiKey() + "'" +
      "}";
  }


  
}
