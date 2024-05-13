package com.smart.simplechat.common.service;

import java.util.List;

import com.smart.simplechat.common.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  void createUser(User user);

  boolean verifyAuthorization(User user);

  List<User> getAllUsers();
}
