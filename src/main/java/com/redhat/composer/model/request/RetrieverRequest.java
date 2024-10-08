package com.redhat.composer.model.request;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.redhat.composer.config.retriever.contentRetriever.ContentRetrieverClientFactory;
import com.redhat.composer.config.retriever.embeddingModel.EmbeddingModelFactory;

public class RetrieverRequest  {
  
  String contentRetrieverType;
  String embeddingType;

  // Key of the value containing the text used for retrieval and passed into the LLM
  String textKey;

  // List of metadata fields to be retrieved as part of the content
  List<String> metadataFields = List.of("source");

  String index;

  String scheme;

  String host;

  String apiKey;

  public RetrieverRequest() {
  }

  public RetrieverRequest(String contentRetrieverType, String embeddingType, String textKey, List<String> metadataFields, String index, String scheme, String host, String apiKey) {
    this.contentRetrieverType = contentRetrieverType;
    this.embeddingType = embeddingType;
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

  public RetrieverRequest contentRetrieverType(String contentRetrieverType) {
    setContentRetrieverType(contentRetrieverType);
    return this;
  }

  public RetrieverRequest embeddingType(String embeddingType) {
    setEmbeddingType(embeddingType);
    return this;
  }

  public RetrieverRequest textKey(String textKey) {
    setTextKey(textKey);
    return this;
  }

  public RetrieverRequest metadataFields(List<String> metadataFields) {
    setMetadataFields(metadataFields);
    return this;
  }

  public RetrieverRequest index(String index) {
    setIndex(index);
    return this;
  }

  public RetrieverRequest scheme(String scheme) {
    setScheme(scheme);
    return this;
  }

  public RetrieverRequest host(String host) {
    setHost(host);
    return this;
  }

  public RetrieverRequest apiKey(String apiKey) {
    setApiKey(apiKey);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentRetrieverType, embeddingType, textKey, metadataFields, index, scheme, host, apiKey);
  }

  @Override
  public String toString() {
    return "{" +
      " contentRetrieverType='" + getContentRetrieverType() + "'" +
      ", embeddingType='" + getEmbeddingType() + "'" +
      ", textKey='" + getTextKey() + "'" +
      ", metadataFields='" + getMetadataFields() + "'" +
      ", index='" + getIndex() + "'" +
      ", scheme='" + getScheme() + "'" +
      ", host='" + getHost() + "'" +
      ", apiKey='" + getApiKey() + "'" +
      "}";
  }
  
  
}
