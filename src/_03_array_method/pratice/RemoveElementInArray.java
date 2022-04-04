package _03_array_method.pratice;

import java.util.Scanner;

public class RemoveElementInArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 9, 7};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mảng ban đầu là: ");
        for (int ele : arr) {
            System.out.print(ele + "\t");
        }
        System.out.println("");
        System.out.println("Nhập phần tử cần xóa trong mảng: ");
        int input = scanner.nextInt();
        removeElement(arr, input);

    }

    public static void removeElement(int[] arr, int input) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == input) {
                count++;
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                System.out.print("Mảng sau khi xóa phần tử là: ");
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k] + "\t");
                }
                break;
            }
        }

        if (count == 0) {
            System.out.println("Phần tử mới nhập vào không thuộc mảng");
        }
    }
}
