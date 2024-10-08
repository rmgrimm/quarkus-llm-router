package com.redhat.composer.config.retriever.contentRetriever;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.composer.config.retriever.contentRetriever.custom.WeaviateEmbeddingStoreCustom;
import com.redhat.composer.model.request.RetrieverRequest;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import jakarta.inject.Singleton;

@Singleton
public class WeaviateContentRetrieverClient extends BaseContentRetrieverClient {

  @ConfigProperty( name = "weaviate.default.scheme")
  private String weaviateScheme;

  @ConfigProperty( name = "weaviate.default.host")
  private String weaviateHost;

  @ConfigProperty(name = "weaviate.default.apiKey")
  private String weaviateApiKey;

  @ConfigProperty(name = "weaviate.default.index")
  private String weaviateIndex;

  @ConfigProperty(name = "weaviate.default.textKey")
  private String weaviateTextKey;

  public ContentRetriever getContentRetriever(RetrieverRequest request) {
    String scheme = request.getScheme() != null ? request.getScheme() : weaviateScheme;
    String host = request.getHost() != null ? request.getHost() : weaviateHost;
    String apiKey = request.getApiKey() != null ? request.getApiKey() : weaviateApiKey;
    String index = request.getIndex() != null ? request.getIndex() : weaviateIndex;
    String textKey = request.getTextKey() != null ? request.getTextKey() : weaviateTextKey;

    WeaviateEmbeddingStoreCustom store = WeaviateEmbeddingStoreCustom.builder()
        .scheme(scheme)
        .host(host)
        .apiKey(apiKey)
        .metadataParentKey("")
        .metadataKeys(request.getMetadataFields())
        .objectClass(index)
        .avoidDups(true)
        .textKey(textKey)
      .build();
      

    // Retrieve the embedding model
    EmbeddingModel embeddingModel = getEmbeddingModel(request.getEmbeddingType());



    // Create the content retriever
    ContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
      .embeddingStore(store)
      .embeddingModel(embeddingModel)
      .build();
      
    return contentRetriever;
  }

}
