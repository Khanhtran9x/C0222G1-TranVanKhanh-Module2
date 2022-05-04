package _00_case_study.service.impl;

import _00_case_study.model.Booking;
import _00_case_study.model.Contract;
import _00_case_study.model.Customer;
import _00_case_study.service.itf.ContractService;
import _00_case_study.utils.BookingRegexAndException;
import _00_case_study.utils.PersonRegexAndException;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList;
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList;
    static String path = "src\\_00_case_study\\data\\contract.csv";

    static {
        customerList = ReadAndWrite.readCustomerCsv("src\\_00_case_study\\data\\customer.csv");
    }

    @Override
    public void display() {
        contractList = ReadAndWrite.readContractCsv(path);
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void addNew() {
        contractList = ReadAndWrite.readContractCsv(path);
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().bookingSet();
        bookingQueue.addAll(bookingSet);
        int count;

        while (true) {
            Booking booking = bookingQueue.poll();
            count = 0;

            if (booking == null) {
                System.out.println("No booking left to create contract");
                break;
            } else if (booking.getServiceId().contains("SVRO")) {
                continue;
            } else {
                for (Contract contract : contractList) {
                    if (contract.getBookingId() == booking.getBookingId()) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    Customer customer = booking.getCustomer();

                    System.out.println("Create contract for booking with information: " + booking.toString());
                    System.out.println("Create contract for customer with information: " + customer.toString());

                    int contractId = BookingRegexAndException.inputContractId();
                    int deposit = BookingRegexAndException.inputDeposit();
                    int totalPay = BookingRegexAndException.inputTotalPay();

                    Contract contract1 = new Contract(contractId, booking.getBookingId(), deposit, totalPay, booking.getCustomerId());
                    contractList.add(contract1);
                    ReadAndWrite.writeContractCsv(contractList, path);
                    break;
                }
            }
        }
    }

    @Override
    public void edit() {
        contractList = ReadAndWrite.readContractCsv(path);
        for (Contract contract: contractList) {
            System.out.println(contract.toString());
        }
        System.out.println("Input the id of which contract you want to edit:");
        int contractId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < contractList.size(); i++) {
            if (contractId == contractList.get(i).getContractId()){
                int id = BookingRegexAndException.inputContractId();
                int deposit = BookingRegexAndException.inputDeposit();
                int totalPay = BookingRegexAndException.inputTotalPay();

                Contract contract = new Contract(id, contractList.get(i).getBookingId(),
                        deposit, totalPay, contractList.get(i).getCustomerId());

                contractList.set(i, contract);
                ReadAndWrite.writeContractCsv(contractList, path);
            }
        }
    }

    @Override
    public void remove() {
    }
}

