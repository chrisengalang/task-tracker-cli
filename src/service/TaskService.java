package service;

public interface TaskService {

  void addTask(String description);
  void updateTask(int id, String description);
  int deleteTask(int id);
  void listTask();

}
