package com.redhat.composer.api.impl;

import com.redhat.composer.api.ChatBotApi;
import com.redhat.composer.api.mapper.ChatBotRequestMapper;
import com.redhat.composer.api.model.ChatBotRequestMultipart;
import com.redhat.composer.services.ChatBotService;
import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

/**
 * ChatBotAPI for Chatting using ChatBots.
 */
@Authenticated
public class ChatBotApiImpl implements ChatBotApi {

  @Inject
  ChatBotRequestMapper requestMapper;

  @Inject
  ChatBotService chatBotService;

  /**
   * Chat with a ChatBot.
   *
   * @param input ChatBotRequest infromation
   * @return Streamed response
   */
  public Multi<String> chat(ChatBotRequestMultipart input) {
    return Uni.createFrom().item(input)
        .map(ChatBotRequestMultipart::getChatBotRequest)
        .map(requestMapper::mapFrom)
        .onItem().transformToMulti(chatBotService::chat);
  }

}
