package _00_case_study.controller;

import _00_case_study.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeManagement {
    public static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public static void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Input your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        employeeService.addNew();
                        break;
                    case 3:
                        employeeService.edit();
                        break;
                    case 4:
                        FuramaController.displayMainMenu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }

        }
    }
}
