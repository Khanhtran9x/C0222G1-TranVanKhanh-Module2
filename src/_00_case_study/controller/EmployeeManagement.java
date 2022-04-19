package _00_case_study.controller;

import java.util.Scanner;

public class EmployeeManagement {
    public static void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 5) {
            System.out.println("Menu");
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayListEmployees();
                    break;
                case 2:
                    addNewEmployees();
                    break;
                case 3:
                    editEmployees();
                    break;
                case 4:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void returnToMainMenu() {
    }

    private static void editEmployees() {
    }

    private static void addNewEmployees() {
    }

    private static void displayListEmployees() {
    }
}
