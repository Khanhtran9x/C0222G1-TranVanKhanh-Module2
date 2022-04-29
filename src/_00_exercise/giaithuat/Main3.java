package _00_exercise.giaithuat;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};

        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j] && arr[j] != -1) {
                    int min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }


        System.out.println(Arrays.toString(arr));
    }
}
//    int[] solution(int[] a) {
//        for (int i = 0; i < a.length; i++)
//            for (int j = i + 1; j < a.length; j++)
//                if (a[i] > a[j] && a[j] != -1) {
//                    int m = a[j];
//                    a[j] = a[i];
//                    a[i] = m;
//                }
//        return a;
//    }
