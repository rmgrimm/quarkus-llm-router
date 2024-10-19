package com.redhat.composer.config.retriever.contentRetriever;

import com.redhat.composer.config.retriever.embeddingModel.EmbeddingModelFactory;
import com.redhat.composer.model.request.RetrieverRequest;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import jakarta.inject.Inject;

public class BaseContentRetrieverClient {

  @Inject
  EmbeddingModelFactory embeddingModelFactory;
  

  public ContentRetriever getContentRetriever(RetrieverRequest request){
    throw new UnsupportedOperationException("Unimplemented method 'getContentRetriever'");
  }

  protected EmbeddingModel getEmbeddingModel(String embeddingType){
    return embeddingModelFactory.getEmbeddingModel(embeddingType);
  }

}
