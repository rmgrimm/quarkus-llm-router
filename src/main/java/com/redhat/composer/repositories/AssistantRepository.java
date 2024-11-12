package com.redhat.composer.repositories;

import com.redhat.composer.model.mongo.AssistantEntity;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Assistant Repository.
 */
@ApplicationScoped
public class AssistantRepository implements PanacheMongoRepository<AssistantEntity> {
   
  /**
   * Find an Assistant by name.
   * @param name the name of the Assistant
   * @return the AssistantEntity
   */
  public AssistantEntity findByName(String name) {
    return find("name", name).firstResult();
  }
  
}
