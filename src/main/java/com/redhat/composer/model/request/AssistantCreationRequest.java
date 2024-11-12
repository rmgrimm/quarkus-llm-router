package com.redhat.composer.model.request;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

@SuppressWarnings("all")
public class AssistantCreationRequest {

  String name;
  String displayName;
  String description;

  String llmConnectionId;

  String retrieverConnectionId;


  public AssistantCreationRequest() {
  }

  public AssistantCreationRequest(String name, String displayName, String description, String llmConnectionId, String retrieverConnectionId) {
    this.name = name;
    this.displayName = displayName;
    this.description = description;
    this.llmConnectionId = llmConnectionId;
    this.retrieverConnectionId = retrieverConnectionId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return this.displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLlmConnectionId() {
    return this.llmConnectionId;
  }

  public void setLlmConnectionId(String llmConnectionId) {
    this.llmConnectionId = llmConnectionId;
  }

  public String getRetrieverConnectionId() {
    return this.retrieverConnectionId;
  }

  public void setRetrieverConnectionId(String retrieverConnectionId) {
    this.retrieverConnectionId = retrieverConnectionId;
  }

  public AssistantCreationRequest name(String name) {
    setName(name);
    return this;
  }

  public AssistantCreationRequest displayName(String displayName) {
    setDisplayName(displayName);
    return this;
  }

  public AssistantCreationRequest description(String description) {
    setDescription(description);
    return this;
  }

  public AssistantCreationRequest llmConnectionId(String llmConnectionId) {
    setLlmConnectionId(llmConnectionId);
    return this;
  }

  public AssistantCreationRequest retrieverConnectionId(String retrieverConnectionId) {
    setRetrieverConnectionId(retrieverConnectionId);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, displayName, description, llmConnectionId, retrieverConnectionId);
  }

  @Override
  public String toString() {
    return "{" +
      " name='" + getName() + "'" +
      ", displayName='" + getDisplayName() + "'" +
      ", description='" + getDescription() + "'" +
      ", llmConnectionId='" + getLlmConnectionId() + "'" +
      ", retrieverConnectionId='" + getRetrieverConnectionId() + "'" +
      "}";
  }

}