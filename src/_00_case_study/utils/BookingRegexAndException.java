package _00_case_study.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookingRegexAndException {
    static Scanner scanner = new Scanner(System.in);
    static final String REGEX_DATE = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";

    public static String inputStartDate() {
        System.out.println("Input start date:");
        String startDate;

        while (true) {
            try {
                startDate = scanner.nextLine();
                if (Pattern.matches(REGEX_DATE, startDate)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
                    LocalDate now = LocalDate.now();

                    if (start.isAfter(now)) {
                        return startDate;
                    } else {
                        System.err.println("The start date must be after now, please input again");
                    }
                }
            } catch (Exception e) {
                System.err.println("Please input the right format of date dd/MM/yyyy");
            }
        }
    }

    public static String inputEndDate(String startDate) {
        System.out.println("Input end date:");
        String endDate;

        while (true) {
            try {
                endDate = scanner.nextLine();
                if (Pattern.matches(REGEX_DATE, endDate)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
                    LocalDate end = LocalDate.parse(endDate, dateTimeFormatter);

                    if (end.isAfter(start)){
                        return endDate;
                    } else {
                        System.err.println("The end date must be after start date, please input again");
                    }
                }
            } catch (Exception e) {
                System.err.println("Please input the right format of date dd/MM/yyyy");
            }
        }
    }

    public static int inputContractId(){
        System.out.println("Input contract Id:");
        int contractId;

        while (true){
            try {
                contractId = Integer.parseInt(scanner.nextLine());
                return contractId;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number");
            }
        }
    }

    public static int inputDeposit(){
        System.out.println("Input deposit money:");
        int deposit;

        while (true){
            try {
                deposit = Integer.parseInt(scanner.nextLine());
                return deposit;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number");
            }
        }
    }

    public static int inputTotalPay(){
        System.out.println("Input total pay:");
        int totalPay;

        while (true){
            try {
                totalPay = Integer.parseInt(scanner.nextLine());
                return totalPay;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number");
            }
        }
    }
}
