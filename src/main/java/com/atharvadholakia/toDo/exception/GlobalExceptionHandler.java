package com.atharvadholakia.toDo.exception;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<HashMap<String, String>> handleResourceNotFoundException(
      ResourceNotFoundException ex) {
    HashMap<String, String> response = new HashMap<>();
    response.put("error", ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
