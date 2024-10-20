package service;

import model.Task;

public interface TaskService {

  int addTask(String description);
  int updateTask(int id, String description);
  int deleteTask(int id);
  void listTask();

}
