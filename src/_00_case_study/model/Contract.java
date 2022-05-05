package _00_case_study.model;

public class Contract {
    private int contractId;
    private int bookingId;
    private int deposit;
    private int totalPay;
    private int customerId;

    public Contract(int contractId, int bookingId, int deposit, int totalPay ,int customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.customerId = customerId;
    }

    public Contract(String[] strArr) {
        this.contractId = Integer.parseInt(strArr[0]);
        this.bookingId = Integer.parseInt(strArr[1]);
        this.deposit = Integer.parseInt(strArr[2]);
        this.totalPay = Integer.parseInt(strArr[3]);
        this.customerId = Integer.parseInt(strArr[4]);
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return contractId + ","
                + bookingId + ","
                + deposit + ","
                + totalPay + ","
                + customerId;
    }

    public String getInfo(){
        return  "--CONTRACT-- \n"
                + "Contract Id: " + contractId + "\n"
                + "Booking Id: " + bookingId + "\n"
                + "Deposit Id: " + deposit + "\n"
                + "Total pay: " + totalPay + "\n"
                + "Contract Id: " + customerId + "\n";
    }
}
