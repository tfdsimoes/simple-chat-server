package com.smart.simplechat.usecase.room.repository;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.usecase.room.model.Room;

public interface RoomRepository {

  void createRoom(Room room);

  List<Room> getAllRooms();

  Optional<Room> findByName(String name);

  Optional<Room> findById(String id);
}
