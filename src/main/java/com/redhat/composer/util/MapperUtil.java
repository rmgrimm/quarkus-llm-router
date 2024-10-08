package com.redhat.composer.util;

import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;
import com.redhat.composer.model.request.LLMRequest;
import com.redhat.composer.model.request.RetrieverRequest;
import com.redhat.composer.model.response.SourceResponse;

import dev.langchain4j.rag.content.Content;

public class MapperUtil {

  public static SourceResponse toSourceResponse(Content content) {
    SourceResponse response = new SourceResponse();
    response.setContent(content.textSegment().text());
    response.setMetadata(content.textSegment().metadata().toMap());
    return response;
  }

  public static LLMRequest toLLMRequest(LLMConnectionEntity entity) {
    LLMRequest request = new LLMRequest();
      request.setUrl(entity.getUrl());
      request.setApiKey(entity.getApiKey());
      request.setModelName(entity.getModelName());
      request.setModelType(entity.getModelType());
      return request;
  }


  public static RetrieverRequest toRetrieverRequest(RetrieverConnectionEntity entity) {
    RetrieverRequest request = new RetrieverRequest();
    request.setContentRetrieverType(entity.getContentRetrieverType());
    request.setEmbeddingType(entity.getEmbeddingType());
    request.setHost(entity.getHost());
    request.setApiKey(entity.getApiKey());
    request.setIndex(entity.getIndex());
    request.setTextKey(entity.getTextKey());
    request.setScheme(entity.getScheme());
    request.setMetadataFields(entity.getMetadataFields());    
    return request;
  }

  
}
