package _03_array_method.pratice;

import java.util.Scanner;

public class SumElementInColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số cột của mảng 2 chiều");
        int col = scanner.nextInt();
        System.out.println("Nhập vào số hàng của mảng 2 chiều");
        int row = scanner.nextInt();
        double[][] array = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Giá trị của phần tử thứ " + i + " " + j + ": ");
                array[i][j] = scanner.nextDouble();
            }
        }
        sumElementInColumn(array, row, col);
    }

    public static void sumElementInColumn(double[][] array, int row, int col) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        System.out.println("Nhập vào cột cần tính tổng: ");
        int inputCol = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == inputCol) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Tổng của các giá trị ở cột " + inputCol + " là " + sum);
    }
}
