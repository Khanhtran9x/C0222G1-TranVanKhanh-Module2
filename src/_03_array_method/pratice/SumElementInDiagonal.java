package _03_array_method.pratice;

import java.util.Scanner;

public class SumElementInDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào kích thước của ma trận vuông");
        int size = scanner.nextInt();
        double[][] array = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Giá trị của phần tử thứ " + i + " " + j + ": ");
                array[i][j] = scanner.nextDouble();
            }
        }
      sumElementInDiagonal(array, size);
    }
    public static void sumElementInDiagonal(double[][] array, int size){
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i][i];
        }
        System.out.println("Tổng của các phần tử ở đường chéo chính là: " + sum);
    }
}
