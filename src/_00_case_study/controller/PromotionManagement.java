package _00_case_study.controller;

import java.util.Scanner;

public class PromotionManagement {
    public static void promotionManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n" +
                    "4.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayListCustomersUseService();
                    break;
                case 2:
                    displayListCustomersUseVoucher();
                    break;
                case 3:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void returnToMainMenu() {
    }

    private static void displayListCustomersUseVoucher() {
    }

    private static void displayListCustomersUseService() {
    }

}
