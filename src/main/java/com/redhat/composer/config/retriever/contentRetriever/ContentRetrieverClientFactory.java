package com.redhat.composer.config.retriever.contentRetriever;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ContentRetrieverClientFactory {

  @Inject
  WeaviateContentRetrieverClient weaviateEmbeddingStoreClient;
  public static final String WEAVIATE_CONTENT_RETRIEVER = "weaviate";

  @Inject
  Neo4jContentRetrieverClient neo4jContentRetrieverClient;
  public static final String NEO4J_CONTENT_RETRIEVER = "neo4j";
  
  final static String DEFAULT_CONTENT_RETRIEVER = WEAVIATE_CONTENT_RETRIEVER;

  public BaseContentRetrieverClient getContentRetrieverClient(String contentRetrieverType) {
    if(contentRetrieverType == null) {
      contentRetrieverType = DEFAULT_CONTENT_RETRIEVER;
    }
    
    switch (contentRetrieverType) {
      case WEAVIATE_CONTENT_RETRIEVER:
        return weaviateEmbeddingStoreClient;
      case NEO4J_CONTENT_RETRIEVER:
        return neo4jContentRetrieverClient;
      default:
        throw new RuntimeException("Embedding type not found: " + contentRetrieverType);
    }
  }
  
}
