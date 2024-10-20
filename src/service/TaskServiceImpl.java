package service;

import model.Task;
import repository.TaskRepository;

import java.io.IOException;
import java.util.*;

public class TaskServiceImpl implements TaskService {

  private Set<Task> tasks;
  private TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) throws IOException {
    this.taskRepository = taskRepository;
    this.tasks = this.taskRepository.getTasks();
  }

  @Override
  public void addTask(String description) {
    int newId = getNextId();
    tasks.add(new Task(newId, description));
    System.out.println("Task added successfully (ID: " + newId + ")");
  }

  @Override
  public void updateTask(int id, String description) {
    Task update = tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);

    if (update != null) {
      update.setDescription(description);
      update.setUpdatedAt(new Date());
      System.out.println("Task updated successfully (ID: " + update.getId() + ")");
    } else {
      System.out.println("Task does not exist.");
    }
  }

  @Override
  public int deleteTask(int id) {
    return 0;
  }

  @Override
  public void listTask() {
    for (Task task : tasks) {
      System.out.println(task);
    }
  }

  private int getNextId() {
    return tasks
        .stream()
        .max(Comparator.comparing(Task::getId))
        .map(task -> task.getId() + 1)
        .orElse(1);
  }
}
