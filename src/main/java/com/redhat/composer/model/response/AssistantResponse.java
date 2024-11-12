package com.redhat.composer.model.response;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.redhat.composer.model.mongo.AssistantEntity;
import com.redhat.composer.model.mongo.LlmConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;

@SuppressWarnings("all")
public class AssistantResponse extends AssistantEntity {

  private LlmConnectionEntity llmConnection;
  private RetrieverConnectionEntity retrieverConnection;


  public AssistantResponse() {
  }


  public AssistantResponse(LlmConnectionEntity llmConnection, RetrieverConnectionEntity retrieverConnection) {
    this.llmConnection = llmConnection;
    this.retrieverConnection = retrieverConnection;
  }

  public LlmConnectionEntity getLlmConnection() {
    return this.llmConnection;
  }

  public void setLlmConnection(LlmConnectionEntity llmConnection) {
    this.llmConnection = llmConnection;
  }

  public RetrieverConnectionEntity getRetrieverConnection() {
    return this.retrieverConnection;
  }

  public void setRetrieverConnection(RetrieverConnectionEntity retrieverConnection) {
    this.retrieverConnection = retrieverConnection;
  }

  public AssistantResponse llmConnection(LlmConnectionEntity llmConnection) {
    setLlmConnection(llmConnection);
    return this;
  }

  public AssistantResponse retrieverConnection(RetrieverConnectionEntity retrieverConnection) {
    setRetrieverConnection(retrieverConnection);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(llmConnection, retrieverConnection);
  }

  @Override
  public String toString() {
    return "{" +
      " llmConnection='" + getLlmConnection() + "'" +
      ", retrieverConnection='" + getRetrieverConnection() + "'" +
      "}";
  }

  
  
}
