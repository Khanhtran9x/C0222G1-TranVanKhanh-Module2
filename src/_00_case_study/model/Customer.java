package _00_case_study.model;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String type;

    public Customer(int id, String name, String dateOfBirth, String address, boolean gender, String idCard, String email, String type) {
        super(id, name, dateOfBirth, address, gender, idCard, email);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer (id=" + this.getId() +
                ", name=" + this.getName() +
                ", age="  + this.getDateOfBirth() +
                ", address=" + this.getAddress() +
                ", gender=" + this.isGender() +
                ", id card=" + this.getIdCard() +
                ", email=" + this.getEmail() +
                ", type=" + type +
                ')';
    }

    @Override
    public String toStringToWrite() {
        return this.getId() + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getAddress() +
                "," + this.isGender() + "," + this.getIdCard() + "," + this.getEmail() + "," + this.type;
    }

}
