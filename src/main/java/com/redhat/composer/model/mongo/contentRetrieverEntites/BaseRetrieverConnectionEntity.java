package com.redhat.composer.model.mongo.contentRetrieverEntites;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import com.redhat.composer.model.enums.ContentRetrieverType;

@BsonDiscriminator
public class BaseRetrieverConnectionEntity {

  ContentRetrieverType contentRetrieverType;


  public BaseRetrieverConnectionEntity() {
  }

  public BaseRetrieverConnectionEntity(ContentRetrieverType contentRetrieverType) {
    this.contentRetrieverType = contentRetrieverType;
  }

  public ContentRetrieverType getContentRetrieverType() {
    return this.contentRetrieverType;
  }

  public void setContentRetrieverType(ContentRetrieverType contentRetrieverType) {
    this.contentRetrieverType = contentRetrieverType;
  }

  public BaseRetrieverConnectionEntity contentRetrieverType(ContentRetrieverType contentRetrieverType) {
    setContentRetrieverType(contentRetrieverType);
    return this;
  }
  
}
