package _00_case_study.service.impl;

import _00_case_study.model.Customer;
import _00_case_study.service.itf.CustomerService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.PersonRegexAndException;

import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList;
    static Scanner scanner = new Scanner(System.in);
    static String path = "src\\_00_case_study\\data\\customer.csv";

    @Override
    public void display() {
        customerList = ReadAndWrite.readCustomerCsv(path);
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        customerList = ReadAndWrite.readCustomerCsv(path);
        Customer customer = PersonRegexAndException.inputNewCustomer();
        customerList.add(customer);
        ReadAndWrite.writeCustomerCsv(customerList, path);
    }

    @Override
    public void edit() {
        customerList = ReadAndWrite.readCustomerCsv(path);
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
        ReadAndWrite.writeCustomerCsv(customerList, path);
    }

    @Override
    public void remove() {
        customerList = ReadAndWrite.readCustomerCsv(path);
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
        ReadAndWrite.writeCustomerCsv(customerList, path);
    }
}
