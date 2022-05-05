package _00_case_study.model;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private String level;
    private String position;
    private int salary;

    public Employee(int id,
                    String name,
                    String dateOfBirth,
                    String address,
                    String gender,
                    String idCard,
                    String email,
                    String level,
                    String position,
                    int salary) {
        super(id, name, dateOfBirth, address, gender, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String[] array) {
        super(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6]);
        this.level = array[7];
        this.position = array[8];
        this.salary = Integer.parseInt(array[9]);
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
                + this.level + ","
                + this.position + ","
                + this.salary;
    }

    @Override
    public String getInfo() {
        return "--EMPLOYEE-- \n"
                + "ID: " + this.getId() + "\n"
                + "Name: " + this.getName() + "\n"
                + "Date of birth: " + this.getDateOfBirth() + "\n"
                + "Address: " + this.getAddress() + "\n"
                + "Gender: " + this.getGender() + "\n"
                + "ID card: " + this.getIdCard() + "\n"
                + "Email: " + this.getEmail() + "\n"
                + "Level: " + this.level + "\n"
                + "Position: " + this.position + "\n"
                + "Salary: " + this.salary + "\n";
    }
}
