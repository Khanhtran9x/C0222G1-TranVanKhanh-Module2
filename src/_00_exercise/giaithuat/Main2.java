package _00_exercise.giaithuat;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        String arg1 = "CodegymDaNang";
        String arg2 = arg1.toLowerCase();
        String result = "";
        int num;
        for (int i = 0; i < arg1.length(); i++) {
            num = (int) arg1.charAt(i);
            if (num < 91){
                result += " " + arg2.charAt(i);
            } else {
                result += arg2.charAt(i);
            }
        }
        System.out.println(result.trim());



//        String str1 = "CodegymDaNang";
//        String str2 = str1.toLowerCase();
//        Stack<String> stringList = new Stack<>();
//        for (int i = str2.length() - 1; i >= 1; i--) {
//            if (str2.charAt(i) != str1.charAt(i)){
//                stringList.add(str1.substring(i));
//                str1 = str1.substring(0, i);
//                str2 = str2.substring(0, i);
//            }
//        }
//        stringList.add(str1);
//        String[] result = new String[stringList.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = stringList.pop();
//        }
//        String resultStr = String.join(" ", result);
//        System.out.println(resultStr.toLowerCase());
    }
}
