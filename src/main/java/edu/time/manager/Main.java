package main.java.edu.time.manager;

import main.java.edu.time.manager.models.Priority;
import main.java.edu.time.manager.models.Task;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to EduTimeManager!");

        Task task = new Task("Complete Assignment", "Finish math assignment", LocalDateTime.now().plusDays(1), "Homework", Priority.HIGH);
        System.out.println("Task Created: " + task.getTitle());
    }
}
