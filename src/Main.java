import command.TaskCommands;
import repository.TaskRepositoryImpl;
import service.TaskServiceImpl;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {

  public static final String PATH = "database.json";

  public static void main(String[] args) throws IOException {
    new TaskCommands(new TaskServiceImpl(new TaskRepositoryImpl(Paths.get(PATH)))).run();
  }

}