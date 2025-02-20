package com.atharvadholakia.toDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ToDoBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(ToDoBackendApplication.class, args);
  }

  @GetMapping()
  public String Greetings() {
    return "Hello from Todo";
  }
}
