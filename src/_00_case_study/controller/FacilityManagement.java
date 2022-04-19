package _00_case_study.controller;

import java.util.Scanner;

public class FacilityManagement {
    public static void facilityManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 5) {
            System.out.println("Menu");
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayListFacility();
                    break;
                case 2:
                    addNewFacility();
                    break;
                case 3:
                    displayListFacilityMaintenance();
                    break;
                case 4:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void returnToMainMenu() {
    }

    private static void displayListFacilityMaintenance() {
    }

    private static void addNewFacility() {
    }

    private static void displayListFacility() {
    }
}
