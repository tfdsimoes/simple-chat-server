package com.smart.simplechat.usecase.room.service.impl;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.common.exception.ElementAlreadyExistException;
import com.smart.simplechat.usecase.room.model.Room;
import com.smart.simplechat.usecase.room.repository.RoomRepository;
import com.smart.simplechat.usecase.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;

  private final KafkaAdmin kafkaAdmin;

  @Override
  public void createRoom(Room room) {
    log.info("[RoomService] Create new room: {}", room);

    if (roomRepository.findByName(room.getName()).isPresent()) {
      throw new ElementAlreadyExistException("ROOM", room.getName());
    }

    kafkaAdmin.createOrModifyTopics(TopicBuilder.name(room.getName()).partitions(1).replicas(1).build());
    var roomWithTopic = room.toBuilder().topicId(room.getName()).build();
    roomRepository.createRoom(roomWithTopic);
  }

  @Override
  public List<Room> getAllRooms() {
    log.info("[RoomService] Get all rooms");
    return roomRepository.getAllRooms();
  }

  @Override
  public Optional<Room> findById(String id) {
    log.info("[RoomService] Find by id: {}", id);
    return roomRepository.findById(id);
  }
}
