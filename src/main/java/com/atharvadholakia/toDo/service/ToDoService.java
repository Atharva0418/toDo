package com.atharvadholakia.toDo.service;

import com.atharvadholakia.toDo.data.ToDo;
import com.atharvadholakia.toDo.exception.ResourceNotFoundException;
import com.atharvadholakia.toDo.repository.ToDoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

  private final ToDoRepository toDoRepository;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public ToDo createToDo(ToDo toDo) {

    toDoRepository.save(toDo);

    return toDo;
  }

  public ToDo getToDoById(String id) {
    ToDo toDo =
        toDoRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No ToDo with id: " + id));

    return toDo;
  }

  public List<ToDo> getAllToDo() {
    return toDoRepository.findAll();
  }

  public ToDo updateToDo(String id, ToDo newToDo) {
    ToDo existingToDo = getToDoById(id);

    existingToDo.setTitle(newToDo.getTitle());

    toDoRepository.save(existingToDo);
    return existingToDo;
  }

  public ToDo updateIsCompleted(String id, boolean isCompleted) {
    ToDo toDo = getToDoById(id);

    toDo.setIsCompleted(isCompleted);

    toDoRepository.save(toDo);
    return toDo;
  }

  public void deleteToDoById(String id) {

    toDoRepository.deleteById(id);
  }
}
