package com.smart.simplechat.common.exception;

public class ElementAlreadyExist extends RuntimeException {
  private static final String ERROR_MESSAGE = "%s: already exist in %s";

  public ElementAlreadyExist(String object, String referenceCod) {
    super(String.format(ERROR_MESSAGE, referenceCod, object));
  }
}
