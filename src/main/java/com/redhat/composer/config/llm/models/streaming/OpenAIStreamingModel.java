package com.redhat.composer.config.llm.models.streaming;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.composer.model.request.LLMRequest;

import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel.OpenAiStreamingChatModelBuilder;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OpenAIStreamingModel extends StreamingBaseModel {


  @ConfigProperty( name = "openai.default.url")
  private String mistralDefaultUrl;

  @ConfigProperty(name = "openai.default.apiKey")
  private String mistralDefaultApiKey;

  @ConfigProperty(name = "openai.default.modelName")
  private String mistralDefaultModelName;

  @ConfigProperty(name = "openai.default.temp")
  private double openaiDefaultTemp;

 
  public StreamingChatLanguageModel getChatModel(LLMRequest request) {
    OpenAiStreamingChatModelBuilder builder = OpenAiStreamingChatModel.builder();
      builder.baseUrl(request.getUrl() == null ? mistralDefaultUrl : request.getUrl());
      builder.apiKey(request.getApiKey() == null ? mistralDefaultApiKey : request.getApiKey());

      builder.modelName(request.getModelName() == null ? mistralDefaultModelName : request.getModelName());

      // TODO: Add all the following to the request
      builder.temperature(openaiDefaultTemp);
      
      // TODO: Fill all this out
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
