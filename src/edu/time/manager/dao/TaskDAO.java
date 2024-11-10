package edu.time.manager.dao;

import edu.time.manager.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    // SQL Queries
    private static final String INSERT_TASK_SQL = "INSERT INTO Tasks (user_id, title, description, due_date, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_TASK_BY_ID_SQL = "SELECT * FROM Tasks WHERE id = ?";
    private static final String SELECT_TASKS_BY_USER_ID_SQL = "SELECT * FROM Tasks WHERE user_id = ?";
    private static final String UPDATE_TASK_SQL = "UPDATE Tasks SET title = ?, description = ?, due_date = ?, status = ? WHERE id = ?";
    private static final String DELETE_TASK_SQL = "DELETE FROM Tasks WHERE id = ?";

    // Insert a new task
    public void addTask(Task task) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_TASK_SQL)) {
            statement.setInt(1, task.getUserId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setDate(4, task.getDueDate());
            statement.setString(5, task.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve a task by its ID
    public Task getTaskById(int id) {
        Task task = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_TASK_BY_ID_SQL)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                task = new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    // Retrieve all tasks for a specific user
    public List<Task> getTasksByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_TASKS_BY_USER_ID_SQL)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Update a task
    public void updateTask(Task task) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TASK_SQL)) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDueDate());
            statement.setString(4, task.getStatus());
            statement.setInt(5, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a task by its ID
    public void deleteTask(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TASK_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
