package com.smart.simplechat.usecase.room.repository.impl.mongo;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.usecase.room.model.Room;
import com.smart.simplechat.usecase.room.repository.RoomRepository;
import com.smart.simplechat.usecase.room.repository.impl.mongo.crud.RoomCrud;
import com.smart.simplechat.usecase.room.repository.impl.mongo.mapper.RoomDocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RoomRepositoryImpl implements RoomRepository {

  private final RoomCrud roomCrud;

  private final RoomDocumentMapper roomDocumentMapper;

  @Override
  public void createRoom(Room room) {
    log.info("[RoomRepository] Create room: {}", room);
    roomCrud.save(roomDocumentMapper.toDocument(room));
  }

  @Override
  public List<Room> getAllRooms() {
    log.info("[RoomRepository] Get all rooms");
    var roomDocuments = roomCrud.findAll();
    return roomDocumentMapper.toModels(roomDocuments);
  }

  @Override
  public Optional<Room> findByName(String name) {
    return Optional.empty();
  }
}
