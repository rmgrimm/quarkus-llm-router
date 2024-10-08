package com.redhat.composer.services;

import java.util.List;
import java.util.stream.Stream;

import com.redhat.composer.model.mongo.AssistantEntity;
import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;
import com.redhat.composer.model.request.AssistantCreationRequest;
import com.redhat.composer.model.request.LLMRequest;
import com.redhat.composer.model.request.RetrieverRequest;
import com.redhat.composer.model.response.AssistantResponse;

import jakarta.enterprise.context.ApplicationScoped;

// TODO: Set up MapStruct service or something
// https://mapstruct.org/

@ApplicationScoped
public class AssistantInfoService {

  public AssistantEntity createAssistant(AssistantCreationRequest request) {
    
    LLMConnectionEntity llm = (LLMConnectionEntity) LLMConnectionEntity.findByIdOptional(request.getLlmConnectionId()).orElseThrow(() -> new IllegalArgumentException("LLM Connection not found"));
    RetrieverConnectionEntity retriever = (RetrieverConnectionEntity) RetrieverConnectionEntity.findByIdOptional(request.getRetrieverConnectionId()).orElseThrow(() -> new IllegalArgumentException("Retriever Connection not found"));
    
    AssistantEntity assistant = new AssistantEntity();
    assistant.setName(request.getName());
    assistant.setDisplayName(request.getDisplayName());
    assistant.setDescription(request.getDescription());
    assistant.setLlmConnectionId(llm.id);
    assistant.setRetrieverConnectionId(retriever.id);
    assistant.persist();
    return assistant;
  }

  public List<AssistantResponse> getAssistant() {
    Stream<AssistantEntity> stream = AssistantEntity.streamAll();
    return stream.map(entity -> {
      AssistantResponse response = new AssistantResponse();
      response.id = entity.id;
      response.setName(entity.getName()); 
      response.setDisplayName(entity.getDisplayName());
      response.setDescription(entity.getDescription());
      response.setLlmConnection(LLMConnectionEntity.findById(entity.getLlmConnectionId()));
      response.setRetrieverConnection(RetrieverConnectionEntity.findById(entity.getRetrieverConnectionId()));
      return response;
    }
    ).toList();
  }

  public RetrieverConnectionEntity creaRetrieverConnectionEntity(RetrieverRequest request) {
    RetrieverConnectionEntity entity = new RetrieverConnectionEntity();
    entity.setContentRetrieverType(request.getContentRetrieverType());
    entity.setEmbeddingType(request.getEmbeddingType());
    entity.setHost(request.getHost());
    entity.setApiKey(request.getApiKey());
    entity.setIndex(request.getIndex());
    entity.setMetadataFields(request.getMetadataFields());
    entity.setTextKey(request.getTextKey());
    entity.setScheme(request.getScheme());
    entity.persist();
    return entity;
  }

  public List<RetrieverConnectionEntity> getRetrieverConnections() {
    return RetrieverConnectionEntity.listAll();
  }

  public LLMConnectionEntity createLLMConnection(LLMRequest request) {
    LLMConnectionEntity entity = new LLMConnectionEntity();
    entity.setUrl(request.getUrl());
    entity.setApiKey(request.getApiKey());
    entity.setModelName(request.getModelName());
    entity.persist();
    return entity;
  }

  public List<LLMConnectionEntity> getLLMConnections() {
    return LLMConnectionEntity.listAll();
  }
  
}