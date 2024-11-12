package com.redhat.composer.config.llm.aiservices;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;
import io.smallrye.mutiny.Multi;

/**
 * Mistral7BAiService.
 */
public interface HealthCareService extends BaseAiService {

  static final String systemMessage = """
You are a helpful, respectful and honest assistant answering questions about healthcare.
        """;

  static final String userMessage = """
<context>
{context}
</context>
<|eot_id|>
<|start_header_id|>user<|end_header_id|>
Question: {input}
<|eot_id|>
<|start_header_id|>assistant<|end_header_id|>
        """;

  /**
   * Returns TokenStream given input.
   * @param context Context information such as chat history and source information
   */
  @SystemMessage(systemMessage)
  @UserMessage(userMessage)
  TokenStream chatToken(String context, String input);


  /**
   * Returns a Multi of String given input.
   */
  @SystemMessage(systemMessage)
  @UserMessage(userMessage)
  Multi<String> chatStream(String context, String input);
  
} 