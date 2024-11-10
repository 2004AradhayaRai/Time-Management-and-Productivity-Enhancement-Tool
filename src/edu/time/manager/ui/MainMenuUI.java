package edu.time.manager.ui;

import java.util.Scanner;

public class MainMenuUI {
    private Scanner scanner;

    public MainMenuUI() {
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("Welcome to EduTimeManager!");
        System.out.println("1. View Tasks");
        System.out.println("2. Create Task");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
