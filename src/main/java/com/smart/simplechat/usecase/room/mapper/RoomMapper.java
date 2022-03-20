package com.smart.simplechat.usecase.room.mapper;

import java.util.List;

import com.smart.simplechat.common.mapper.CommonMapperConfig;
import com.smart.simplechat.rest.controller.model.RoomAnswerDTO;
import com.smart.simplechat.rest.controller.model.RoomRequestDTO;
import com.smart.simplechat.usecase.room.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class)
public interface RoomMapper {

  @Mapping(target = "topicId", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "directMessage", ignore = true)
  @Mapping(target = "users", ignore = true)
  @Mapping(target = "user", ignore = true)
  Room toModel(RoomRequestDTO dto);

  RoomAnswerDTO toDTO(Room room);

  List<RoomAnswerDTO> toDTOs(List<Room> rooms);
}
