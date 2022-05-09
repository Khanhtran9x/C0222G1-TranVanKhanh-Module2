package _00_exercise.extra_ex_3.model;

public class PayoutBankAccount extends BankAccount{
    private String cardNumber;
    private int totalMoney;

    public PayoutBankAccount(String id,
                             String code,
                             String name,
                             String creationDate,
                             String cardNumber,
                             int totalMoney) {
        super(id, code, name, creationDate);
        this.cardNumber = cardNumber;
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "PayoutBankAccount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
