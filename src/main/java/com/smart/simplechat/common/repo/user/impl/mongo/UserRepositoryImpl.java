package com.smart.simplechat.common.repo.user.impl.mongo;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.common.model.User;
import com.smart.simplechat.common.repo.user.UserRepository;
import com.smart.simplechat.common.repo.user.impl.mongo.crud.UserCrud;
import com.smart.simplechat.common.repo.user.impl.mongo.mapper.UserDocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserCrud crud;

  private final UserDocumentMapper mapper;

  private final PasswordEncoder encoder;

  @Override
  public void createUser(User user) {
    log.info("[UserRepository] Create user: {}", user);
    var userDocument = mapper.toDocument(user);
    userDocument.setPassword(encoder.encode(userDocument.getPassword()));
    crud.save(userDocument);
  }

  @Override
  public Optional<User> findByName(String name) {
    log.info("[UserRepository] Find by name: {}" + name);
    return crud.findByName(name).map(mapper::toModel);
  }

  @Override
  public List<User> getAllUsers() {
    log.info("[UserRepository] Get all users");
    var usersDocument = crud.findAll();
    return mapper.toModels(usersDocument);
  }
}
