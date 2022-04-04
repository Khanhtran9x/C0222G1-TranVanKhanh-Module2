package _06_inheritance.pratice.triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = new Shape();
        Triangle triangle = new Triangle();

        System.out.println("Shape vừa tạo có đặc điểm như sau: " + shape.toString());
        System.out.println("Triangle vừa tạo có đặc điểm như sau: " + triangle.toString());
        System.out.println("Nhập vào kích thước 3 cạnh mới cho triangle");
        System.out.println("Cạnh thứ nhất: ");
        double side1 = scanner.nextDouble();
        triangle.setSide1(side1);
        System.out.println("Cạnh thứ hai: ");
        double side2 = scanner.nextDouble();
        triangle.setSide2(side2);
        System.out.println("Cạnh thứ ba: ");
        double side3 = scanner.nextDouble();
        triangle.setSide3(side3);
        System.out.println("Triangle mới có các thông số đặc điểm như sau: " + triangle.toString());
    }
}
