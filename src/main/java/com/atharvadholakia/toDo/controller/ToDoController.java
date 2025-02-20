package com.atharvadholakia.toDo.controller;

import com.atharvadholakia.toDo.data.ToDo;
import com.atharvadholakia.toDo.service.ToDoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/{id}")
  public ResponseEntity<ToDo> getToDoById(@PathVariable String id) {
    ToDo toDo = toDoService.getToDoById(id);

    return new ResponseEntity<>(toDo, HttpStatus.FOUND);
  }

  @GetMapping("/all")
  public ResponseEntity<List<ToDo>> getAllToDo() {
    List<ToDo> allToDo = toDoService.getAllToDo();

    return new ResponseEntity<>(allToDo, HttpStatus.OK);
  }

  @PatchMapping("/update/{id}")
  public ResponseEntity<ToDo> updateTodo(@PathVariable String id, @RequestBody ToDo newToDo) {
    ToDo updatedTodo = toDoService.updateToDo(id, newToDo);

    return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ToDo> updateIsCompleted(
      @PathVariable String id, @RequestParam boolean isCompleted) {
    ToDo updatedToDo = toDoService.updateIsCompleted(id, isCompleted);

    return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteToDoById(@PathVariable String id) {
    toDoService.deleteToDoById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
