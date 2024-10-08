package com.redhat.composer.api;

import java.util.List;
import java.util.Map;

import com.redhat.composer.model.request.RetrieverRequest;
import com.redhat.composer.model.response.SourceResponse;
import com.redhat.composer.services.RetrieveService;
import com.redhat.composer.util.MapperUtil;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

/**
 * Api For Testing Store Retrievers
 */
@Path("/retriver")
@Authenticated
public class VectorRetriverAPI {

  @Inject
  RetrieveService retrieveService;

  @POST
  @Path("/sources")
  public List<SourceResponse> retrieveSources(RetrieverRequest request, @QueryParam("message") String message) {
      return retrieveService.retrieveContent(request, message).stream().map(MapperUtil::toSourceResponse).toList();
  }

  @POST
  @Path("/sources/metadata")
  public List<Map<String,Object>> retrieveSourceMetadata(RetrieverRequest request, @QueryParam("message") String message) {
    return retrieveService.retrieveContent(request, message)
        .stream()
        .map(content -> content.textSegment().metadata().toMap()) // Accessing metadata inside textSegment
        .toList();
  }




}
