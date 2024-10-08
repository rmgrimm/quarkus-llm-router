package com.redhat.composer.config.llm.aiservices;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;
import io.smallrye.mutiny.Multi;

/**
 * Mistral7BAiService
 */

public interface Mistral7BAiService extends BaseAIService {

  final static String systemMessage = """
You are a helpful, respectful and honest assistant answering questions about products from the company called Red Hat.
You will be given a question you need to answer about this product.
If a question is about a specific product you will be given the product name and version, and references to provide you with additional information.
You must answer the question basing yourself as much as possible on the given references if any.
Always answer as helpfully as possible, while being safe.
Your answers should not include any harmful, unethical, racist, sexist, toxic, dangerous, or illegal content.
Please ensure that your responses are socially unbiased and positive in nature.
If a question does not make any sense, or is not factually coherent, explain why instead of answering something not correct.
If you don't know the answer to a question, please don't share false information.
""";

  final static String userMessage ="""
<context>
{context}
</context>
<|eot_id|>
<|start_header_id|>user<|end_header_id|>
Question: {input}
<|eot_id|>
<|start_header_id|>assistant<|end_header_id|>
""";

    @SystemMessage(systemMessage)
    @UserMessage(userMessage)
    TokenStream chatToken(String context, String input);



    @SystemMessage(systemMessage)
    @UserMessage(userMessage)
    Multi<String> chatStream(String context, String input);
  
} 