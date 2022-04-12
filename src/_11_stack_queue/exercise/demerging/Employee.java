package _11_stack_queue.exercise.demerging;

public class Employee implements Comparable<Employee>{
    private String name;
    private boolean gender = true;
    private int age;

    public Employee() {
    }

    public Employee(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getAge() > o.getAge()){
            return 1;
        } else if(this.getAge() < o.getAge()){
            return -1;
        } else {
            return 0;
        }
    }
}
