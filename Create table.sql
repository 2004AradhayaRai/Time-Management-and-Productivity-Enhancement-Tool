-- Create Database and Use It
CREATE DATABASE IF NOT EXISTS EduTimeManager;
USE EduTimeManager;

-- Create Users Table
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    `role` ENUM('STUDENT', 'TEACHER', 'ADMIN') NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample users
INSERT INTO `users` (`username`, `password`, `email`, `role`) 
VALUES 
('john_doe', 'password123', 'john.doe@example.com', 'STUDENT'),
('jane_smith', 'password456', 'jane.smith@example.com', 'TEACHER'),
('admin_user', 'adminpassword', 'admin@example.com', 'ADMIN');

-- Create Tasks Table
CREATE TABLE IF NOT EXISTS `tasks` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `due_date` DATETIME NOT NULL,
    `status` ENUM('PENDING', 'COMPLETED', 'IN_PROGRESS') NOT NULL,
    `category` VARCHAR(255) NOT NULL,
    `priority` ENUM('HIGH', 'MEDIUM', 'LOW') NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
);

-- Insert sample tasks
INSERT INTO `tasks` (`user_id`, `title`, `description`, `due_date`, `status`, `category`, `priority`) 
VALUES 
(1, 'Complete Assignment', 'Finish math assignment on algebra', '2024-11-12 14:00:00', 'PENDING', 'Homework', 'HIGH'),
(2, 'Prepare Lecture', 'Prepare lecture slides on Java for the next class', '2024-11-14 09:00:00', 'IN_PROGRESS', 'Teaching', 'MEDIUM'),
(1, 'Study for Exam', 'Study chapters 5-7 for the upcoming exam', '2024-11-15 18:00:00', 'PENDING', 'Study', 'LOW');

-- Create Categories Table
CREATE TABLE IF NOT EXISTS `categories` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample categories
INSERT INTO `categories` (`name`) 
VALUES 
('Homework'),
('Teaching'),
('Study'),
('Personal'),
('Project');

-- Create Task Logs Table
CREATE TABLE IF NOT EXISTS `task_logs` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `task_id` INT NOT NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `status` ENUM('PENDING', 'COMPLETED', 'IN_PROGRESS') NOT NULL,
    `remarks` TEXT,
    FOREIGN KEY (`task_id`) REFERENCES `tasks`(`id`) ON DELETE CASCADE
);

-- Insert task logs
INSERT INTO `task_logs` (`task_id`, `status`, `remarks`) 
VALUES 
(1, 'COMPLETED', 'Task completed successfully after submission.'),
(2, 'IN_PROGRESS', 'Lecture preparation started.'),
(3, 'PENDING', 'Exam preparation is in progress.');

-- Create User Preferences Table
CREATE TABLE IF NOT EXISTS `user_preferences` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `notifications_enabled` BOOLEAN DEFAULT TRUE,
    `theme` ENUM('LIGHT', 'DARK') DEFAULT 'LIGHT',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
);

-- Insert sample user preferences
INSERT INTO `user_preferences` (`user_id`, `notifications_enabled`, `theme`) 
VALUES 
(1, TRUE, 'LIGHT'),
(2, TRUE, 'DARK'),
(3, FALSE, 'LIGHT');

-- Create Roles Table
CREATE TABLE IF NOT EXISTS `roles` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `role_name` VARCHAR(255) NOT NULL UNIQUE,
    `permissions` TEXT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample roles
INSERT INTO `roles` (`role_name`, `permissions`) 
VALUES 
('STUDENT', 'Can view and manage personal tasks. Cannot access other users\' tasks.'),
('TEACHER', 'Can view and manage personal tasks, can assign tasks to students.'),
('ADMIN', 'Can manage all users and tasks, assign roles, and configure system settings.');
