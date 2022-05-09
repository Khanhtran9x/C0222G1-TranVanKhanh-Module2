package _00_exercise.extra_ex_1.controller;

import _00_exercise.extra_ex_1.service.impl.WorkManagementImpl;

import java.util.Scanner;

public class WorkManagementController {
    public static WorkManagementImpl workManagement = new WorkManagementImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("---MENU---");
            System.out.println("1.\tWork List Management\n" +
                                 "2.\tAdd New Work\n" +
                               "3.\tUpdate Progress\n" +
                               "4.\tExit\n");
            try {
                System.out.println("Input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        WorkListManagement.displayMainMenu();
                        break;
                    case 2:
                        workManagement.addNew();
                        break;
                    case 3:
                        workManagement.updateCompletedWork();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.err.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }
}
