package _19_string_regex.exercise.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static final String ACCOUNT_REGEX = "^[(]\\d{1,2}[)][-][(]\\d{10}[)]$";

    public PhoneNumber() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
