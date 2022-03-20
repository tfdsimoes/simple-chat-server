package com.smart.simplechat.usecase.room.service.impl;

import java.util.List;

import com.smart.simplechat.common.exception.ElementAlreadyExist;
import com.smart.simplechat.usecase.room.model.Room;
import com.smart.simplechat.usecase.room.repository.RoomRepository;
import com.smart.simplechat.usecase.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;

  @Override
  public void createRoom(Room room) {
    log.info("[RoomService] Create new room: {}", room);

    if (roomRepository.findByName(room.getName()).isPresent()) {
      throw new ElementAlreadyExist("ROOM", room.getName());
    }

    var roomWithTopic = room.toBuilder().topicId("todo").build();

    roomRepository.createRoom(roomWithTopic);
  }

  @Override
  public List<Room> getAllRooms() {
    log.info("[RoomService] Get all rooms");
    return roomRepository.getAllRooms();
  }
}
