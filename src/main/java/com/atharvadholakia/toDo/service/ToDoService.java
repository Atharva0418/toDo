package com.atharvadholakia.toDo.service;

import com.atharvadholakia.toDo.data.ToDo;
import com.atharvadholakia.toDo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

  private final ToDoRepository toDoRepostiroy;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepostiroy = toDoRepository;
  }

  public ToDo createToDo(ToDo toDo) {

    toDoRepostiroy.save(toDo);

    return toDo;
  }
}
