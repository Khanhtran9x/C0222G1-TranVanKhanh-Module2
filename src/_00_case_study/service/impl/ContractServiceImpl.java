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
    static String contractPath = "src\\_00_case_study\\data\\contract.csv";
    static String bookingPath = "src\\_00_case_study\\data\\contract.csv";

    public List<Contract> readFile(String path) {
        List<Contract> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            contract = new Contract(strArr);
            list.add(contract);
        }
        return list;
    }

    public Contract inputNewContract(Booking booking) {
        stringList = ReadAndWrite.readListCsv(bookingPath);
        Customer customer = booking.getCustomer();

        System.out.println("Create contract for booking with information:\n" + booking.getInfo());
        System.out.println("Create contract for customer with information:\n" + customer.getInfo());

        int contractId = BookingRegexAndException.inputId(stringList);
        int deposit = BookingRegexAndException.inputDeposit();
        int totalPay = BookingRegexAndException.inputTotalPay();

        return new Contract(contractId, booking.getBookingId(), deposit, totalPay, booking.getCustomerId());
    }

    @Override
    public void display() {
        contractList = readFile(contractPath);
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
        contractList = readFile(contractPath);
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().bookingSet();
        bookingQueue.addAll(bookingSet);
        int count;
        Booking booking;

        while (true) {
            booking = bookingQueue.poll();
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
                    contract = inputNewContract(booking);
                    contractList.add(contract);
                    ReadAndWrite.writeListCsv(contractList, contractPath);
                    break;
                }
            }
        }
    }

    @Override
    public void edit() {
        Set<Booking> bookingSet = new BookingServiceImpl().bookingSet();
        Booking booking = null;
        contractList = readFile(contractPath);

        for (Contract contract : contractList) {
            System.out.println(contract.getInfo());
        }
        System.out.println("Input the id of which contract you want to edit:");
        int contractId = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < contractList.size(); i++) {
            if (contractId == contractList.get(i).getContractId()) {
                for (Booking item: bookingSet) {
                   if (item.getBookingId() == contractList.get(i).getBookingId()){
                       booking = item;
                       break;
                   }
                }
                contractList.remove(i);
                ReadAndWrite.writeListCsv(contractList, contractPath);
                contract = inputNewContract(booking);
                contractList.add(i, contract);
                ReadAndWrite.writeListCsv(contractList, contractPath);
            }
        }
    }

    @Override
    public void remove() {
    }
}

