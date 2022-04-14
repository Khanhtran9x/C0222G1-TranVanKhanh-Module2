package _11_stack_queue.exercise.reverse_integer_array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseIntegerArray {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        int[] array = {1, 3, 7, 7, 3, 4, 9};
        System.out.println("Mảng ban đầu là: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            myStack.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = myStack.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là: "+Arrays.toString(array));

        Stack<String> myStrStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi cần đảo ngược");
        String string = scanner.nextLine();
        String[] arr = string.split(" ");

        for (int i = 0; i < arr.length; i++) {
            myStrStack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myStrStack.pop();
        }
        String result = String.join(" ", arr);
        System.out.println("Chuỗi sau khi đảo ngược là: "+ result);
    }
}
