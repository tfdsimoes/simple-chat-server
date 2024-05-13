package com.smart.simplechat.common.repo.user;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.common.model.User;

public interface UserRepository {

  void createUser(User user);

  Optional<User> findByName(String name);

  List<User> getAllUsers();
}
