package com.smart.simplechat.usecase.room.rest.controller;

import java.util.List;

import com.smart.simplechat.rest.controller.api.RoomsApi;
import com.smart.simplechat.rest.controller.model.RoomAnswerDTO;
import com.smart.simplechat.rest.controller.model.RoomRequestDTO;
import com.smart.simplechat.usecase.room.mapper.RoomMapper;
import com.smart.simplechat.usecase.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoomController implements RoomsApi {

  private final RoomService roomService;

  private final RoomMapper roomMapper;

  @Override
  public ResponseEntity<Void> createRoom(RoomRequestDTO roomDTO) {
    log.info("[RoomController] Create room: {}", roomDTO);
    roomService.createRoom(roomMapper.toModel(roomDTO));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<RoomAnswerDTO>> getAllRooms() {
    log.info("[RoomController] Get all rooms");
    var rooms = roomService.getAllRooms();
    return ResponseEntity.ok(roomMapper.toDTOs(rooms));
  }
}
