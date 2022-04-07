package _11_stack_queue.exercise.count_appearance_times;

import java.util.*;
import java.util.TreeMap;

public class CountAppearanceTimes {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String str = "Tôi đang đi học tôi muốn học xong sớm để đi làm";
        String[] strArr = str.split(" ");
        System.out.println("Chuỗi cần kiểm tra: " + str);
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].toLowerCase();
            if (!map.containsKey(strArr[i])){
                map.put(strArr[i], 1);
            } else {
                map.put(strArr[i], map.get(strArr[i]) + 1);
            }
        }
        System.out.println("Đếm số lần xuất hiện: ");
        for (Map.Entry m: map.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}
