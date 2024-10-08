package com.redhat.composer.config.llm.aiservices;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AIServicesFactory {

  public static final String MISTRAL7B_AI_SERVICE = "mistral7b";

  public static final String MISTRAL7B_QUARKUS_AI_SERVICE = "mistral7b_quarkus";

  public static final String HEALTHCARE_SERVICE = "healthcare";

  public Class<? extends BaseAIService> getAiService(String aiServiceType) {
    switch (aiServiceType) {
      case MISTRAL7B_AI_SERVICE:
        return Mistral7BAiService.class;
      case HEALTHCARE_SERVICE:
        return HealthCareService.class;
      default:
        throw new RuntimeException("AI service type not found: " + aiServiceType);
    }
  }
  
}
