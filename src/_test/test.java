package _test;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = {7, 8, 9, 10, 11};
        int length = array1.length + array2.length;
        int[] result = new int[length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];


        }
        for (int j = 0; j < array2.length; j++) {
            result[j + array1.length] = array2[j];

        }
        System.out.println(Arrays.toString(result));
    }
}
