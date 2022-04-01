package _03_array_method.pratice;

import java.lang.reflect.Array;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int size1, size2, size3;
        int[] array1, array2, array3;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào độ dài mảng thứ nhất:");
        size1 = scanner.nextInt();
        array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.print("Giá trị của phần tử thứ " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }
        System.out.printf("%-20s%s", "Mảng vừa nhập vào là: ", "");
        for (int i : array1) {
            System.out.print(i + "\t");
        }
        System.out.println(" ");
        System.out.print("Nhập vào độ dài mảng thứ hai:");
        size2 = scanner.nextInt();
        array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.print("Giá trị của phần tử thứ " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }
        System.out.printf("%-50s%s", "Mảng vừa nhập vào là: ", "");
        for (int i : array2) {
            System.out.print(i + "\t");
        }
        System.out.println(" ");
        size3 = size1 + size2;
        array3 = new int[size3];
        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }
        for (int i = 0; i < size2; i++) {
            array3[i+size1] = array2[i];
        }
        System.out.printf("%-20s%s", "Mảng vừa được gộp là: ", "");
        for (int i : array3) {
            System.out.print(i + "\t");
        }


    }
}
