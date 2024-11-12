package com.redhat.composer.model.mongo.contentretrieverentites;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

import com.redhat.composer.model.enums.ContentRetrieverType;

/**
 * Base Retriever Connection Entity.
 */
@SuppressWarnings("all")
@BsonDiscriminator
public class BaseRetrieverConnectionEntity {

  ContentRetrieverType contentRetrieverType;

  /**
   * Constructor.
   */
  public BaseRetrieverConnectionEntity() {
  }

  /**
   * Constructor.
   * @param contentRetrieverType the ContentRetrieverType
   */
  public BaseRetrieverConnectionEntity(ContentRetrieverType contentRetrieverType) {
    this.contentRetrieverType = contentRetrieverType;
  }

  /**
   * Get the Content Retriever Type.
   * @return the ContentRetrieverType
   */
  public ContentRetrieverType getContentRetrieverType() {
    return this.contentRetrieverType;
  }

  public void setContentRetrieverType(ContentRetrieverType contentRetrieverType) {
    this.contentRetrieverType = contentRetrieverType;
  }

  /**
   * Set the Content Retriever Type.
   * @param contentRetrieverType the ContentRetrieverType
   * @return BaseRetrieverConnectionEntity
   */
  public BaseRetrieverConnectionEntity contentRetrieverType(ContentRetrieverType contentRetrieverType) {
    setContentRetrieverType(contentRetrieverType);
    return this;
  }
  
}
