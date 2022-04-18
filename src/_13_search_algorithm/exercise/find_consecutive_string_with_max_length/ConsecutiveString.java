package _13_search_algorithm.exercise.find_consecutive_string_with_max_length;

import java.util.LinkedList;
import java.util.Scanner;

public class ConsecutiveString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> maxString = new LinkedList<>();
        LinkedList<Character> listString = new LinkedList<>();

        System.out.print("Nhập chuỗi cần tìm: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (listString.size() > 1){
                if (string.charAt(i) <= listString.getLast() && listString.contains(string.charAt(i))){
                    listString.clear();
                }
            }
            listString.add(string.charAt(i));
            if (maxString.size() < listString.size()){
                maxString.clear();
                maxString.addAll(listString);
            }
        }
        for (Character character : maxString) {
            System.out.print(character);
        }

    }

}
