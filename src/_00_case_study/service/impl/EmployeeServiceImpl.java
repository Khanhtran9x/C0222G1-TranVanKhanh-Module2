package _00_case_study.service.impl;

import _00_case_study.model.Employee;
import _00_case_study.service.EmployeeService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String path = "src\\_00_case_study\\data\\employee.csv";

    @Override
    public void display() {
        employeeList = ReadAndWrite.readEmployeeCsv(path);
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        Employee employee = RegexData.inputNewEmployee();
        employeeList.add(employee);
        ReadAndWrite.writeEmployeeCsv(employeeList, path);
    }

    @Override
    public void edit() {
        employeeList = ReadAndWrite.readEmployeeCsv(path);
        int id;
        int count = 0;
        try {
            System.out.println("Input Employee ID to edit");
            id = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (Employee employee : employeeList) {
            if (employee.getId() == (id)) {
                employee = RegexData.inputNewEmployee();
                count++;
                break;
            }
        }
        if (count == 0) {
            System.err.println("The ID you input does not exist");
        }
        ReadAndWrite.writeEmployeeCsv(employeeList, path);
    }

    @Override
    public void remove() {
        int count = 0;
        System.out.println("Input Employee ID to remove");
        int id = Integer.parseInt(scanner.nextLine());
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("The ID you input does not exist");
        }
    }
}
