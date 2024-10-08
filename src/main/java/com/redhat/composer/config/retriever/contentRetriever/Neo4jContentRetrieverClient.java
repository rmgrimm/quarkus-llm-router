package com.redhat.composer.config.retriever.contentRetriever;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

import com.redhat.composer.config.llm.models.synchronous.SynchronousBaseModel;
import com.redhat.composer.config.llm.models.synchronous.SynchronousModelFactory;
import com.redhat.composer.config.retriever.contentRetriever.custom.WeaviateEmbeddingStoreCustom;
import com.redhat.composer.model.request.LLMRequest;
import com.redhat.composer.model.request.RetrieverRequest;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.rag.content.retriever.neo4j.Neo4jContentRetriever;
import dev.langchain4j.store.graph.neo4j.Neo4jGraph;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class Neo4jContentRetrieverClient extends BaseContentRetrieverClient {

  @ConfigProperty( name = "neo4j.default.url")
  private String neo4jUrl;
  @ConfigProperty( name = "neo4j.default.username")
  private String neo4jUser;
  @ConfigProperty( name = "neo4j.default.password")
  private String neo4jPassword;

  @Inject
  SynchronousModelFactory synchronousModelFactory;

  public ContentRetriever getContentRetriever(RetrieverRequest request) {
    Driver driver = GraphDatabase.driver(neo4jUrl, AuthTokens.basic(neo4jUser, neo4jPassword));

    Neo4jGraph graph = Neo4jGraph.builder().driver(driver).build();

    // TODO: This should be pulled from the request ... I think (need to think about this more)
    SynchronousBaseModel baseModel =  synchronousModelFactory.getModel(SynchronousModelFactory.DEFAULT_MODEL);
    ChatLanguageModel chatLanguageModel = baseModel.getChatModel(new LLMRequest());


    Neo4jContentRetriever retriever = Neo4jContentRetriever.builder()
            .graph(graph)
            .chatLanguageModel(chatLanguageModel)
            .build();
      
    return retriever;
  }

}
