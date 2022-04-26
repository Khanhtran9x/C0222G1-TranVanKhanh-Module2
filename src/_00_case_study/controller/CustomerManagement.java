package _00_case_study.controller;

import _00_case_study.service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerManagement {
    public static CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static void customerManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 5) {
            System.out.println("Menu");
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayListCustomers();
                    break;
                case 2:
                    addNewCustomers();
                    break;
                case 3:
                    editCustomers();
                    break;
                case 4:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void returnToMainMenu() {
        FuramaController.displayMainMenu();
    }

    private static void editCustomers() {
        customerService.edit();
    }

    private static void addNewCustomers() {
        customerService.addNew();
    }

    private static void displayListCustomers() {
        customerService.display();
    }
}
