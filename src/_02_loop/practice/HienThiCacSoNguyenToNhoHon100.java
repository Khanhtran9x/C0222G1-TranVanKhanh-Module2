package _02_loop.practice;

import java.util.Scanner;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        for (int i = 2; i <= 100; i++) {
            count = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    count++;
                }
            }
            if (count == 0){
                System.out.println(i);
            }
        }
    }
}
