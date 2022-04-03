package _03_array_method.pratice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FindMaxElementIn2dArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số cột của ma trận");
        int col = scanner.nextInt();
        System.out.println("Nhập vào số hàng của ma trận");
        int row = scanner.nextInt();
        double[][] array = new double[row][col];
        double max = array[0][0];
        String index = 0 + " " + 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Giá trị của phần tử thứ " + i + " " + j + ": ");
                array[i][j] = scanner.nextDouble();
                if (array[i][j] > max) {
                    max = array[i][j];
                    index = i + " " + j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng vừa nhập vào là: " + max + " , nằm ở vị trí: " + index);
    }
}
