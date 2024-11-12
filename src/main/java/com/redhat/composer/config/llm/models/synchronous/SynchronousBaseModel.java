package com.redhat.composer.config.llm.models.synchronous;

import org.testcontainers.shaded.org.apache.commons.lang3.NotImplementedException;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.ChatLanguageModel;

/**
 * Synchronous Base Model.
 */
public class SynchronousBaseModel {
  
  /**
   * Get Chat Model.
   * @param request the LLMRequest
   * @return the ChatLanguageModel
   */
  public ChatLanguageModel getChatModel(LLMRequest request) {  
    throw new NotImplementedException("Not implemented");
  }
}
