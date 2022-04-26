package _00_case_study.service.impl;

import _00_case_study.model.Customer;
import _00_case_study.service.CustomerService;
import _00_case_study.utils.ReadAndWrite;
import _00_case_study.utils.RegexData;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final String REGEX_BIRTH_DAY = "(([0-2][0-9])|([3][0-1]))[\\/](([0][1-9])|([1][0,2]))[\\/]\\d{4}";
    static List<Customer> customerList = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    String path = "src\\_00_case_study\\data\\customer.csv";

    @Override
    public void display() {
        customerList = (List<Customer>) ReadAndWrite.read(path);
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        try{
            System.out.println("Input Customer ID:");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Input Customer Name:");
            String name = scanner.nextLine();

            System.out.println("Input Customer Age:");
            String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTH_DAY);

            System.out.println("Input Customer Address:");
            String address = scanner.nextLine();

            boolean gender = false;
            System.out.println("Choose Customer Gender: 1. Male  2. Female");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1){
                gender = true;
            }

            System.out.println("Input Customer ID Card:");
            String idCard = scanner.nextLine();


            System.out.println("Input Customer Email:");
            String email = scanner.nextLine();

            System.out.println("Input Customer type:");
            String type = scanner.nextLine();

            Customer customer = new Customer(id, name, dateOfBirth, address, gender, idCard, email, type);

            customerList.add(customer);
            ReadAndWrite.write(customerList, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit() {
        try {
            int count = 0;
            System.out.println("Input Customer ID to edit");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getId() == id){
                    System.out.println("Input new ID:");
                    int newId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Input new name:");
                    String newName = scanner.nextLine();

                    System.out.println("Input new age:");
                    String newDateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTH_DAY);

                    System.out.println("Input new address:");
                    String newAddress = scanner.nextLine();

                    boolean newGender = false;
                    System.out.println("Choose Customer Gender: 1. Male  2. Female");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1){
                        newGender = true;
                    }

                    System.out.println("Input new ID Card:");
                    String newIdCard = scanner.nextLine();


                    System.out.println("Input new email:");
                    String newEmail = scanner.nextLine();

                    System.out.println("Input new type:");
                    String newType = scanner.nextLine();

                    Customer customer = new Customer(newId, newName, newDateOfBirth, newAddress,
                            newGender, newIdCard, newEmail, newType);
                    customerList.remove(i);
                    customerList.add(i, customer);
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

    }
}
