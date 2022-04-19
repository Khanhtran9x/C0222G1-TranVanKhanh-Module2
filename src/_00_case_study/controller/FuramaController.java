package _00_case_study.controller;
import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 6) {
            System.out.println("Menu");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.println("Input your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    EmployeeManagement.employeeManagement();
                    break;
                case 2:
                    CustomerManagement.customerManagement();
                    break;
                case 3:
                    FacilityManagement.facilityManagement();
                    break;
                case 4:
                    BookingManagement.bookingManagement();
                    break;
                case 5:
                    PromotionManagement.promotionManagement();
                    break;
            }
        }
    }
}
