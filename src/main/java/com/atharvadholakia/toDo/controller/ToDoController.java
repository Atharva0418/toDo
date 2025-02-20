package com.atharvadholakia.toDo.controller;

import com.atharvadholakia.toDo.data.ToDo;
import com.atharvadholakia.toDo.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toDo")
public class ToDoController {

  private final ToDoService toDoService;

  public ToDoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @PostMapping("/add")
  public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
    toDoService.createToDo(toDo);

    return new ResponseEntity<>(toDo, HttpStatus.CREATED);
  }
}
