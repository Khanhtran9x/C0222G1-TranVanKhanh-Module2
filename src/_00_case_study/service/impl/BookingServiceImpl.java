package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.itf.BookingService;
import _00_case_study.utils.BookingRegexAndException;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList;
    static List<Villa> villaList;
    static List<House> houseList;
    static List<Room> roomList;
    static Set<Booking> bookingSet;
    static Map<Facility, Integer> facilityIntegerMap;
    static String path = "src\\_00_case_study\\data\\booking.csv";

    static {
        customerList = ReadAndWrite.readCustomerCsv("src\\_00_case_study\\data\\customer.csv");
        houseList = ReadAndWrite.readHouseCsv("src\\_00_case_study\\data\\house.csv");
        villaList = ReadAndWrite.readVillaCsv("src\\_00_case_study\\data\\villa.csv");
        roomList = ReadAndWrite.readRoomCsv("src\\_00_case_study\\data\\room.csv");
        facilityIntegerMap = ReadAndWrite.readFacilityCsv("src\\_00_case_study\\data\\facility.csv");
        bookingSet = ReadAndWrite.readBookingCsv(path);
    }

    @Override
    public void display() {
        Set<Booking> bookingSet = ReadAndWrite.readBookingCsv(path);
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("Customer list: ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Input customer Id");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        while (check) {
            for (Customer customer : customerList) {
                if (id == customer.getId()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Not found, please input customer Id again");
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("Facility list: ");
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            System.out.println(map.toString());
        }

        System.out.println("Input facility Id");
        String id = scanner.nextLine();
        while (true) {
            for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
                if (id.equals(map.getKey().getFacilityId())) {
                    facilityIntegerMap.put(map.getKey(), map.getValue() + 1);
                    ReadAndWrite.writeFacilityCsv(facilityIntegerMap, "src\\_00_case_study\\data\\facility.csv");
                    return map.getKey();
                }
            }
            System.out.println("Not found, please input facility id again");
        }
    }

    @Override
    public void addNew() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        String startDate = BookingRegexAndException.inputStartDate();
        String endDate = BookingRegexAndException.inputEndDate(startDate);

        Booking booking = new Booking(id, startDate, endDate, customer.getId(), facility.getFacilityId(), facility.getServiceName());
        bookingSet.add(booking);
        ReadAndWrite.writeBookingCsv(bookingSet, path);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    public Set<Booking> bookingSet() {
        return ReadAndWrite.readBookingCsv(path);
    }
}
