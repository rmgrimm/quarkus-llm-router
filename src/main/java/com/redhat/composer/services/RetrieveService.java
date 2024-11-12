package com.redhat.composer.services;

import java.util.List;

import com.redhat.composer.config.retriever.contentretriever.BaseContentRetrieverClient;
import com.redhat.composer.config.retriever.contentretriever.ContentRetrieverClientFactory;
import com.redhat.composer.model.enums.ContentRetrieverType;
import com.redhat.composer.model.request.RetrieverRequest;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Service for retrieving content.
 */
@ApplicationScoped
public class RetrieveService {

  @Inject
  ContentRetrieverClientFactory contentRetrieverClientFactory;

  /**
   * Retrieves content from a given message.
   * @param request the request to retrieve content
   * @return the retrieved content
   */
  public ContentRetriever getContentRetriever(RetrieverRequest request) {
    ContentRetrieverType contentRetrieverType = ContentRetrieverType.fromString(
                          request.getBaseRetrieverRequest().getContentRetrieverType());
    BaseContentRetrieverClient client = contentRetrieverClientFactory
                          .getContentRetrieverClient(contentRetrieverType);
    return client.getContentRetriever(request);

  }

  /**
   * Retrieves content from a given message.
   * @param request the request to retrieve content
   * @param message the message to retrieve content from
   * @return the retrieved content
   */
  public List<Content> retrieveContent(RetrieverRequest request, String message) {
    ContentRetriever contentRetriever = getContentRetriever(request);
    Query query = Query.from(message);
    return contentRetriever.retrieve(query);
  }


}
