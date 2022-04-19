package _00_case_study.controller;

import java.util.Scanner;

public class BookingManagement {
    public static void bookingManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 7) {
            System.out.println("Menu");
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new contracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n" +
                    "7.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewBooking();
                    break;
                case 2:
                    displayListBooking();
                    break;
                case 3:
                    createNewContracts();
                    break;
                case 4:
                    displayListContracts();
                    break;
                case 5:
                    editContracts();
                    break;
                case 6:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void returnToMainMenu() {
    }

    private static void editContracts() {
    }

    private static void displayListContracts() {
    }

    private static void createNewContracts() {
    }

    private static void displayListBooking() {
    }

    private static void addNewBooking() {
    }
}
