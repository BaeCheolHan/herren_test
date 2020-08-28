package com.herren.exception;

public class HerrenException extends RuntimeException {

  public HerrenException() {
  }

  public HerrenException(String message) {
    super(message);
  }

  public HerrenException(String message, Throwable cause) {
    super(message, cause);
  }

  public HerrenException(Throwable cause) {
    super(cause);
  }

  public HerrenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
