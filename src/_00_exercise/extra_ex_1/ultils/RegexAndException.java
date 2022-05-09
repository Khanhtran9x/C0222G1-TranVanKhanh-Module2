package _00_exercise.extra_ex_1.ultils;

import java.util.Scanner;

public class RegexAndException {
    public static Scanner scanner = new Scanner(System.in);
    static final String REGEX_STR = "^[A-Z]([a-z\\s]{1,8})+$";
    static final String REGEX_CODE = "^(TASK-)[\\d]{4}$";

    public static String inputCode() {
        String name = scanner.nextLine();
        boolean check = true;
        do {
            if (name.matches(REGEX_CODE)) {
                check = false;
            } else {
                System.out.println("Please input again, the right format must be TASK-XXXX");
                name = scanner.nextLine();
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
                System.out.println("Please input again, the first letter must be upper case");
                name = scanner.nextLine();
            }
        } while (check);
        return name;
    }
}
