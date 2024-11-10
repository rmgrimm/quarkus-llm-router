package com.redhat.composer.config.retriever.embeddingModel;

import dev.langchain4j.model.embedding.EmbeddingModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmbeddingModelFactory {

  @Inject
  NomicLocalEmbeddingModelClient nomicEmbeddingClient;
  public static final String NOMIC_EMBEDDING = "nomic";

  public static final String DEFAULT_EMBEDDING = NOMIC_EMBEDDING;

  public EmbeddingModel getEmbeddingModel(String embeddingType) {
    if(embeddingType == null) {
      embeddingType = DEFAULT_EMBEDDING;
    }
    switch (embeddingType) {
      case NOMIC_EMBEDDING:
        return nomicEmbeddingClient;
      default:
        throw new RuntimeException("Embedding type not found: " + embeddingType);
    }
  }
  
}
