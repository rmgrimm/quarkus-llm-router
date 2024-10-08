package com.redhat.composer.model.request;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class AssistantChatRequest{

  private String message = "";
  // This is where you can pass in chat history or other context
  private String context = "";
  private String assistantId;
  // Only used if id is not set
  private String assistantName;


  public AssistantChatRequest() {
  }

  public AssistantChatRequest(String message, String context, String assistantId, String assistantName) {
    this.message = message;
    this.context = context;
    this.assistantId = assistantId;
    this.assistantName = assistantName;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getContext() {
    return this.context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getAssistantId() {
    return this.assistantId;
  }

  public void setAssistantId(String assistantId) {
    this.assistantId = assistantId;
  }

  public String getAssistantName() {
    return this.assistantName;
  }

  public void setAssistantName(String assistantName) {
    this.assistantName = assistantName;
  }

  public AssistantChatRequest message(String message) {
    setMessage(message);
    return this;
  }

  public AssistantChatRequest context(String context) {
    setContext(context);
    return this;
  }

  public AssistantChatRequest assistantId(String assistantId) {
    setAssistantId(assistantId);
    return this;
  }

  public AssistantChatRequest assistantName(String assistantName) {
    setAssistantName(assistantName);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, context, assistantId, assistantName);
  }

  @Override
  public String toString() {
    return "{" +
      " message='" + getMessage() + "'" +
      ", context='" + getContext() + "'" +
      ", assistantId='" + getAssistantId() + "'" +
      ", assistantName='" + getAssistantName() + "'" +
      "}";
  }


}