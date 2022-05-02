package _00_case_study.utils;

import _00_case_study.model.Customer;
import _00_case_study.model.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PersonRegexAndException {
    static Scanner scanner = new Scanner(System.in);
    static final String REGEX_BIRTH_DAY = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";
    static final String REGEX_STR = "^[a-zA-Z\\s]*$";
    static final String REGEX_ID_CARD = "\\d+";
    static final String REGEX_EMAIL = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";

    public static Customer inputNewCustomer() {
        int id = inputId();
        String name = inputName();
        String dateOfBirth = inputDateOfBirth();
        String address = inputAddress();
        String gender = inputGender();
        String idCard = inputIdCard();
        String email = inputEmail();
        String type = inputCustomerType();

        return new Customer(id, name, dateOfBirth, address, gender, idCard, email, type);
    }

    public static Employee inputNewEmployee() {
        int id = inputId();
        String name = inputName();
        String dateOfBirth = inputDateOfBirth();
        String address = inputAddress();
        String gender = inputGender();
        String idCard = inputIdCard();
        String email = inputEmail();
        String level = inputEmployeeLevel();
        String position = inputEmployeePosition();
        int salary = inputEmployeeSalary();

        return new Employee(id, name, dateOfBirth, address, gender, idCard, email, level, position, salary);
    }

    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String inputDateOfBirth() {
        System.out.println("Input date of birth:");
        String dateOfBirth = scanner.nextLine();
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(REGEX_BIRTH_DAY, dateOfBirth)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(dateOfBirth, dateTimeFormatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current > 18 && current < 100) {
                        check = false;
                    } else {
                        throw new AgeException("Your age is not permitted");
                    }

                } else {
                    throw new AgeException("You inputted the wrong format");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                dateOfBirth = scanner.nextLine();
            }
        }
        return dateOfBirth;
    }

    public static int inputId() {
        System.out.println("Input ID:");
        int id;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number");
            }
        }
        return id;
    }

    public static String inputName() {
        System.out.println("Input name:");
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

    public static String inputAddress() {
        System.out.println("Input Address:");
        String address = scanner.nextLine();
        return address;
    }

    public static String inputGender() {
        System.out.println("Choose Gender: 1. Male  2. Female");
        String gender;
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    gender = "Male";
                    return gender;
                } else if (choice == 2) {
                    gender = "Female";
                    return gender;
                } else {
                    System.err.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static String inputIdCard() {
        System.out.println("Input ID Card:");
        String idCard = scanner.nextLine();
        boolean check = true;
        do {
            if (idCard.matches(REGEX_ID_CARD)) {
                check = false;
            } else {
                System.out.println("Wrong input, please input id card in number format");
                idCard = scanner.nextLine();
            }
        } while (check);
        return idCard;
    }

    public static String inputEmail() {
        System.out.println("Input email:");
        String email = scanner.nextLine();
        boolean check = true;
        do {
            if (email.matches(REGEX_EMAIL)) {
                check = false;
            } else {
                System.out.println("Wrong input, please input email which complies format xxxx@xxxx.xx");
                email = scanner.nextLine();
            }
        } while (check);
        return email;
    }

    public static String inputCustomerType() {
        String type = "";
        int choice;
        while (true) {
            System.out.println("Select customer type: ");
            System.out.println("1. Diamond");
            System.out.println("2. Platinum");
            System.out.println("3. Gold");
            System.out.println("4. Silver");
            System.out.println("5. Member");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        type = "Diamond";
                        return type;
                    case 2:
                        type = "Platinum";
                        return type;
                    case 3:
                        type = "Gold";
                        return type;
                    case 4:
                        type = "Silver";
                        return type;
                    case 5:
                        type = "Member";
                        return type;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static String inputEmployeeLevel() {
        String level = "";
        int choice;
        while (true) {
            System.out.println("Select employee level: ");
            System.out.println("1. Technical");
            System.out.println("2. College");
            System.out.println("3. University");
            System.out.println("4. Master");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        level = "Technical";
                        return level;
                    case 2:
                        level = "College";
                        return level;
                    case 3:
                        level = "University";
                        return level;
                    case 4:
                        level = "Master";
                        return level;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static String inputEmployeePosition() {
        String position = "";
        int choice;
        while (true) {
            System.out.println("Select employee position: ");
            System.out.println("1. Receptionist");
            System.out.println("2. Waiter");
            System.out.println("3. Expert");
            System.out.println("4. Observer");
            System.out.println("5. Manager");
            System.out.println("6. Director");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        position = "Receptionist";
                        return position;
                    case 2:
                        position = "Waiter";
                        return position;
                    case 3:
                        position = "Expert";
                        return position;
                    case 4:
                        position = "Observer";
                        return position;
                    case 5:
                        position = "Manager";
                        return position;
                    case 6:
                        position = "Director";
                        return position;
                    default:
                        System.out.println("Your choice does not match our options");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please input a number which matches our options");
            }
        }
    }

    public static int inputEmployeeSalary() {
        int salary;
        try {
            System.out.println("Input employee salary");
            salary = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please input a number");
            salary = Integer.parseInt(scanner.nextLine());
        }
        return salary;
    }
}
