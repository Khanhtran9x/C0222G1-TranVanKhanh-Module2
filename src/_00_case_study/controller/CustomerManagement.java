package _00_case_study.controller;

import _00_case_study.service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerManagement {
    public static CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static void customerManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Input your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        customerService.addNew();
                        break;
                    case 3:
                        customerService.edit();
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
