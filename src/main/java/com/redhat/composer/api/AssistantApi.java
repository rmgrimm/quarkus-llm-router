package com.redhat.composer.api;

import org.jboss.logging.Logger;

import com.redhat.composer.model.request.AssistantChatRequest;
import com.redhat.composer.services.ChatBotService;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/assistant/chat")
@Authenticated
public class AssistantApi {

  Logger log = Logger.getLogger(AssistantApi.class);

  @Inject
  ChatBotService chatBotService;


  @POST
  @Path("streaming")
  @Consumes(MediaType.APPLICATION_JSON)
  public Multi<String> chat(AssistantChatRequest input) {
     return chatBotService.chat(input);
  }

}
