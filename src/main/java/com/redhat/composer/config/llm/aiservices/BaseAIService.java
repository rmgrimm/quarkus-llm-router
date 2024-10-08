package com.redhat.composer.config.llm.aiservices;

import dev.langchain4j.service.TokenStream;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Multi;

/**
 * Mistral7BAiService
 */
public interface BaseAIService {

  // TokenStream should be used when possible
  TokenStream chatToken(String context, String input);

  Multi<String> chatStream(String context, String input);
  
} 