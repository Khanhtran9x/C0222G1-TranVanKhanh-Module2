package _00_case_study.utils;

import java.util.List;

public class CheckId {
    public static boolean checkId(int id, List<String[]> list) {
        for (String[] str : list) {
            if (Integer.parseInt(str[0]) == id) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkId(String id, List<String[]> list) {
        for (String[] str : list) {
            if (str[0].equals(id)) {
                return false;
            }
        }
        return true;
    }
}
