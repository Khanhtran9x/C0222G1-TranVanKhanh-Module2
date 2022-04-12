package _11_stack_queue.exercise.convert_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số cần chuyển đổi sang hệ nhị phân");
        int decimalNumber = scanner.nextInt();

        while(decimalNumber > 0){
            stack.push(decimalNumber%2);
            decimalNumber = decimalNumber/2;
        }

        System.out.println("Kết quả sau khi chuyển sang hệ nhị phân là");
        while (stack.size() > 0){
            System.out.print(stack.pop());
        }
    }

}
