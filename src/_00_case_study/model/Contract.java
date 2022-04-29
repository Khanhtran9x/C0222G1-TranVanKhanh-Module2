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
        return "Contract{" +
                "contractId=" + contractId +
                ", bookingId=" + bookingId +
                ", deposit=" + deposit +
                ", totalPay=" + totalPay +
                ", customerId=" + customerId +
                '}';
    }

    public String toStringToWrite(){
        return contractId + "," + bookingId + "," + deposit + "," + totalPay + "," + customerId;
    }
}
