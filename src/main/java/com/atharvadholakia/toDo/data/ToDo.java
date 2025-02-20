package com.atharvadholakia.toDo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class ToDo {

  @Id private String id;

  private String title;

  private boolean isCompleted = false;

  public ToDo() {
    this.id = UUID.randomUUID().toString();
  }

  public ToDo(String title) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
  }

  @Override
  public String toString() {
    return "ToDo: "
        + "id='"
        + id
        + '\''
        + "title= '"
        + title
        + '\''
        + "isCompleted='"
        + isCompleted
        + '\'';
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean getIsCompleted() {
    return isCompleted;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }
}
