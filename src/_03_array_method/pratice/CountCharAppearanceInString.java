package _03_array_method.pratice;

import java.util.Scanner;

public class CountCharAppearanceInString {
    public static void main(String[] args) {
        String str = "international";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào kí tự cần kiểm tra số lần xuất hiện");
        char input = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == input) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của kí tự vừa nhập vào trong chuỗi là: " + count);
    }
}
