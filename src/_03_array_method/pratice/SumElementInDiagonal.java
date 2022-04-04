package _03_array_method.pratice;

import java.util.Scanner;

public class SumElementInDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào kích thước của ma trận vuông");
        int num = scanner.nextInt();
        double[][] array = new double[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print("Giá trị của phần tử thứ " + i + " " + j + ": ");
                array[i][j] = scanner.nextDouble();
            }
        }
      sumElementInDiagonal(array, num);
    }
    public static void sumElementInDiagonal(double[][] array, int num){
        double sum = 0;
        for (int i = 0; i < num; i++) {
            sum += array[i][i];
        }
        System.out.println("Tổng của các phần tử ở đường chéo chính là: " + sum);
    }
}
