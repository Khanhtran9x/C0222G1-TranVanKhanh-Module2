package _11_stack_queue.exercise.check_palindrome_using_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();

        System.out.println("Nhập vào chuỗi cần kiểm tra");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!stack.pop().equals(queue.remove())){
                count++;
            }
        }

        if (count == 0){
            System.out.println("Chuỗi mới nhập vào đối xứng");
        } else {
            System.out.println("Chuỗi mới nhập vào không đối xứng");
        }
    }
}
