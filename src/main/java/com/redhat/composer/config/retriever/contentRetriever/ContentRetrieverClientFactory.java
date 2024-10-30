package com.redhat.composer.config.retriever.contentRetriever;

import com.redhat.composer.model.enums.ContentRetrieverType;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ContentRetrieverClientFactory {

  @Inject
  WeaviateContentRetrieverClient weaviateEmbeddingStoreClient;
  
  @Inject
  Neo4jContentRetrieverClient neo4jContentRetrieverClient;
  
  final static ContentRetrieverType DEFAULT_CONTENT_RETRIEVER = ContentRetrieverType.WEAVIATE;

  public BaseContentRetrieverClient getContentRetrieverClient(ContentRetrieverType contentRetrieverType) {
    if(contentRetrieverType == null) {
      contentRetrieverType = DEFAULT_CONTENT_RETRIEVER;
    }
    
    switch (contentRetrieverType) {
      case ContentRetrieverType.WEAVIATE:
        return weaviateEmbeddingStoreClient;
      case ContentRetrieverType.NEO4J:
        return neo4jContentRetrieverClient;
      default:
        throw new RuntimeException("Content Retriever type not found: " + contentRetrieverType);
    }
  }
  
}
