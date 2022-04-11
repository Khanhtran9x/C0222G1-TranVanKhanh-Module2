package _00_exercise.student;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, int age, String gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" + "name=" + super.getName()
                + ", age=" + super.getAge()
                + ", gender=" + super.getGender()
                + "salary=" + salary +
                '}';
    }
}
