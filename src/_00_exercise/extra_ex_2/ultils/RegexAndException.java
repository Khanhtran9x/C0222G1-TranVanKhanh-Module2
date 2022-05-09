package _00_exercise.extra_ex_2.ultils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexAndException {
    public static Scanner scanner = new Scanner(System.in);
    static final String REGEX_STR = "^[A-Z]([a-z\\s]{1,8})+$";
    static final String REGEX_CODE = "^(CI-)[\\d]{4}$";
    static final String REGEX_DATE = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";
    static final String PATH = "src\\_00_exercise\\extra_ex_2\\data\\MovieShow.csv";

    public static String inputCode() {
        String name;
        boolean check = true;
        do {
            name = scanner.nextLine();
            if (CheckCode.checkCode(name, ReadAndWrite.readCsvFile(PATH))){
                System.err.println("Code existed, please input a new one");
                continue;
            }
            if (name.matches(REGEX_CODE)) {
                check = false;
            } else {
                System.err.println("Please input again, the right format must be CI-XXXX");
            }
        } while (check);
        return name;
    }

    public static String inputName() {
        String name = scanner.nextLine();
        boolean check = true;
        do {
            if (name.matches(REGEX_STR)) {
                check = false;
            } else {
                System.err.println("Please input again, the first letter must be upper case");
                name = scanner.nextLine();
            }
        } while (check);
        return name;
    }

    public static String inputShowDate() {
        String showDate;

        while (true) {
            try {
                showDate = scanner.nextLine();
                if (Pattern.matches(REGEX_DATE, showDate)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate start = LocalDate.parse(showDate, dateTimeFormatter);
                    LocalDate now = LocalDate.now();

                    if (start.isAfter(now)) {
                        return showDate;
                    } else {
                        System.err.println("The start date must be after now, please input again");
                    }
                } else {
                    throw new Exception("Please input the right format of date dd/MM/yyyy");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static int inputTickets(){
        int tickets;

        while (true){
            try {
                tickets = Integer.parseInt(scanner.nextLine());
                if (tickets <= 0) {
                    throw new NumberFormatException();
                }
                return tickets;
            } catch (NumberFormatException e) {
                System.err.println("Please input a positive number");
            }
        }
    }
}
