package com.redhat.composer.api.mapper;

import com.redhat.composer.util.mappers.QuarkusMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

/**
 * Map requests from the API contract to internal model.
 */
@Mapper(config = QuarkusMapperConfig.class)
public interface BaseRetrieverRequestMapper {
  /**
   * Map a request.
   *
   * @param request the API contract's request
   * @return the internal request model
   */
  @SubclassMapping(
      target = com.redhat.composer.model.request.retriever.WeaviateRequest.class,
      source = com.redhat.composer.api.model.WeaviateRequest.class
  )
  @SubclassMapping(
      target = com.redhat.composer.model.request.retriever.Neo4JRequest.class,
      source = com.redhat.composer.api.model.Neo4JRequest.class
  )
  com.redhat.composer.model.request.retriever.BaseRetrieverRequest mapFrom(com.redhat.composer.api.model.BaseRetrieverRequest request);
}
