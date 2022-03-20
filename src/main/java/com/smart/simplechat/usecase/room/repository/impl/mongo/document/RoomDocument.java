package com.smart.simplechat.usecase.room.repository.impl.mongo.document;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("room")
@Data
@Builder
public class RoomDocument {

  @Id
  private String id;

  @NonNull
  private String name;

  private boolean directMessage;

  @Singular
  private List<String> users;

  @NonNull
  private String topicId;
}
