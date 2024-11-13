package com.redhat.composer.api.mapper;

import com.redhat.composer.util.mappers.QuarkusMapperConfig;
import org.mapstruct.Mapper;

/**
 * Map requests from the API contract to internal model.
 */
@Mapper(
    config = QuarkusMapperConfig.class,
    uses = {
        BaseRetrieverRequestMapper.class
    }
)
public interface ChatBotRequestMapper {
  /**
   * Map a request.
   *
   * @param request the API contract's request
   * @return the internal request model
   */
  com.redhat.composer.model.request.ChatBotRequest mapFrom(com.redhat.composer.api.model.ChatBotRequest request);
}
