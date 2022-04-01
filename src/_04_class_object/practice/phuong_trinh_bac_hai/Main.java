package _04_class_object.practice.phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Giải phương trình bậc 2 có dạng ax2 + bx + c = 0");
        System.out.println("Nhập vào giá trị a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào giá trị b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhạp vào giá trị c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadratic = new QuadraticEquation(a, b, c);
        double delta = quadratic.getDiscriminant();
        if (delta > 0){
            System.out.println("Phương trình có 2 nghiệm phân biệt là: " + quadratic.getRoot1() + " và " + quadratic.getRoot2());
        } else if (delta == 0){
            System.out.println("Phương trình có nghiệm kép là: " + quadratic.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
