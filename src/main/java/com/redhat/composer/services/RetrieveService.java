package com.redhat.composer.services;

import java.util.List;

import com.redhat.composer.config.retriever.contentRetriever.BaseContentRetrieverClient;
import com.redhat.composer.config.retriever.contentRetriever.ContentRetrieverClientFactory;
import com.redhat.composer.model.enums.ContentRetrieverType;
import com.redhat.composer.model.request.RetrieverRequest;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.query.Query;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RetrieveService {

  @Inject
  ContentRetrieverClientFactory contentRetrieverClientFactory;

  public ContentRetriever getContentRetriever(RetrieverRequest request) {
    ContentRetrieverType contentRetrieverType = ContentRetrieverType.fromString(request.getBaseRetrieverRequest().getContentRetrieverType());
    BaseContentRetrieverClient client = contentRetrieverClientFactory.getContentRetrieverClient(contentRetrieverType); //TODO: Fix this
    return client.getContentRetriever(request);

  }

  public List<Content> retrieveContent(RetrieverRequest request, String message) {
    ContentRetriever contentRetriever = getContentRetriever(request);
    Query query = Query.from(message);
    return contentRetriever.retrieve(query);
  }


}
