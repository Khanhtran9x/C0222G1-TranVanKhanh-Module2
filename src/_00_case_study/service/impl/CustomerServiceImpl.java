package _00_case_study.service.impl;

import _00_case_study.model.Customer;
import _00_case_study.service.CustomerService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.RegexData;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList;
    static Scanner scanner = new Scanner(System.in);
    static String path = "src\\_00_case_study\\data\\customer.csv";

    static {
        customerList = ReadAndWrite.readCustomerCsv(path);
    }

    @Override
    public void display() {
        customerList = ReadAndWrite.readCustomerCsv(path);
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
            Customer customer = RegexData.inputNewCustomer();
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
            System.out.println("Please input a number");
            id = Integer.parseInt(scanner.nextLine());
        }

        for (Customer customer: customerList) {
            if (customer.getId() == id){
                customer = RegexData.inputNewCustomer();
                count++;
                break;
            }
        }
        if (count == 0){
            System.err.println("The ID you input does not exist");
        }
        ReadAndWrite.writeCustomerCsv(customerList, path);
    }

    @Override
    public void remove() {

    }
}
