package com.smart.simplechat.common.repo.user.impl.mongo.document;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("user")
public class UserDocument {

  @Id
  String id;

  @NonNull
  String name;

  @NonNull
  String password;
}
