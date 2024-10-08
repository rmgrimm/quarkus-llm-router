package com.redhat.composer.services;

import org.jboss.logging.Logger;

import com.redhat.composer.config.retriever.embeddingModel.EmbeddingModelFactory;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 *  This service is mostly for testing embeddings models and their outputs.
 */
@ApplicationScoped
public class EmbeddingService {

  private static final Logger logger = Logger.getLogger(EmbeddingService.class);

  @Inject
  EmbeddingModelFactory embeddingTemplateFactory;

  public Embedding embedding(String text, String embeddingType) {
    EmbeddingModel embedding = embeddingTemplateFactory.getEmbeddingModel(embeddingType);
    Response<Embedding> response = embedding.embed(text);
    return response.content();
  }
  
}
