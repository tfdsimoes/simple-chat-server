package com.smart.simplechat.common.exception;

public class ElementAlreadyExistException extends RuntimeException {
  private static final String ERROR_MESSAGE = "%s: already exist in %s";

  public ElementAlreadyExistException(String object, String referenceCod) {
    super(String.format(ERROR_MESSAGE, referenceCod, object));
  }
}
