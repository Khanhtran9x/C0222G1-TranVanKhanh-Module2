package _00_case_study.controller;

import _00_case_study.service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public static void facilityManagement() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 5) {
            System.out.println("Menu");
            System.out.println("1\tAdd new villa\n" +
                    "2\tAdd new house\n" +
                    "3\tAdd new room\n" +
                    "4\tReturn main menu\n" +
                    "5.\tExit\n");
            System.out.println("Nhập vào lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    returnToMainMenu();
                    break;
            }
        }
    }

    private static void addNewVilla() {
        facilityService.addNewVilla();
    }

    private static void addNewHouse() {
        facilityService.addNewHouse();
    }

    private static void addNewRoom() {
        facilityService.addNewRoom();
    }

    private static void returnToMainMenu() {
    }
}
