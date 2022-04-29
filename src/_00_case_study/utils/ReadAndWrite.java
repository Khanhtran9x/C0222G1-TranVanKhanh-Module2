package _00_case_study.utils;


import _00_case_study.model.*;

import java.io.*;
import java.util.*;

public class ReadAndWrite {
    public static void writeCustomerCsv(List<Customer> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("ID,");
            fileWriter.append("NAME,");
            fileWriter.append("DATE OF BIRTH,");
            fileWriter.append("ADDRESS,");
            fileWriter.append("GENDER,");
            fileWriter.append("ID CARD,");
            fileWriter.append("EMAIL,");
            fileWriter.append("TYPE" + "\n");
            for (Customer customer : list) {
                fileWriter.append(customer.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomerCsv(String path) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                customer = new Customer(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        arr[4], arr[5], arr[6], arr[7]);
                customerList.add(customer);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void writeEmployeeCsv(List<Employee> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("ID,");
            fileWriter.append("NAME,");
            fileWriter.append("DATE OF BIRTH,");
            fileWriter.append("ADDRESS,");
            fileWriter.append("GENDER,");
            fileWriter.append("ID CARD,");
            fileWriter.append("EMAIL,");
            fileWriter.append("LEVEL,");
            fileWriter.append("POSITION,");
            fileWriter.append("SALARY" + "\n");
            for (Employee employee : list) {
                fileWriter.append(employee.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeCsv(String path) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                employee = new Employee(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        arr[4], arr[5], arr[6], Integer.parseInt(arr[7]),
                        arr[8], Integer.parseInt(arr[9]));
                employeeList.add(employee);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static void writeHouseCsv(List<House> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("FACILITY ID,");
            fileWriter.append("SERVICE NAME,");
            fileWriter.append("USE AREA,");
            fileWriter.append("RENTAL PRICE,");
            fileWriter.append("MAX RENTAL PEOPLE,");
            fileWriter.append("RENTAL STYLE,");
            fileWriter.append("HOUSE STANDARD,");
            fileWriter.append("FLOOR" + "\n");
            for (House house : list) {
                fileWriter.append(house.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readHouseCsv(String path) {
        List<House> houseList = new LinkedList<>();
        House house;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                house = new House(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]),
                        Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]));
                houseList.add(house);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return houseList;
    }

    public static void writeBookingCsv(Set<Booking> set, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("BOOKING ID,");
            fileWriter.append("START DATE,");
            fileWriter.append("END DATE,");
            fileWriter.append("CUSTOMER ID,");
            fileWriter.append("SERVICE ID,");
            fileWriter.append("SERVICE NAME" + "\n");
            for (Booking booking : set) {
                fileWriter.append(booking.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Booking> readBookingCsv(String path) {
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        Booking booking;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                booking = new Booking(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5]);
                bookingSet.add(booking);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingSet;
    }

    public static void writeContractCsv(List<Contract> list, String path) {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.append("CONTRACT ID,");
            fileWriter.append("BOOKING ID,");
            fileWriter.append("DEPOSIT,");
            fileWriter.append("TOTAL PAY,");
            fileWriter.append("CUSTOMER ID" + "\n");
            for (Contract contract : list) {
                fileWriter.append(contract.toStringToWrite() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contract> readContractCsv(String path) {
        List<Contract> contractList = new LinkedList<>();
        Contract contract;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                contract = new Contract(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
                contractList.add(contract);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  contractList;
    }
}
