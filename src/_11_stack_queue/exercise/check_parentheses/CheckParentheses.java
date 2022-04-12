package _11_stack_queue.exercise.check_parentheses;

import java.util.Scanner;
import java.util.Stack;

public class CheckParentheses {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào biểu thức cần kiểm tra");
        String str = scanner.nextLine();
        char left = ' ';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')'){
                if (stack.size() == 0){
                    count++;
                } else {
                    left = stack.pop();
                }
                if (left != '('){
                    count++;
                }
            }
        }
        if (count == 0 & stack.size() == 0){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
