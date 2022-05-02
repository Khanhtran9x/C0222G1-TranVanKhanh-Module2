package _00_case_study.service.impl;

import _00_case_study.model.Booking;
import _00_case_study.model.Customer;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class PromotionServiceImpl {
    static Set<Booking> bookingSet;
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList;
    static Stack<Customer> customerStackByYear = new Stack<>();

    static {
        customerList = ReadAndWrite.readCustomerCsv("src\\_00_case_study\\data\\customer.csv");
        bookingSet = ReadAndWrite.readBookingCsv("src\\_00_case_study\\data\\booking.csv");
    }

    public void displayCustomerUseService() {
        customerStackByYear = new Stack<>();
        System.out.println("Input the year of using service");
        int year = Integer.parseInt(scanner.nextLine());
        int usingServiceYear;

        for (Booking booking : bookingSet) {
            usingServiceYear = Integer.parseInt(booking.getStartDate().substring(6));
            if (usingServiceYear == year) {
                customerStackByYear.add(booking.getCustomer());
            }
        }
        System.out.println("Customer list using service in " + year);
        for (Customer customer : customerStackByYear) {
            System.out.println(customer.toString());
        }
    }

    public void displayCustomerListReceivingVoucher() {
        displayCustomerUseService();
        int voucher10Numbers;
        int voucher20Numbers;
        int voucher50Numbers;

        while (true) {
            System.out.println("Input numbers of voucher 10%");
            voucher10Numbers = Integer.parseInt(scanner.nextLine());

            System.out.println("Input the numbers of voucher 20%");
            voucher20Numbers = Integer.parseInt(scanner.nextLine());

            System.out.println("Input the numbers of voucher 50%");
            voucher50Numbers = Integer.parseInt(scanner.nextLine());

            int sumVoucherNumber = voucher10Numbers + voucher20Numbers + voucher50Numbers;
            if (sumVoucherNumber != customerStackByYear.size()) {
                System.out.println("The number of voucher must be equal to the number of customer, input again");
            } else {
                break;
            }
        }

        List<Customer> customerListReceiveVoucher10 = new ArrayList<>();
        List<Customer> customerListReceiveVoucher20 = new ArrayList<>();
        List<Customer> customerListReceiveVoucher50 = new ArrayList<>();

        for (int i = 0; i < voucher10Numbers; i++) {
            customerListReceiveVoucher10.add(customerStackByYear.pop());
        }

        for (int i = 0; i < voucher20Numbers; i++) {
            customerListReceiveVoucher20.add(customerStackByYear.pop());
        }

        for (int i = 0; i < voucher50Numbers; i++) {
            customerListReceiveVoucher50.add(customerStackByYear.pop());
        }


        System.out.println("List of customers receiving voucher 10%: ");
        for (Customer customer : customerListReceiveVoucher10) {
            System.out.println(customer.toString());
        }
        System.out.println();

        System.out.println("List of customers receiving voucher 20%: ");
        for (Customer customer : customerListReceiveVoucher20) {
            System.out.println(customer.toString());
        }
        System.out.println();

        System.out.println("List of customers receiving voucher 50%: ");
        for (Customer customer : customerListReceiveVoucher50) {
            System.out.println(customer.toString());
        }
    }
}
