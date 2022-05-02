package _00_case_study.service.impl;

import _00_case_study.model.Booking;
import _00_case_study.model.Contract;
import _00_case_study.model.Customer;
import _00_case_study.service.itf.ContractService;
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

                    System.out.println("Input contract Id");
                    int contractId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input the deposit money");
                    int deposit = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input the total pay");
                    int totalPay = Integer.parseInt(scanner.nextLine());

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
                System.out.println("Input contract Id");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("Input booking Id");
                int bookingId = Integer.parseInt(scanner.nextLine());

                System.out.println("Input customer Id");
                int customerId = Integer.parseInt(scanner.nextLine());

                System.out.println("Input the deposit money");
                int deposit = Integer.parseInt(scanner.nextLine());

                System.out.println("Input the total pay");
                int totalPay = Integer.parseInt(scanner.nextLine());

                Contract contract = new Contract(id, bookingId, deposit, totalPay, customerId);
                contractList.set(i, contract);
                ReadAndWrite.writeContractCsv(contractList, path);
            }
        }
    }

    @Override
    public void remove() {
    }
}

