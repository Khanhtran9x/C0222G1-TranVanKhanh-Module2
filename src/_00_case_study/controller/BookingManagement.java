package _00_case_study.controller;

import _00_case_study.service.impl.BookingServiceImpl;
import _00_case_study.service.impl.ContractServiceImpl;

import java.util.Scanner;

public class BookingManagement {
    public static BookingServiceImpl bookingService = new BookingServiceImpl();
    public static ContractServiceImpl contractService = new ContractServiceImpl();

    public static void bookingManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new contracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n" +
                    "7.\tExit\n");
            System.out.println("Input your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bookingService.addNew();
                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        contractService.addNew();
                        break;
                    case 4:
                        contractService.display();
                        break;
                    case 5:
                        contractService.edit();
                        break;
                    case 6:
                        FuramaController.displayMainMenu();
                        break;
                    case 7:
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
