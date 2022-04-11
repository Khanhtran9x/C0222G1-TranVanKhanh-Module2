package _00_exercise.student;

public class Student extends Person {
    private int point;

    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Student(String name, int age, String gender, int point) {
        super(name, age, gender);
        this.point = point;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + super.getName()
                + ", age=" + super.getAge()
                + ", gender=" + super.getGender()
                + ", point=" + point +
                '}';
    }
}
