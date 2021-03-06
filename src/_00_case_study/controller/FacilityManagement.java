package _00_case_study.controller;

import _00_case_study.service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void facilityManagement() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn to main menu\n" +
                    "5.\tExit\n");
            System.out.println("Input your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        facilityService.display();
                        break;
                    case 2:
                        addNew();
                        break;
                    case 3:
                        facilityService.displayMaintain();
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

    public static void addNew() {
        int choice;
        while (true) {
            System.out.println("Menu");
            System.out.println("1\tAdd new villa\n" +
                    "2\tAdd new house\n" +
                    "3\tAdd new room\n" +
                    "4\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        facilityService.addNewVilla();
                        break;
                    case 2:
                        facilityService.addNewHouse();
                        break;
                    case 3:
                        facilityService.addNewRoom();
                        break;
                    case 4:
                        facilityManagement();
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
