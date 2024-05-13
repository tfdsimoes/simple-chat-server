package com.smart.simplechat.usecase.room.repository.impl.mongo.crud;

import java.util.Optional;

import com.smart.simplechat.usecase.room.repository.impl.mongo.document.RoomDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomCrud extends MongoRepository<RoomDocument, String> {

  Optional<RoomDocument> findByName(String name);
}
