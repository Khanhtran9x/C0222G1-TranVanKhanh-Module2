package _00_case_study.model;

import _00_case_study.utils.ReadAndWrite;

import java.util.List;

public class Booking {
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
        List<Customer> customerList = ReadAndWrite.readCustomerCsv("src\\_00_case_study\\data\\customer.csv");
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
        return "Booking{" +
                "bookingId=" + bookingId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerId=" + customerId +
                ", serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
    public String toStringToWrite(){
        return bookingId + "," + startDate + "," + endDate + "," + customerId + "," + serviceId + "," + serviceName;
    }
}
