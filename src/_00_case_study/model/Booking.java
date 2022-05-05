package _00_case_study.model;

import _00_case_study.service.impl.CustomerServiceImpl;
import _00_case_study.utils.ReadAndWrite;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class Booking {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    private int bookingId;
    private String startDate;
    private String endDate;
    private int customerId;
    private String serviceId;
    private String serviceName;

    public Booking(int bookingId, String startDate, String endDate, int customerId, String serviceId, String serviceName) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public Booking(String[] strArr) {
        this.bookingId = Integer.parseInt(strArr[0]);
        this.startDate = strArr[1];
        this.endDate = strArr[2];
        this.customerId = Integer.parseInt(strArr[3]);
        this.serviceId = strArr[4];
        this.serviceName = strArr[5];
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer(){
        List<Customer> customerList = customerService.readFile("src\\_00_case_study\\data\\customer.csv");
        for (Customer customer: customerList) {
            if (customer.getId() == customerId){
                return customer;
            }
        }
        return null;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return bookingId + ","
                + startDate + ","
                + endDate + ","
                + customerId + ","
                + serviceId + ","
                + serviceName;
    }
    public String getInfo(){
        return "--BOOKING-- \n"
                + "Booking ID: " + bookingId + "\n"
                + "Start date: " + startDate + "\n"
                + "End date: " + endDate + "\n"
                + "Customer ID: " +customerId + "\n"
                + "Service ID: " + serviceId + "\n"
                + "Service name: " + serviceName + "\n";
    }
}
