package com.smart.simplechat.common.service.impl;

import java.util.List;
import java.util.Optional;

import com.smart.simplechat.common.exception.ElementAlreadyExistException;
import com.smart.simplechat.common.model.User;
import com.smart.simplechat.common.repo.user.UserRepository;
import com.smart.simplechat.common.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder encoder;

  @Override
  public void createUser(User user) {
    log.info("[UserService] Create new User: {}", user);

    if (userRepository.findByName(user.getName()).isPresent()) {
      throw new ElementAlreadyExistException("USER", user.getName());
    }

    userRepository.createUser(user);
  }

  @Override
  public boolean verifyAuthorization(User user) {
    log.info("[UserService] Verify user credentials: {}", user);

    var optionalUser = userRepository.findByName(user.getName());

    if (optionalUser.isEmpty()) {
        return false;
    } else {
      return encoder.matches(user.getPassword(), optionalUser.get().getPassword());
    }
  }

  @Override
  public List<User> getAllUsers() {
    log.info("[UserService] Get all users");
    return userRepository.getAllUsers();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("[UserService] Load user by username: {}", username);
    Optional<User> optionalUser = userRepository.findByName(username);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException("Name not found");
    }
  }
}
