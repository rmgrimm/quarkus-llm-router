package com.redhat.composer.config.llm.models.streaming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Streaming Model Factory.
 */
@ApplicationScoped
public class StreamingModelFactory {

  @Inject
  OpenAiStreamingModel openAiModel;
  public static final String OPENAI_MODEL = "openai";

  // TODO: Make this configurable
  public static final String DEFAULT_MODEL = OPENAI_MODEL;

  /**
   * Get the model.
   * @param modelType the model type
   * @return the model
   */
  public StreamingBaseModel getModel(String modelType) {
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
