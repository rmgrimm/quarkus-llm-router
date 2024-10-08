package com.redhat.composer.config.llm.models.synchronous;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel.MistralAiChatModelBuilder;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MistralModel extends SynchronousBaseModel {


  @ConfigProperty( name = "mistral.default.url")
  private String mistralDefaultUrl;

  @ConfigProperty(name = "mistral.default.apiKey")
  private String mistralDefaultApiKey;

  @ConfigProperty(name = "mistral.default.modelName")
  private String mistralDefaultModelName;

  @ConfigProperty(name = "mistral.default.temp")
  private double mistralDefaultTemp;

 
  public ChatLanguageModel getChatModel(LLMRequest request) {
      MistralAiChatModelBuilder builder = MistralAiChatModel.builder();
      builder.baseUrl(request.getUrl() == null ? mistralDefaultUrl : request.getUrl());
      builder.apiKey(request.getApiKey() == null ? mistralDefaultApiKey : request.getApiKey());

      builder.modelName(request.getModelName() == null ? mistralDefaultModelName : request.getModelName());

      // TODO: Add all the following to the request
      builder.temperature(mistralDefaultTemp);
      
      // TODO: Add all the following to the request
      // if (maxTokens != null) {
      //   builder.maxTokens(maxTokens);
      // }
      // if (safePrompt != null) {
      //   builder.safePrompt(safePrompt);
      // }
    
    return builder.build();
  }

}
