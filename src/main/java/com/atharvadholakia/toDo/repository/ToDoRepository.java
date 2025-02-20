package com.atharvadholakia.toDo.repository;

import com.atharvadholakia.toDo.data.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, String> {}
