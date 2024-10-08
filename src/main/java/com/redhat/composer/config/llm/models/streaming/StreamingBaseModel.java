package com.redhat.composer.config.llm.models.streaming;

import org.testcontainers.shaded.org.apache.commons.lang3.NotImplementedException;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.StreamingChatLanguageModel;

public class StreamingBaseModel {
  
  public StreamingChatLanguageModel getChatModel(LLMRequest request) {  
      throw new NotImplementedException("Not implemented");
  }
}
