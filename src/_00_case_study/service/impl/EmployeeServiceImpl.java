package _00_case_study.service.impl;

import _00_case_study.model.Employee;
import _00_case_study.service.itf.EmployeeService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.PersonRegexAndException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static List<String[]> stringList;
    static Scanner scanner = new Scanner(System.in);
    static String path = "src\\_00_case_study\\data\\employee.csv";
    static Employee employee;

    @Override
    public void display() {
        employeeList = readFile();
        if (employeeList.isEmpty()) {
            System.err.println("Employee list is empty, please input a new one");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee.getInfo());
            }
        }
    }

    @Override
    public void addNew() {
        employeeList = readFile();
        Employee employee = PersonRegexAndException.inputNewEmployee();
        employeeList.add(employee);
        ReadAndWrite.writeListCsv(employeeList, path);
        System.out.println("Added employee successfully");
    }

    public List<Employee> readFile() {
        List<Employee> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            employee = new Employee(strArr);
            list.add(employee);
        }
        return list;
    }

    @Override
    public void edit() {
        employeeList = readFile();
        int id;
        int count = 0;

        try {
            System.out.println("Input Employee ID to edit");
            id = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == (id)) {
                Employee employee = PersonRegexAndException.inputNewEmployee();
                employeeList.set(i, employee);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.err.println("The ID you input does not exist");
        }
        ReadAndWrite.writeListCsv(employeeList, path);
    }

    @Override
    public void remove() {
    }
}
