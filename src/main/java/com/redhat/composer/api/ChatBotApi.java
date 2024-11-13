package com.redhat.composer.api;

import com.redhat.composer.api.model.ChatBotRequestMultipart;
import io.smallrye.mutiny.Multi;
import jakarta.validation.Valid;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * OpenAPI-generator doesn't properly support multipart right now, so
 * this is a manual interface until OpenAPI-generator has better multipart
 * support.
 */
@Path("/chatbot/chat")
public interface ChatBotApi {

  /**
   * Chat with a ChatBot.
   *
   * @param requestMultipart ChatBotRequest and uploaded fil
   * @return Streamed response
   */
  @POST
  @Path("/streaming")
  @Consumes({"multipart/form-data"})
  @Produces({"application/json"})
  Multi<String> chat(
      @Valid @BeanParam ChatBotRequestMultipart requestMultipart
  );

}
