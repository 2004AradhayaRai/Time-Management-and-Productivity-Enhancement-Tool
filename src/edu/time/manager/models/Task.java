package edu.time.manager.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class Task {
    private int id;
    private int userId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private String status;
    private String category;
    private Priority priority;

    // Constructor with category and priority
    public Task(String title, String description, LocalDateTime dueDate, String category, Priority priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
    }

    public Task(int id, int userId, String title, String description, Date dueDate, String status) {

    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                ", priority=" + priority +
                '}';
    }

    public int getUserId() {


        return 0;
    }

    public String getStatus() {

        return "";
    }

    public int getId() {

        return 0;
    }
}
