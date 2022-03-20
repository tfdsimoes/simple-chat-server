package com.smart.simplechat.common.controller;

import com.smart.simplechat.common.exception.ElementAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = ElementAlreadyExistException.class)
  protected ResponseEntity<String> handleElementAlreadyExist(RuntimeException ex) {
    log.error("[RestController] {}: {}", ex.getClass().getSimpleName(), ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
  }
}
