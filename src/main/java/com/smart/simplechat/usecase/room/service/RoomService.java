package com.smart.simplechat.usecase.room.service;

import java.util.List;

import com.smart.simplechat.usecase.room.model.Room;

public interface RoomService {

  void createRoom(Room room);

  List<Room> getAllRooms();
}
