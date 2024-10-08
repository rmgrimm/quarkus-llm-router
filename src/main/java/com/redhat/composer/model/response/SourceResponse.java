package com.redhat.composer.model.response;
import java.util.Objects;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class SourceResponse {

  private String content;
  private Map<String, Object> metadata;

  public SourceResponse() {
  }

  public SourceResponse(String content, Map<String,Object> metadata) {
    this.content = content;
    this.metadata = metadata;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Map<String,Object> getMetadata() {
    return this.metadata;
  }

  public void setMetadata(Map<String,Object> metadata) {
    this.metadata = metadata;
  }

  public SourceResponse content(String content) {
    setContent(content);
    return this;
  }

  public SourceResponse metadata(Map<String,Object> metadata) {
    setMetadata(metadata);
    return this;
  }

  @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, metadata);
  }

  @Override
  public String toString() {
    return "{" +
      " content='" + getContent() + "'" +
      ", metadata='" + getMetadata() + "'" +
      "}";
  }
}
