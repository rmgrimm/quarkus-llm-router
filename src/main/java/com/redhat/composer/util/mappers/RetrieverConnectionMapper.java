package com.redhat.composer.util.mappers;

import org.mapstruct.Mapper;

import com.redhat.composer.model.enums.ContentRetrieverType;
import com.redhat.composer.model.mongo.contentRetrieverEntites.Neo4JEntity;
import com.redhat.composer.model.mongo.contentRetrieverEntites.WeaviateConnectionEntity;
import com.redhat.composer.model.request.retriever.Neo4JRequest;
import com.redhat.composer.model.request.retriever.WeaviateRequest;

/**
 * RetrieverConnectionMapper interface.
 */
@Mapper(config = QuarkusMapperConfig.class)
public interface RetrieverConnectionMapper {

  /**
   * Maps a WeaviateConnectionEntity to a WeaviateRequest.

   * @param request the WeaviateConnectionEntity to map
   * @return the WeaviateRequest
   */
  WeaviateConnectionEntity toEntity(WeaviateRequest request);

  /**
   * Maps a Neo4JEntity to a Neo4JRequest.

   * @param request the Neo4JEntity to map
   * @return the Neo4JRequest
   */
  Neo4JEntity toEntity(Neo4JRequest request);

  /**
   * Maps a WeaviateConnectionEntity to a WeaviateRequest.

   * @param entity the WeaviateConnectionEntity to map
   * @return the WeaviateRequest
   */
  WeaviateRequest toRequest(WeaviateConnectionEntity entity);

  /**
   * Maps a Neo4JEntity to a Neo4JRequest.

   * @param entity the Neo4JEntity to map
   * @return the Neo4JRequest
   */
  Neo4JRequest toRequest(Neo4JEntity entity);

  /**
   * Maps a ContentRetrieverType to a String.

   * @param contentRetrieverType the ContentRetrieverType to map
   * @return type value
   */
  default String toString(ContentRetrieverType contentRetrieverType) {
    return contentRetrieverType.getType();
  }

  default ContentRetrieverType toContentRetrieverType(String value) {
    return ContentRetrieverType.fromString(value);
  }
}
