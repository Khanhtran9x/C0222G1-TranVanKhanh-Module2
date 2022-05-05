package _00_case_study.service.impl;

import _00_case_study.model.Customer;
import _00_case_study.service.itf.CustomerService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.PersonRegexAndException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList = new ArrayList<>();
    static List<String[]> stringList;
    static Scanner scanner = new Scanner(System.in);
    static String path = "src\\_00_case_study\\data\\customer.csv";
    static Customer customer;

    public List<Customer> readFile(String path) {
        List<Customer> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            customer = new Customer(strArr);
            list.add(customer);
        }
        return list;
    }

    @Override
    public void display() {
        customerList = readFile(path);
        if (customerList.isEmpty()) {
            System.err.println("Customer list is empty, please input a new one");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer.getInfo());
            }
        }
    }

    @Override
    public void addNew() {
        customerList = readFile(path);
        Customer customer = PersonRegexAndException.inputNewCustomer();
        customerList.add(customer);
        ReadAndWrite.writeListCsv(customerList, path);
        System.out.println("Added employee successfully");
    }

    @Override
    public void edit() {
        customerList = readFile(path);
        int id;
        int count = 0;

        try {
            System.out.println("Input Customer ID to edit");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                Customer customer = PersonRegexAndException.inputNewCustomer();
                customerList.set(i, customer);
                count++;
                break;
            }
        }

        if (count == 0) {
            System.err.println("The ID you input does not exist");
        }

        ReadAndWrite.writeListCsv(customerList, path);
        System.out.println("Edited employee successfully");
    }

    @Override
    public void remove() {
        customerList = readFile(path);
        int id;
        int count = 0;

        try {
            System.out.println("Input Customer ID to remove");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.remove(i);
                count++;
                break;
            }
        }

        if (count == 0) {
            System.err.println("The ID you input does not exist");
        }

        ReadAndWrite.writeListCsv(customerList, path);
    }
}
