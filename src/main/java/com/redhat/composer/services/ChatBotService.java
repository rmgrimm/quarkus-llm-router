package com.redhat.composer.services;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import com.redhat.composer.config.llm.aiservices.AIServicesFactory;
import com.redhat.composer.config.llm.aiservices.BaseAIService;
import com.redhat.composer.config.llm.models.streaming.StreamingModelFactory;
import com.redhat.composer.model.mongo.AssistantEntity;
import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;
import com.redhat.composer.model.request.AssistantChatRequest;
import com.redhat.composer.model.request.ChatBotRequest;
import com.redhat.composer.repositories.AssistantRepository;
import com.redhat.composer.util.MapperUtil;

import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.rag.content.Content;
import dev.langchain4j.service.AiServices;
import io.opentelemetry.api.trace.Span;
import io.quarkus.runtime.util.StringUtil;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ChatBotService {

  Logger log = Logger.getLogger(ChatBotService.class);

  @Inject
  StreamingModelFactory modelTemplateFactory;

  @Inject
  AIServicesFactory aiServicesFactory;

  @Inject
  RetrieveService ragService;

  @Inject
  AssistantRepository assistantRepository;


  public Multi<String> chat(AssistantChatRequest request) {
    
    AssistantEntity assistant;
    if(!StringUtil.isNullOrEmpty(request.getAssistantName())) {
          assistant = assistantRepository.findByName(request.getAssistantName());
    } else if(!StringUtil.isNullOrEmpty(request.getAssistantId())) {
      assistant = AssistantEntity.findById(request.getAssistantId());
    } else {
      throw new RuntimeException("Assistant Name or ID Required");
    }
    LLMConnectionEntity llmConnection = LLMConnectionEntity.findById(assistant.getLlmConnectionId());
    RetrieverConnectionEntity retrieverConnection = RetrieverConnectionEntity.findById(assistant.getRetrieverConnectionId());

    ChatBotRequest chatBotRequest = new ChatBotRequest();
    chatBotRequest.setMessage(request.getMessage());
    chatBotRequest.setContext(request.getContext());
    chatBotRequest.setRetrieverRequest(MapperUtil.toRetrieverRequest(retrieverConnection));
    chatBotRequest.setModelRequest(MapperUtil.toLLMRequest(llmConnection));

    return chat(chatBotRequest);
  }

  public Multi<String> chat(ChatBotRequest request) {

    String traceId = Span.current().getSpanContext().getTraceId();
    log.info("ChatBotService.chat for message: " + request.getMessage() + " traceId: " + traceId);
    
    validateRequest(request);

    StreamingChatLanguageModel llm = modelTemplateFactory.getModel(request.getModelRequest().getModelType())
      .getChatModel(request.getModelRequest());
    
      // TODO: Make this configurable
    Class<? extends BaseAIService> aiServiceClass = aiServicesFactory.getAiService(AIServicesFactory.MISTRAL7B_AI_SERVICE);

    BaseAIService aiService = AiServices.builder(aiServiceClass)
        .streamingChatLanguageModel(llm)
        .contentRetriever(ragService.getContentRetriever(request.getRetrieverRequest()))
      .build();

    try {
      Multi<String> multi = Multi.createFrom().emitter(em -> {
        List<Content> contentSources = new ArrayList<Content>();
        aiService.chatToken(request.getContext(), request.getMessage())
        .onNext(em::emit)
        .onRetrieved(sources -> contentSources.addAll(sources))
        .onError(em::fail)
        .onComplete(response -> {
          em.emit("\n\nSources used to generate this content:\n");
          contentSources.forEach(content -> {
          em.emit(content.textSegment().metadata().getString("source") + "\n");
          log.info("Chat complete, traceId: " + traceId);
          });
          em.complete();
        })
        .start();
        });
      return multi;
    } catch (Exception e) {
        log.error("Error in ChatBotService.chat", e);
        return Multi.createFrom().failure(e);
      }
  }

  // TODO: Support non-streaming chat?

  private void validateRequest(ChatBotRequest request) {
    if(request.getMessage() == null) {
      throw new RuntimeException("Request Message Required");
    }
  }
  

  
  
}
