package _00_case_study.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookingRegexAndException {
    static Scanner scanner = new Scanner(System.in);
    static final String REGEX_DATE = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";

    public static String inputStartDate() {
        System.out.println("Input start date:");
        String startDate = scanner.nextLine();

        while (true) {
            try {
                if (Pattern.matches(REGEX_DATE, startDate)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
                    LocalDate now = LocalDate.now();

                    if (start.isAfter(now)) {
                        return startDate;
                    } else {
                        System.err.println("The start date must be after now, please input again");
                        startDate = scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.err.println("Please input the right format of date dd/MM/yyyy");
                startDate = scanner.nextLine();
            }
        }
    }

    public static String inputEndDate(String startDate) {
        System.out.println("Input end date:");
        String endDate = scanner.nextLine();

        while (true) {
            try {
                if (Pattern.matches(REGEX_DATE, endDate)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(startDate, dateTimeFormatter);
                    LocalDate end = LocalDate.parse(endDate, dateTimeFormatter);
                    LocalDate now = LocalDate.now();

                    if (end.isAfter(start)){
                        return endDate;
                    } else {
                        System.err.println("The end date must be after start date, please input again");
                        endDate = scanner.nextLine();
                    }
                }
            } catch (Exception e) {
                System.err.println("Please input the right format of date dd/MM/yyyy");
                endDate = scanner.nextLine();
            }
        }
    }
}
