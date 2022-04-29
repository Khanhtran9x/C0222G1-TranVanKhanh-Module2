package _00_case_study.service.impl;

import _00_case_study.model.*;
import _00_case_study.service.BookingService;
import _00_case_study.utils.BookingComparator;
import _00_case_study.utils.ReadAndWrite;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList;
    static List<Villa> villaList = new ArrayList<>();
    static List<House> houseList;
    static Set<Booking> bookingSet;
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static String path = "src\\_00_case_study\\data\\booking.csv";

    static{
        customerList = ReadAndWrite.readCustomerCsv("src\\_00_case_study\\data\\customer.csv");
        houseList = ReadAndWrite.readHouseCsv("src\\_00_case_study\\data\\house.csv");
        bookingSet = ReadAndWrite.readBookingCsv(path);
        for (House house: houseList) {
            facilityIntegerMap.put(house, 0);
        }
    }

    @Override
    public void display() {
        Set<Booking> bookingSet = ReadAndWrite.readBookingCsv(path);
        for (Booking booking: bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("Customer list: ");
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Input customer Id");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        while (check){
            for (Customer customer: customerList) {
                if (id == customer.getId()){
                    check = false;
                    return customer;
                }
            }
            if (check){
                System.out.println("Not found, please input customer Id again");
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("Facility list: ");
        for (Map.Entry<Facility, Integer> map: facilityIntegerMap.entrySet()) {
            System.out.println(map.getKey().toString());
        }

        System.out.println("Input facility Id");
        boolean check = true;
        String id = scanner.nextLine();
        while (check){
            for (Map.Entry<Facility, Integer> map: facilityIntegerMap.entrySet()) {
                if (id.equals(map.getKey().getFacilityId())){
                    check = false;
                    return map.getKey();
                }
            }
            if (check){
                System.out.println("Not found, please input facility id again");
            }
        }
        return null;
    }

    @Override
    public void addNew() {
        int id = 1;
        if (!bookingSet.isEmpty()){
            id = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

        System.out.println("Input the start date");
        String startDate = scanner.nextLine();

        System.out.println("Input the end date");
        String endDate = scanner.nextLine();

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

    public Set<Booking> bookingSet(){
        return ReadAndWrite.readBookingCsv(path);
    }
}
