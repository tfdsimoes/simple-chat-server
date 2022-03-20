package com.smart.simplechat.usecase.message.service.impl;

import java.util.List;
import java.util.Optional;

import com.google.common.util.concurrent.ListenableFuture;
import com.smart.simplechat.common.exception.ElementNotFoundException;
import com.smart.simplechat.usecase.message.model.Message;
import com.smart.simplechat.usecase.message.service.MessageService;
import com.smart.simplechat.usecase.room.service.RoomService;
import javax.websocket.SendResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final RoomService roomService;

  private final KafkaTemplate<String, Message> messageProducerKafka;

  private final ConcurrentKafkaListenerContainerFactory<String, Message> messageConsumerKafka;

  @Override
  public void sentRoomMessage(String roomId, Message message) {
    log.info("[MessageService] Sent message to room {}: {}", roomId, message);
    var optionalRoom = roomService.findById(roomId);

    if(optionalRoom.isEmpty()){
      throw new ElementNotFoundException("ROOM", roomId);
    }

    var room = optionalRoom.get();
    messageProducerKafka.send(room.getName(), message);
    // TODO - not finish (error sending)
  }

  @Override
  public List<Message> getAllMessages(String roomId) {
    log.info("[MessageService] Get messages of room {}", roomId);
    var optionalRoom = roomService.findById(roomId);

    if(optionalRoom.isEmpty()){
      throw new ElementNotFoundException("ROOM", roomId);
    }

    // TODO - not finish (error to read)

    var room = optionalRoom.get();
    var messagesKafka = messageProducerKafka.receive(room.getName(), 1 ,0);

    log.info("{}", messagesKafka.value());
    return null;
  }
}
