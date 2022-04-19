package _15_exception_and_debug.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào độ dài 3 cạnh của hình tam giác");

        try {
            System.out.println("Nhập vào độ dài cạnh thứ nhất");
            double a = scanner.nextDouble();
            System.out.println("Nhập vào độ dài cạnh thứ hai");
            double b = scanner.nextDouble();
            System.out.println("Nhập vào độ dài cạnh thứ ba");
            double c = scanner.nextDouble();
            checkTriangleSide(a, b, c);

        } catch (InputMismatchException e) {
            System.err.println("Nhập sai kiểu dữ liệu, xin mời nhập lại");
        } catch (IllegalTriangleException e){
            System.err.println(e.getMessage());
        }

    }
    public static void checkTriangleSide(double a, double b, double c) throws IllegalTriangleException{
        if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
            System.out.println("Ba cạnh vừa nhập vào tạo nên được một hình tam giác");
        } else {
            throw new IllegalTriangleException("Ba cạnh vừa nhập vào không thể tạo thành một tam giác");
        }
    }
}
