package com.redhat.composer.config.llm.models.synchronous;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel.OpenAiChatModelBuilder;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * OpenAI Model.
 */
@ApplicationScoped
public class OpenAiModel extends SynchronousBaseModel {

  @ConfigProperty( name = "openai.default.url")
  private String mistralDefaultUrl;

  @ConfigProperty(name = "openai.default.apiKey")
  private String mistralDefaultApiKey;

  @ConfigProperty(name = "openai.default.modelName")
  private String mistralDefaultModelName;

  @ConfigProperty(name = "openai.default.temp")
  private double openaiDefaultTemp;

 
  public ChatLanguageModel getChatModel(LLMRequest request) {
    OpenAiChatModelBuilder builder = OpenAiChatModel.builder();
    builder.baseUrl(request.getUrl() == null ? mistralDefaultUrl : request.getUrl());
    builder.apiKey(request.getApiKey() == null ? mistralDefaultApiKey : request.getApiKey());

    builder.modelName(request.getModelName() == null ? mistralDefaultModelName : request.getModelName());

    // TODO: Add all the following to the request
    builder.temperature(openaiDefaultTemp);
      
      // Model names can be derived from MistralAiChatModelName enum
      // if (modelName != null) {
      //   builder.modelName(modelName);
      // }
      // if (maxTokens != null) {
      //   builder.maxTokens(maxTokens);
      // }
      // if (safePrompt != null) {
      //   builder.safePrompt(safePrompt);
      // }
    
    return builder.build();
  }

}
