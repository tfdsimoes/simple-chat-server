package com.smart.simplechat.usecase.room.service;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.usecase.room.model.Room;

public interface RoomService {

  void createRoom(Room room);

  List<Room> getAllRooms();

  Optional<Room> findById(String id);
}
