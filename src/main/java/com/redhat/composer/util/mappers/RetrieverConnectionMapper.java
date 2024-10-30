package com.redhat.composer.util.mappers;

import org.mapstruct.Mapper;

import com.redhat.composer.model.enums.ContentRetrieverType;
import com.redhat.composer.model.mongo.contentRetrieverEntites.Neo4JEntity;
import com.redhat.composer.model.mongo.contentRetrieverEntites.WeaviateConnectionEntity;
import com.redhat.composer.model.request.retriever.Neo4JRequest;
import com.redhat.composer.model.request.retriever.WeaviateRequest;

@Mapper(config = QuarkusMapperConfig.class)
public interface RetrieverConnectionMapper {

  WeaviateConnectionEntity toEntity(WeaviateRequest request);

  Neo4JEntity toEntity(Neo4JRequest request);

  WeaviateRequest toRequest(WeaviateConnectionEntity entity);

  Neo4JRequest toRequest(Neo4JEntity entity);

  default String toString(ContentRetrieverType contentRetrieverType) {
    return contentRetrieverType.getType();
  }

  default ContentRetrieverType toContentRetrieverType(String value) {
    return ContentRetrieverType.fromString(value);
  }
}
