package com.redhat.composer.repositories;

import com.redhat.composer.model.mongo.AssistantEntity;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssistantRepository implements PanacheMongoRepository<AssistantEntity> {
    
  public AssistantEntity findByName(String name) {
        return find("name", name).firstResult();
    }
  
}
