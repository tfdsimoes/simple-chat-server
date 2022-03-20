package com.smart.simplechat.usecase.message.controller.rest;

import java.util.List;

import com.smart.simplechat.rest.controller.api.RoomMessagesApi;
import com.smart.simplechat.rest.controller.model.MessageAnswerDTO;
import com.smart.simplechat.rest.controller.model.MessageRequestDTO;
import com.smart.simplechat.usecase.message.mapper.MessageMapper;
import com.smart.simplechat.usecase.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageRoomController implements RoomMessagesApi {

  private final MessageService messageService;

  private final MessageMapper messageMapper;

  @Override
  public ResponseEntity<List<MessageAnswerDTO>> getAllMessagesRoom(String id) {
    log.info("[MessageRoomController] Get all messages of {}", id);
    messageService.getAllMessages(id);
    return RoomMessagesApi.super.getAllMessagesRoom(id);
  }

  @Override
  public ResponseEntity<List<MessageAnswerDTO>> getRealtimeMessages(String id) {
    return RoomMessagesApi.super.getRealtimeMessages(id);
  }

  @Override
  public ResponseEntity<Void> sendMessageRoom(String id, MessageRequestDTO messageRequestDTO) {
    var username = SecurityContextHolder.getContext().getAuthentication().getName();
    log.info("[MessageRoomController] User {} sent message: {}", username, messageRequestDTO);

    messageService.sentRoomMessage(id, messageMapper.toModel(messageRequestDTO, username, LocalDateTime.now().toString()));
    return RoomMessagesApi.super.sendMessageRoom(id, messageRequestDTO);
  }
}
