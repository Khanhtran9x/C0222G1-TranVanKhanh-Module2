package _00_exercise.extra_ex_3.model;

public class SavingBankAccount extends BankAccount{
    private int amount;
    private String depositDate;
    private double interestRate;
    private int term;

    public SavingBankAccount(String id,
                             String code,
                             String name,
                             String createDate,
                             int amount,
                             String depositDate,
                             double interestRate,
                             int term) {
        super(id, code, name, createDate);
        this.amount = amount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "SavingBankAccount{" +
                "amount=" + amount +
                ", depositDate='" + depositDate + '\'' +
                ", interestRate=" + interestRate +
                ", term=" + term +
                '}';
    }
}
