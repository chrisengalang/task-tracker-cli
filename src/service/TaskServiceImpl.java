package service;

import model.Task;
import repository.TaskRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class TaskServiceImpl implements TaskService {

  private Set<Task> tasks;
  private TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) throws IOException {
    this.taskRepository = taskRepository;
    this.tasks = this.taskRepository.getTasks();
  }

  @Override
  public int addTask(String description) {
    int newId = getNextId();
    tasks.add(new Task(newId, description));
    System.out.println("Task added successfully (ID: " + newId + ")");

    return newId;
  }

  @Override
  public int updateTask(int id, String description) {
    System.out.println(id + " " + description);
    return 0;
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
