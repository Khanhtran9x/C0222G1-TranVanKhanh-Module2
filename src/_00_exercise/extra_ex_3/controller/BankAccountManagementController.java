package _00_exercise.extra_ex_3.controller;

import _00_exercise.extra_ex_3.service.BankAccountImpl;

import java.util.Scanner;

public class BankAccountManagementController {
    public static BankAccountImpl bankAccount = new BankAccountImpl();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("---BANK ACCOUNT MANAGEMENT PROGRAM---");
            System.out.println("1.\tAdd New" +
                    "2.\tRemove\n" +
                    "3.\tDisplay bank account list\n" +
                    "4.\tSearch\n" +
                    "5.\tExit\n");
            try {
                System.out.println("Input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bankAccount.addNew();
                        break;
                    case 2:
                        bankAccount.remove();
                        break;
                    case 3:
                        bankAccount.display();
                        break;
                    case 4:
                        bankAccount.search();
                        break;
                    case 5:
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
