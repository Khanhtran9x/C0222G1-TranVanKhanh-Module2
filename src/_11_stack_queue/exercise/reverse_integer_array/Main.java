package _11_stack_queue.exercise.reverse_integer_array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack();
        int[] array = {1, 3, 7, 7, 3, 4, 9};
        System.out.println("Mảng ban đầu là: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            myStack.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = myStack.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là: "+Arrays.toString(array));

        MyStack<String> myStrStack = new MyStack();
        String[] arr = {"one", "two", "three", "four", "five"};
        System.out.println("Mảng ban đầu là: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            myStrStack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myStrStack.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là: "+Arrays.toString(arr));
    }
}
