package com.smart.simplechat.common.repo.user.impl.mongo.crud;

import java.util.Optional;

import com.smart.simplechat.common.repo.user.impl.mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrud extends MongoRepository<UserDocument, String> {

  Optional<UserDocument> findByName(String name);

  Optional<UserDocument> findByNameAndPassword(String name, String password);
}
