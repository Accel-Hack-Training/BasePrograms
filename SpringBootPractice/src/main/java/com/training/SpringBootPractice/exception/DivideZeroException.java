package com.training.SpringBootPractice.exception;

public class DivideZeroException extends RuntimeException {
  public DivideZeroException(String message) {
    super(message);
  }
}
