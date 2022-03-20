package com.smart.simplechat.usecase.message.service;

import java.util.List;

import com.smart.simplechat.usecase.message.model.Message;

public interface MessageService {
  void sentRoomMessage(String roomId, Message message);

  List<Message> getAllMessages(String roomId);
}
