package com.redhat.composer.config.llm.models.streaming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StreamingModelFactory {

  @Inject
  OpenAIStreamingModel openAIModel;
  public static final String OPENAI_MODEL = "openai";

  // TODO: Make this configurable
  public static final String DEFAULT_MODEL = OPENAI_MODEL;

  public StreamingBaseModel getModel(String modelType) {
    if(modelType == null) {
      modelType = DEFAULT_MODEL;
    }
    
    switch (modelType) {
      case OPENAI_MODEL:
        return openAIModel;
      default:
        throw new RuntimeException("Model type not found: " + modelType);
    }
  }
  
}
