package com.smart.simplechat.usecase.room.model;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Room {

  String id;

  String name;

  boolean directMessage;

  @Singular
  List<String> users;

  String topicId;
}
