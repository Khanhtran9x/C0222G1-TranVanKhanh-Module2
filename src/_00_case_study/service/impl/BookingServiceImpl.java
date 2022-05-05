package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.itf.BookingService;
import _00_case_study.utils.BookingComparator;
import _00_case_study.utils.BookingRegexAndException;
import _00_case_study.utils.ReadAndWrite;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static List<String[]> stringList;
    static List<Customer> customerList;
    static Map<Facility, Integer> facilityIntegerMap;
    static Set<Booking> bookingSet;
    static String customerPath = "src\\_00_case_study\\data\\customer.csv";
    static String bookingPath = "src\\_00_case_study\\data\\booking.csv";
    static String facilityPath = "src\\_00_case_study\\data\\facility.csv";
    static Booking booking;
    static Customer customer;
    static Villa villa;
    static House house;
    static Room room;

    public Set<Booking> bookingSet() {
        return readSetFile(bookingPath);
    }

    public Set<Booking> readSetFile(String path) {
        Set<Booking> set = new TreeSet<>(new BookingComparator());
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            booking = new Booking(strArr);
            set.add(booking);
        }
        return set;
    }

    public List<Customer> readListFile(String path) {
        List<Customer> list = new ArrayList<>();
        stringList = ReadAndWrite.readListCsv(path);
        for (String[] strArr : stringList) {
            customer = new Customer(strArr);
            list.add(customer);
        }
        return list;
    }

    public Map<Facility, Integer> readMapFile(String path) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        stringList = ReadAndWrite.readListCsv(path);

        for (String[] strArr : stringList) {
            if (strArr[0].contains("SVVL")) {
                villa = new Villa(strArr);
                facilityMap.put(villa, Integer.parseInt(strArr[9]));
            }

            if (strArr[0].contains("SVHO")) {
                house = new House(strArr);
                facilityMap.put(house, Integer.parseInt(strArr[8]));
            }

            if (strArr[0].contains("SVRO")) {
                room = new Room(strArr);
                facilityMap.put(room, Integer.parseInt(strArr[7]));
            }
        }
        return facilityMap;
    }

    @Override
    public void display() {
        bookingSet = readSetFile(bookingPath);

        if (bookingSet.isEmpty()) {
            System.err.println("Booking set is empty, please input a new one");
        } else {
            for (Booking booking : bookingSet) {
                System.out.println(booking.getInfo());
            }
        }
    }

    public Customer chooseCustomer() {
        System.out.println("Customer list: ");
        customerList = readListFile(customerPath);

        for (Customer customer : customerList) {
            System.out.println(customer.getInfo());
        }

        System.out.println("Input customer Id");
        int id;

        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                for (Customer customer : customerList) {
                    if (id == customer.getId()) {
                        return customer;
                    }
                }
                System.err.println("Not found, please input customer Id again");
            } catch (NumberFormatException e) {
                System.err.println("Please input a number");
            }
        }
    }

    public Facility chooseFacility() {
        System.out.println("Facility list: ");
        facilityIntegerMap = readMapFile(facilityPath);

        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            System.out.println(map.getKey().getInfo());
        }

        System.out.println("Input facility Id");
        String id;

        while (true) {
            id = scanner.nextLine();
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                if (id.equals(map.getKey().getFacilityId())) {
                    facilityIntegerMap.put(map.getKey(), map.getValue() + 1);
                    ReadAndWrite.writeMapCsv(facilityIntegerMap, facilityPath);
                    return map.getKey();
                }
            }
            System.err.println("Not found, please input facility id again");
        }
    }

    @Override
    public void addNew() {
        bookingSet = readSetFile(bookingPath);
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size() + 1;
        }

        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        String startDate = BookingRegexAndException.inputStartDate();
        String endDate = BookingRegexAndException.inputEndDate(startDate);

        Booking booking = new Booking(id, startDate, endDate, customer.getId(),
                facility.getFacilityId(), facility.getServiceName());
        bookingSet.add(booking);
        ReadAndWrite.writeSetCsv(bookingSet, bookingPath);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }
}
