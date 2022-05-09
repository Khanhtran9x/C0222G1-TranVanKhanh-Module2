package _00_exercise.extra_ex_2.ultils;

import java.util.List;

public class CheckCode {
    public static boolean checkCode(String code, List<String[]> list) {
        for (String[] str : list) {
            if (str[0].equals(code)) {
                return true;
            }
        }
        return false;
    }
}
