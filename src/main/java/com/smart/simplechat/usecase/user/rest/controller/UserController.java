package com.smart.simplechat.usecase.user.rest.controller;

import java.util.List;

import com.smart.simplechat.common.controller.RestExceptionHandler;
import com.smart.simplechat.common.service.UserService;
import com.smart.simplechat.rest.controller.api.UsersApi;
import com.smart.simplechat.rest.controller.model.UserAnswerDTO;
import com.smart.simplechat.rest.controller.model.UserRequestDTO;
import com.smart.simplechat.usecase.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController extends RestExceptionHandler implements UsersApi {

  private final UserService userService;

  private final UserMapper userMapper;

  @Override
  public ResponseEntity<Void> createUser(UserRequestDTO userRequestDTO) {
    log.info("[UserController] Create user: {}", userRequestDTO);
    userService.createUser(userMapper.toModel(userRequestDTO));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<UserAnswerDTO>> geAllUsers() {
    log.info("[UserController] Get all users");
    return ResponseEntity.ok(userMapper.toDTOs(userService.getAllUsers()));
  }

  @Override
  public ResponseEntity<Void> loginUser(UserRequestDTO userRequestDTO) {
    log.info("[UserController] Login user");
    var result = userService.verifyAuthorization(userMapper.toModel(userRequestDTO));

    if (result) {
      return ResponseEntity.ok().build();
    } else {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }

  @Override
  public ResponseEntity<Void> logoutUser() {
    return ResponseEntity.ok().build();
  }
}
