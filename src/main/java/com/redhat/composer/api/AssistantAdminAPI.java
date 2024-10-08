package com.redhat.composer.api;

import java.util.List;

import com.redhat.composer.model.mongo.AssistantEntity;
import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;
import com.redhat.composer.model.request.AssistantCreationRequest;
import com.redhat.composer.model.request.LLMRequest;
import com.redhat.composer.model.request.RetrieverRequest;
import com.redhat.composer.model.response.AssistantResponse;
import com.redhat.composer.services.AssistantInfoService;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/admin/assistant")
@Authenticated
public class AssistantAdminAPI {

  @Inject
  AssistantInfoService assistantService;

  @POST
  @Path("llm")
  public LLMConnectionEntity createLLM(LLMRequest request) {
    return assistantService.createLLMConnection(request);
  }

  @GET
  @Path("llm")
  public List<LLMConnectionEntity> getLLMs() {
    return assistantService.getLLMConnections();
  }

  @POST
  @Path("retrieverConnection")
  public RetrieverConnectionEntity createRetrieverConnection(RetrieverRequest request) {
    return assistantService.creaRetrieverConnectionEntity(request);
  }

  @GET
  @Path("retrieverConnection")
  public List<RetrieverConnectionEntity> getRetrieverConnection() {
    return assistantService.getRetrieverConnections();
  }

  @POST
  public AssistantEntity createAssistant(AssistantCreationRequest request) {
    return assistantService.createAssistant(request);
  }

  @GET
  public List<AssistantResponse> getAssistant() {
    return assistantService.getAssistant();
  }
  
}
