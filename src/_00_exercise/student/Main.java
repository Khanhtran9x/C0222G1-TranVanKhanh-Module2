package _00_exercise.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[50];
        int choice = -1;
        while (choice != 3) {
            System.out.println("Menu Sinh Viên");
            System.out.println("0. Hiển thị danh sách sinh viên");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên ");
            System.out.println("3. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    int count = 0;
                    for (Student student : students) {
                        if (student != null) {
                            count++;
                            System.out.println(student);
                        }
                    }
                    if (count == 0){
                        System.out.println("Mảng sinh viên rỗng, hãy thêm mới!!");
                    }
                    break;
                case 1:
                    System.out.println("Nhập vào tên sinh viên muốn thêm");
                    String name = scanner.nextLine();
                    System.out.println("Nhập vào tuổi sinh viên muốn thêm");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập vào địa chỉ sinh viên muốn thêm");
                    String address = scanner.nextLine();
                    System.out.println("Nhập vào điểm của sinh viên muốn thêm");
                    double point = Double.parseDouble(scanner.nextLine());
                    students[i++] = new Student(name, age, address, point);
                    System.out.println("Danh sách sinh viên sau khi thêm là: ");
                    for (Student student : students) {
                        if (student != null) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên sinh viên muốn xóa");
                    String deleteName = scanner.nextLine();
                    for (int j = 0; j < students.length; j++) {
                        if (students[j] != null && students[j].getName().equals(deleteName)) {
                            students[j] = null;
                        }
                    }
                    System.out.println("Mảng sau khi xóa là");
                    int count2 = 0;
                    for (Student student : students) {
                        if (student != null) {
                            count2++;
                            System.out.println(student);
                        }
                    }
                    if (count2 == 0){
                        System.out.println("Mảng sinh viên rỗng, hãy thêm mới!!");
                    }
                    break;
            }
        }
    }
}
