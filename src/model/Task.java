package model;

import java.util.Date;

public class Task {

  private int id;
  private String description;
  private Status status;
  private Date createdAt;
  private Date updatedAt;

  public Task(int id, String description) {
    this.id = id;
    this.description = description;
    this.status = Status.TODO;
    this.createdAt = new Date();
    this.updatedAt = new Date();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String toString() {
    return "ID: " + this.id + "\n" +
        "Description: " + this.description + "\n" +
        "Status: " + this.status + "\n" +
        "CreatedAt: " + this.createdAt + "\n" +
        "UpdatedAt: " + this.updatedAt + "\n";
  }
}

enum Status {
  TODO("todo"),
  IN_PROGRESS("in-progress"),
  DONE("done");

  private String status;

  Status(String status) {
    this.status = status;
  }
}