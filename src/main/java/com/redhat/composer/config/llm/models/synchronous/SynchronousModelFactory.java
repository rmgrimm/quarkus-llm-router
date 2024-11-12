package com.redhat.composer.config.llm.models.synchronous;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Synchronous Model Factory.
 */
@ApplicationScoped
public class SynchronousModelFactory {

  @Inject
  OpenAiModel openAiModel;
  public static final String OPENAI_MODEL = "openai";
  

  public static final String DEFAULT_MODEL = OPENAI_MODEL;

  /**
   * Get the model.
   * @param modelType the model type
   * @return the model
   */
  public SynchronousBaseModel getModel(String modelType) {
    if (modelType == null) {
      modelType = DEFAULT_MODEL;
    }
    
    switch (modelType) {
      case OPENAI_MODEL:
        return openAiModel;
      default:
        throw new RuntimeException("Model type not found: " + modelType);
    }
  }
  
}
