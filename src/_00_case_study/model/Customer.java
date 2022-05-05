package _00_case_study.model;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String type;

    public Customer(int id,
                    String name,
                    String dateOfBirth,
                    String address,
                    String gender,
                    String idCard,
                    String email,
                    String type) {
        super(id, name, dateOfBirth, address, gender, idCard, email);
        this.type = type;
    }

    public Customer(String[] array){
        super(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6]);
        this.type = array[7];
    }

    @Override
    public String toString() {
        return this.getId() + ","
                + this.getName() + ","
                + this.getDateOfBirth() + ","
                + this.getAddress() + ","
                + this.getGender() + ","
                + this.getIdCard() + ","
                + this.getEmail() + ","
                + this.type;
    }

    @Override
    public String getInfo() {
        return "--CUSTOMER-- \n"
                + "ID: " + this.getId() + "\n"
                + "Name: " + this.getName() + "\n"
                + "Date of birth: " + this.getDateOfBirth() + "\n"
                + "Address: " + this.getAddress() + "\n"
                + "Gender: " + this.getGender() + "\n"
                + "ID card: " + this.getIdCard() + "\n"
                + "Email: " + this.getEmail() + "\n"
                + "Type: " + this.type + "\n";
    }
}
