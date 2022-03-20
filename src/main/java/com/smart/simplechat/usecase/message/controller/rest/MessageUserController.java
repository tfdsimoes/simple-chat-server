package com.smart.simplechat.usecase.message.controller.rest;

import java.util.List;

import com.smart.simplechat.rest.controller.api.UserMessagesApi;
import com.smart.simplechat.rest.controller.model.MessageAnswerDTO;
import com.smart.simplechat.rest.controller.model.MessageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageUserController implements UserMessagesApi {

  @Override
  public ResponseEntity<List<MessageAnswerDTO>> getDirectMessages(String id) {
    return UserMessagesApi.super.getDirectMessages(id);
  }

  @Override
  public ResponseEntity<List<MessageAnswerDTO>> getRealtimeDirectMessages(String id) {
    return UserMessagesApi.super.getRealtimeDirectMessages(id);
  }

  @Override
  public ResponseEntity<Void> sentDirectMessage(String id, MessageRequestDTO messageRequestDTO) {
    return UserMessagesApi.super.sentDirectMessage(id, messageRequestDTO);
  }
}
