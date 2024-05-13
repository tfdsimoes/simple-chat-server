package com.smart.simplechat.usecase.room.repository.impl.mongo.mapper;

import java.util.List;

import com.smart.simplechat.common.mapper.CommonMapperConfig;
import com.smart.simplechat.usecase.room.model.Room;
import com.smart.simplechat.usecase.room.repository.impl.mongo.document.RoomDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = CommonMapperConfig.class)
public interface RoomDocumentMapper {

  @Mapping(target = "user", ignore = true)
  Room toModel(RoomDocument roomDocument);

  @Mapping(target = "user", ignore = true)
  RoomDocument toDocument(Room room);

  List<Room> toModels(List<RoomDocument> roomDocuments);
}
