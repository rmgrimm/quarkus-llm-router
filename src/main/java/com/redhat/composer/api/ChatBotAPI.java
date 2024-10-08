package com.redhat.composer.api;

import org.jboss.logging.Logger;

import com.redhat.composer.model.request.ChatBotRequest;
import com.redhat.composer.services.ChatBotService;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/chatbot/chat")
@Authenticated
public class ChatBotAPI {

  Logger log = Logger.getLogger(ChatBotAPI.class);

  @Inject
  ChatBotService chatBotService;


  @POST
  @Path("streaming")
  @Consumes(MediaType.APPLICATION_JSON)
  public Multi<String> chat(ChatBotRequest input) {
     return chatBotService.chat(input);
  }

}
