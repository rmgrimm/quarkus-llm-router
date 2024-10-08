package com.redhat.composer.model.mongo;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class BaseEntity extends PanacheMongoEntity {

  
  @JsonDeserialize(using = StringDeserializer.class)
  public ObjectId id;
  
  
}
