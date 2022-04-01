package _04_class_object.practice.stop_watch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] arr = new int[100000];
        stopWatch.start();
        int size = arr.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {

                if (arr[i] > arr[min_idx]) {
                    min_idx = i;
                }
            }

            int temp = arr[step];
            arr[step] = arr[min_idx];
            arr[min_idx] = temp;
        }
        stopWatch.stop();
        System.out.println("Thời gian thực thi thuật toán sắp xếp chọn cho mảng 100000 số là: " + stopWatch.getElapsedTime() + " ms");
    }
}
