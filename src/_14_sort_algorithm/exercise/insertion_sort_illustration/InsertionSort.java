package _14_sort_algorithm.exercise.insertion_sort_illustration;

import java.util.Arrays;

public class InsertionSort {
    static int[] list = {1, 5, 4, 7, 8, 6};

    public static void main(String[] args) {
        System.out.println("Mảng ban đầu chưa sắp xếp là: ");
        System.out.println(Arrays.toString(list));
        System.out.println("Mảng sau khi sắp xếp theo từng bước là: ");
        insertionSort(list);
        System.out.println("Kết quả của mảng cuối cùng là");
        System.out.println(Arrays.toString(list));
    }

    public static void insertionSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
            System.out.println(Arrays.toString(list));
        }
    }
}
