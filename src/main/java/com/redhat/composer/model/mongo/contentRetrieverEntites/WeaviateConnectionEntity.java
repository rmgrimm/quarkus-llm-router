package com.redhat.composer.model.mongo.contentRetrieverEntites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import com.redhat.composer.model.enums.ContentRetrieverType;

import java.util.List;
import java.util.Objects;

@BsonDiscriminator("weaviate")
public class WeaviateConnectionEntity extends BaseRetrieverConnectionEntity {

  // Key of the value containing the text used for retrieval and passed into the LLM
  String textKey;

  // List of metadata fields to be retrieved as part of the content
  List<String> metadataFields = List.of("source");

  String index;

  String scheme;

  String host;

  String apiKey;


  public WeaviateConnectionEntity() {
    contentRetrieverType = ContentRetrieverType.WEAVIATE;
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

  public WeaviateConnectionEntity textKey(String textKey) {
    setTextKey(textKey);
    return this;
  }

  public WeaviateConnectionEntity metadataFields(List<String> metadataFields) {
    setMetadataFields(metadataFields);
    return this;
  }

  public WeaviateConnectionEntity index(String index) {
    setIndex(index);
    return this;
  }

  public WeaviateConnectionEntity scheme(String scheme) {
    setScheme(scheme);
    return this;
  }

  public WeaviateConnectionEntity host(String host) {
    setHost(host);
    return this;
  }

  public WeaviateConnectionEntity apiKey(String apiKey) {
    setApiKey(apiKey);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textKey, metadataFields, index, scheme, host, apiKey);
  }

  @Override
  public String toString() {
    return "{" +
      " textKey='" + getTextKey() + "'" +
      ", metadataFields='" + getMetadataFields() + "'" +
      ", index='" + getIndex() + "'" +
      ", scheme='" + getScheme() + "'" +
      ", host='" + getHost() + "'" +
      ", apiKey='" + getApiKey() + "'" +
      "}";
  }
  
  
}
