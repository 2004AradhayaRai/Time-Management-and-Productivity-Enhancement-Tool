package main.java.edu.time.manager.ui;

import main.java.edu.time.manager.models.Task;
import main.java.edu.time.manager.models.Priority;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskManagement {
    private Scanner scanner;

    public TaskManagement() {
        scanner = new Scanner(System.in);
    }

    public Task createTaskUI() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task category (e.g., Homework, Assignment): ");
        String category = scanner.nextLine();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDateString = scanner.nextLine();
        LocalDateTime dueDate = LocalDateTime.parse(dueDateString + "T00:00:00");

        System.out.print("Enter task priority (HIGH, MEDIUM, LOW): ");
        String priorityString = scanner.nextLine();
        Priority priority = Priority.valueOf(priorityString.toUpperCase());

        return new Task(title, description, dueDate, category, priority);
    }

    public void displayTaskDetails(Task task) {
        System.out.println("Task ID: " + task.getId());
        System.out.println("Title: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Category: " + task.getCategory());
        System.out.println("Priority: " + task.getPriority());
    }
}
