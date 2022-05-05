package _00_case_study.service.impl;

import _00_case_study.model.Booking;
import _00_case_study.model.Contract;
import _00_case_study.model.Customer;
import _00_case_study.service.itf.ContractService;
import _00_case_study.utils.BookingRegexAndException;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static Scanner scanner = new Scanner(System.in);
    static List<Contract> contractList;
    static List<String[]> stringList;
    static Contract contract;
    static String path = "src\\_00_case_study\\data\\contract.csv";

    public List<Contract> readFile(String path) {
        List<Contract> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            contract = new Contract(strArr);
            list.add(contract);
        }
        return list;
    }

    @Override
    public void display() {
        contractList = readFile(path);
        if (contractList.isEmpty()) {
            System.err.println("Contract list is empty, please input a new one");
        } else {
            for (Contract contract : contractList) {
                System.out.println(contract.getInfo());
            }
        }
    }

    @Override
    public void addNew() {
        contractList = readFile(path);
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
            } else if (!booking.getServiceId().contains("SVRO")) {
                for (Contract contract : contractList) {
                    if (contract.getBookingId() == booking.getBookingId()) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    Customer customer = booking.getCustomer();

                    System.out.println("Create contract for booking with information:\n" + booking.getInfo());
                    System.out.println("Create contract for customer with information:\n" + customer.getInfo());

                    int contractId = BookingRegexAndException.inputContractId();
                    int deposit = BookingRegexAndException.inputDeposit();
                    int totalPay = BookingRegexAndException.inputTotalPay();

                    Contract contract1 = new Contract(contractId, booking.getBookingId(), deposit, totalPay, booking.getCustomerId());
                    contractList.add(contract1);
                    ReadAndWrite.writeListCsv(contractList, path);
                    break;
                }
            }
        }
    }

    @Override
    public void edit() {
        contractList = readFile(path);
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
        System.out.println("Input the id of which contract you want to edit:");
        int contractId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < contractList.size(); i++) {
            if (contractId == contractList.get(i).getContractId()) {
                int id = BookingRegexAndException.inputContractId();
                int deposit = BookingRegexAndException.inputDeposit();
                int totalPay = BookingRegexAndException.inputTotalPay();

                Contract contract = new Contract(id, contractList.get(i).getBookingId(),
                        deposit, totalPay, contractList.get(i).getCustomerId());

                contractList.set(i, contract);
                ReadAndWrite.writeListCsv(contractList, path);
            }
        }
    }

    @Override
    public void remove() {
    }
}

