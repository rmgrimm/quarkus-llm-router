package com.redhat.composer.config.llm.models.synchronous;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SynchronousModelFactory {

  @Inject
  OpenAIModel openAIModel;
  public static final String OPENAI_MODEL = "openai";
  

  public static final String DEFAULT_MODEL = OPENAI_MODEL;

  public SynchronousBaseModel getModel(String modelType) {
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
