package repository;

import model.Task;

import java.io.IOException;
import java.util.Set;

public interface TaskRepository {

  Set<Task> getTasks() throws IOException;

  void saveTasks(Set<Task> tasks);

}
