package command;

import service.TaskService;
import java.util.Scanner;

public class TaskCommands {

  private final Scanner scanner;
  private final TaskService taskService;

  public TaskCommands(TaskService taskService) {
    this.scanner = new Scanner(System.in);
    this.taskService = taskService;
  }

  public void run() {
    boolean isRunning = true;

    while (isRunning) {
      System.out.print("Enter a command: ");
      String command = scanner.next().toLowerCase();
      switch (command.toLowerCase()) {
        case "add" -> add();
        case "update" -> update();
        case "delete" -> System.out.println("Delete");
        case "list" -> list();
        case "exit" -> {
          isRunning = false;
          exit();
        }
        default -> System.out.println("Invalid command");
      }
    }
  }

  private void exit() {
    System.out.println("Program is closing.");
    scanner.close();
  }

  private void add() {
    String description = scanner.nextLine().trim();
    taskService.addTask(description);
  }

  private void update() {
    int id = scanner.nextInt();
    String description = scanner.nextLine().trim();
    taskService.updateTask(id, description);
  }

  private void list() {
    taskService.listTask();
  }

}
