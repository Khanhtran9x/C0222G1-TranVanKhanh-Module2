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

    public List<Employee> readFile() {
        List<Employee> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            employee = new Employee(strArr);
            list.add(employee);
        }
        return list;
    }

    public Employee inputNewEmployee() {
        List<String[]> list = ReadAndWrite.readListCsv(path);
        int id =  PersonRegexAndException.inputId(list);
        String name =  PersonRegexAndException.inputName();
        String dateOfBirth =  PersonRegexAndException.inputDateOfBirth();
        String address =  PersonRegexAndException.inputAddress();
        String gender =  PersonRegexAndException.inputGender();
        String idCard =  PersonRegexAndException.inputIdCard();
        String email =  PersonRegexAndException.inputEmail();
        String level =  PersonRegexAndException.inputEmployeeLevel();
        String position =  PersonRegexAndException.inputEmployeePosition();
        int salary =  PersonRegexAndException.inputEmployeeSalary();

        return new Employee(id, name, dateOfBirth, address, gender, idCard, email, level, position, salary);
    }

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
        Employee employee = inputNewEmployee();
        employeeList.add(employee);
        ReadAndWrite.writeListCsv(employeeList, path);
        System.out.println("Added employee successfully");
    }

    @Override
    public void edit() {
        employeeList = readFile();
        int id;
        int count = 0;
        Employee employee;

        try {
            System.out.println("Input Employee ID to edit");
            id = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == (id)) {
                employeeList.remove(i);
                ReadAndWrite.writeListCsv(employeeList, path);
                employee = inputNewEmployee();
                employeeList.add(i, employee);
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
