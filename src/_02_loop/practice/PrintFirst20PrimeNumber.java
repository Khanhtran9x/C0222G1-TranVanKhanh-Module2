package _02_loop.practice;

import java.util.Scanner;

public class PrintFirst20PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra");
        int number = scanner.nextInt();
        int count = 0;
        int countPrime = 0;
        int n = 2;
        while (countPrime != number) {
            count = 0;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    count++;
                }
            }
            if (count == 0){
                countPrime++;
                System.out.println(n);
            }
            n++;
        }

    }
}
