package com.redhat.composer.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.redhat.composer.model.enums.ContentRetrieverType;
import com.redhat.composer.model.mongo.LLMConnectionEntity;
import com.redhat.composer.model.mongo.RetrieverConnectionEntity;
import com.redhat.composer.model.mongo.contentRetrieverEntites.BaseRetrieverConnectionEntity;
import com.redhat.composer.model.mongo.contentRetrieverEntites.Neo4JEntity;
import com.redhat.composer.model.mongo.contentRetrieverEntites.WeaviateConnectionEntity;
import com.redhat.composer.model.request.LLMRequest;
import com.redhat.composer.model.request.RetrieverRequest;
import com.redhat.composer.model.request.retriever.BaseRetrieverRequest;
import com.redhat.composer.model.request.retriever.Neo4JRequest;
import com.redhat.composer.model.request.retriever.WeaviateRequest;

import jakarta.enterprise.inject.Default;

@Default
@Mapper(config = QuarkusMapperConfig.class)
public interface MapperUtil {

  RetrieverConnectionMapper retrieverConnectionMapper = Mappers.getMapper(RetrieverConnectionMapper.class);

  @Mapping(target = "connectionEntity", source = "baseRetrieverRequest")
  RetrieverConnectionEntity toEntity(RetrieverRequest request);

  @Mapping(source = "connectionEntity", target = "baseRetrieverRequest")
  RetrieverRequest toRequest(RetrieverConnectionEntity entity);

  LLMConnectionEntity toEntity(LLMRequest request);

  LLMRequest toRequest(LLMConnectionEntity entity);

  default BaseRetrieverConnectionEntity mapToBaseEntity(BaseRetrieverRequest request) {

    if (request == null) {
      return null;
    }
    
    switch (ContentRetrieverType.fromString(request.getContentRetrieverType())) {
      case ContentRetrieverType.WEAVIATE:
        return retrieverConnectionMapper.toEntity((WeaviateRequest) request);
      case ContentRetrieverType.NEO4J:
        return retrieverConnectionMapper.toEntity((Neo4JRequest) request);
      default:
        return null;
    }
  }

  /**
   * Maps a BaseRetrieverConnectionEntity to a BaseRetrieverRequest.

   * @param entity the BaseRetrieverConnectionEntity to map
   * @return the BaseRetrieverRequest
   */
  default BaseRetrieverRequest mapToBaseRequest(BaseRetrieverConnectionEntity entity){
    
    if (entity == null || entity.getContentRetrieverType() == null) {
      return null;
    }

    switch (entity.getContentRetrieverType()) {
      case ContentRetrieverType.WEAVIATE:
        return retrieverConnectionMapper.toRequest((WeaviateConnectionEntity) entity);
      case ContentRetrieverType.NEO4J:
        return retrieverConnectionMapper.toRequest((Neo4JEntity) entity);
      default:
        return null;
    }
  }

  
}
