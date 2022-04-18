package _13_search_algorithm.exercise.binary_algorithm_using_recursion;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[5];
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Nhập vào phần tử thứ " + i + " của mảng");
            intArray[i] = scanner.nextInt();
        }
        Arrays.sort(intArray);
        System.out.println("Mảng ban đầu là: ");
        System.out.println(Arrays.toString(intArray));

        System.out.println("Nhập vào phần tử cần tìm kiếm trong mảng");
        int value = scanner.nextInt();

        int index = binarySearch(intArray, 0, intArray.length - 1, value);
        System.out.println("Phần tử vừa nhập vào nằm ở vị trí thứ: " + index);

    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = left + (right - left) / 2;
            if (array[middle] == value) {
                return middle;
            }
            if (array[middle] > value){
                return binarySearch(array, left, middle - 1, value);
            } else {
                return binarySearch(array, middle + 1, right, value);
            }
        }
        return -1;
    }

}
