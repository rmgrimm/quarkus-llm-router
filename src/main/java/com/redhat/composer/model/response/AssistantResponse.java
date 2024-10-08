package com.redhat.composer.model.response;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.redhat.composer.model.mongo.AssistantEntity;
import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;

public class AssistantResponse extends AssistantEntity {

  private LLMConnectionEntity llmConnection;
  private RetrieverConnectionEntity retrieverConnection;


  public AssistantResponse() {
  }


  public AssistantResponse(LLMConnectionEntity llmConnection, RetrieverConnectionEntity retrieverConnection) {
    this.llmConnection = llmConnection;
    this.retrieverConnection = retrieverConnection;
  }

  public LLMConnectionEntity getLlmConnection() {
    return this.llmConnection;
  }

  public void setLlmConnection(LLMConnectionEntity llmConnection) {
    this.llmConnection = llmConnection;
  }

  public RetrieverConnectionEntity getRetrieverConnection() {
    return this.retrieverConnection;
  }

  public void setRetrieverConnection(RetrieverConnectionEntity retrieverConnection) {
    this.retrieverConnection = retrieverConnection;
  }

  public AssistantResponse llmConnection(LLMConnectionEntity llmConnection) {
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
