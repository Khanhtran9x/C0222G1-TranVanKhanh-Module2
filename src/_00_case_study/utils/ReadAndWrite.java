package _00_case_study.utils;


import _00_case_study.model.Customer;
import _00_case_study.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeCustomerCsv(List<Customer> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("ID,");
            fileWriter.append("NAME,");
            fileWriter.append("DATE OF BIRTH,");
            fileWriter.append("ADDRESS,");
            fileWriter.append("GENDER,");
            fileWriter.append("ID CARD,");
            fileWriter.append("EMAIL,");
            fileWriter.append("TYPE" + "\n");
            for (Customer customer: list) {
                  fileWriter.append(customer.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomerCsv(String path) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                customer = new Customer(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Boolean.parseBoolean(arr[4]), arr[5], arr[6], arr[7]);
                customerList.add(customer);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  customerList;
    }

    public static void writeEmployeeCsv(List<Employee> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("ID,");
            fileWriter.append("NAME,");
            fileWriter.append("DATE OF BIRTH,");
            fileWriter.append("ADDRESS,");
            fileWriter.append("GENDER,");
            fileWriter.append("ID CARD,");
            fileWriter.append("EMAIL,");
            fileWriter.append("LEVEL,");
            fileWriter.append("POSITION,");
            fileWriter.append("SALARY" + "\n");
            for (Employee employee: list) {
                fileWriter.append(employee.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeCsv(String path) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                employee = new Employee(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        Boolean.parseBoolean(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]),
                        arr[8], Integer.parseInt(arr[9]));
                employeeList.add(employee);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  employeeList;
    }
}
