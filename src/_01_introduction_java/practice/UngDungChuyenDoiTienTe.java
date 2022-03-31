package _01_introduction_java.practice;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        final int rate = 23000;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp vào số tiền USD muốn chuyển đổi sang tiền VND");
        int usd = scanner.nextInt();

        System.out.println("Số tiền VND sau khi được chuyển đổi là: " + usd * rate + " VND");
    }
}
