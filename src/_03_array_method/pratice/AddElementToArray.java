package _03_array_method.pratice;

import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 9, 7, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%-20s%s", "Mảng ban đầu là: ", "");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println(" ");
        System.out.println("Nhập số cần chèn");
        int insertNumber = scanner.nextInt();
        int insertIndex = -1;
        // Nhập vị trí cần chèn
        do {
            System.out.println("Nhập vị trí cần chèn");
            insertIndex = scanner.nextInt();
        } while (insertIndex <= -1 || insertIndex >= arr.length - 1);
        // Dịch chuyển các phần tử từ vị trí cần chèn ra sau 1 đơn vị
        for (int i = arr.length - 1; i > insertIndex; i--) {
            arr[i] = arr[i-1];
        }
        // Chèn phần tử
        arr[insertIndex] = insertNumber;
        // In ra mảng vừa được chèn thêm
        System.out.printf("%-20s%s", "Mảng sau khi chèn là: ", "");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
