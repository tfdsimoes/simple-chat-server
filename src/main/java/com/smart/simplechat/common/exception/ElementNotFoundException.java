package com.smart.simplechat.common.exception;

public class ElementNotFoundException extends RuntimeException{
  private static final String ERROR_MESSAGE = "%s: had not been found %s";

  public ElementNotFoundException(String object, String referenceCod) {
    super(String.format(ERROR_MESSAGE, object, referenceCod));
  }
}
