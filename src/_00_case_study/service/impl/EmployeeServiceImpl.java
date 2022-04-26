package _00_case_study.service.impl;

import _00_case_study.model.Employee;
import _00_case_study.service.EmployeeService;
import _00_case_study.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    public static final String REGEX_BIRTH_DAY = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";
    static List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee employee: employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        try{
            System.out.println("Input Employee ID:");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Input Employee Name:");
            String name = scanner.nextLine();

            System.out.println("Input Employee Age:");
            String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTH_DAY);

            System.out.println("Input Employee Address:");
            String address = scanner.nextLine();

            boolean gender = false;
            System.out.println("Choose Employee Gender: 1. Male  2. Female");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                gender = true;
            }

            System.out.println("Input Employee ID Card:");
            String idCard = scanner.nextLine();


            System.out.println("Input Employee Email:");
            String email = scanner.nextLine();

            System.out.println("Input Employee Level:");
            int level = Integer.parseInt(scanner.nextLine());

            System.out.println("Input Employee Position");
            String position = scanner.nextLine();

            System.out.println("Input Employee Salary");
            int salary = Integer.parseInt(scanner.nextLine());

            Employee employee = new Employee(id, name, dateOfBirth, address, gender,
                    idCard, email, level, position, salary);

            employeeList.add(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit() {
        try {
            int count = 0;
            System.out.println("Input Employee ID to edit");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getId() == id){
                    System.out.println("Input new ID");
                    int newID = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input new name");
                    String newName = scanner.nextLine();
                    System.out.println("Input new age");
                    String newDateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTH_DAY);                    System.out.println("Input new address");
                    String newAddress = scanner.nextLine();
                    System.out.println("Input new gender: 1. Male   2. Female");
                    int choice = Integer.parseInt(scanner.nextLine());
                    boolean newGender = false;
                    if (choice == 1){
                        newGender = true;
                    }
                    System.out.println("Input new ID Card");
                    String newIdCard = scanner.nextLine();
                    System.out.println("Input new email");
                    String newEmail = scanner.nextLine();
                    System.out.println("Input new level");
                    int newLevel = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input new position");
                    String newPosition = scanner.nextLine();
                    System.out.println("Input new salary");
                    int newSalary = Integer.parseInt(scanner.nextLine());
                    Employee employee = new Employee(newID, newName, newDateOfBirth, newAddress, newGender,
                            newIdCard, newEmail, newLevel, newPosition, newSalary);
                    employeeList.remove(i);
                    employeeList.add(i, employee);
                    count++;
                    break;
                }
            }
            if (count == 0){
                System.out.println("The ID you input does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove() {
        int count = 0;
        System.out.println("Input Employee ID to remove");
        int id = scanner.nextInt();
        for (Employee employee: employeeList) {
            if (employee.getId() == id){
                employeeList.remove(employee);
                count++;
                break;
            }
        }
        if (count == 0){
            System.out.println("The ID you input does not exist");
        }
    }
}
