package com.redhat.composer.config.llm.models.streaming;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiStreamingChatModel;
import dev.langchain4j.model.mistralai.MistralAiStreamingChatModel.MistralAiStreamingChatModelBuilder;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MistralStreamingModel extends StreamingBaseModel {


  @ConfigProperty( name = "mistral.default.url")
  private String mistralDefaultUrl;

  @ConfigProperty(name = "mistral.default.apiKey")
  private String mistralDefaultApiKey;

  @ConfigProperty(name = "openai.default.modelName")
  private String mistralDefaultModelName;

  @ConfigProperty(name = "mistral.default.temp")
  private double mistralDefaultTemp;

 
  @Override
  public StreamingChatLanguageModel getChatModel(LLMRequest request) {
      MistralAiStreamingChatModelBuilder builder = MistralAiStreamingChatModel.builder();
      builder.baseUrl(request.getUrl() == null ? mistralDefaultUrl : request.getUrl());
      builder.apiKey(request.getApiKey() == null ? mistralDefaultApiKey : request.getApiKey());

      builder.modelName(request.getModelName() == null ? mistralDefaultModelName : request.getModelName());

      // TODO: Add all the following to the request
      builder.temperature(mistralDefaultTemp);

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
