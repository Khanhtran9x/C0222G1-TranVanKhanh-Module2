package _00_case_study.model;

public class Employee extends Person{
    private int level;
    private String position;
    private int salary;

    public Employee(int id,
                    String name,
                    String dateOfBirth,
                    String address,
                    boolean gender,
                    String idCard,
                    String email,
                    int level,
                    String position,
                    int salary) {
        super(id, name, dateOfBirth, address, gender, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee (id=" + this.getId() +
                ", name=" + this.getName() +
                ", age="  + this.getDateOfBirth() +
                ", address=" + this.getAddress() +
                ", gender=" + this.isGender() +
                ", id card=" + this.getIdCard() +
                ", email=" + this.getEmail() +
                ", level=" + level +
                ", position=" + position +
                ", salary=" + salary +
                ')';
    }
}
