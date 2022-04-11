package _00_exercise.student;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        int i = -1;
        Scanner scanner = new Scanner(System.in);
        Person[] persons = new Person[50];
        int choice = -1;
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("0. Hiển thị danh sách");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm giáo viên");
            System.out.println("3. Xóa");
            System.out.println("4. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    display(persons);
                    break;
                case 1:
                    i++;
                    addStudent(persons, i);
                    break;
                case 2:
                    i++;
                    addTeacher(persons, i);
                    break;
                case 3:
                    remove(persons);
                    System.out.println("Danh sách sau khi xóa là: ");
                    display(persons);
                    break;
            }
        }
    }

    public static void display(Person[] persons) {
        int count = 0;
        for (Person person : persons) {
            if (person != null) {
                count++;
                if (person instanceof Student) {
                    Student student = (Student) person;
                    System.out.println(student.toString());
                }
                if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    System.out.println(teacher.toString());
                }

            }
        }
        if (count == 0) {
            System.out.println("Mảng rỗng, hãy thêm mới!!");
        }
    }

    public static void addStudent(Person[] persons, int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên sinh viên muốn thêm");
        String name = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên muốn thêm");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính sinh viên muốn thêm");
        String gender = scanner.nextLine();
        System.out.println("Nhập vào điểm của sinh viên muốn thêm");
        int point = Integer.parseInt(scanner.nextLine());
        persons[i] = new Student(name, age, gender, point);
        System.out.println("Đã thêm thành công");
    }

    public static void addTeacher(Person[] persons, int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên giáo viên muốn thêm");
        String name = scanner.nextLine();
        System.out.println("Nhập vào tuổi giáo viên muốn thêm");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính giáo viên muốn thêm");
        String gender = scanner.nextLine();
        System.out.println("Nhập vào lương của giáo viên muốn thêm");
        int salary = Integer.parseInt(scanner.nextLine());
        persons[i] = new Teacher(name, age, gender, salary);
        System.out.println("Đã thêm thành công");
    }
    public static void remove(Person[] persons){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên muốn xóa");
        String deleteName = scanner.nextLine();
        for (int j = 0; j < persons.length; j++) {
            if (persons[j] != null && persons[j].getName().equals(deleteName)) {
                persons[j] = null;
            }
        }
    }
}
