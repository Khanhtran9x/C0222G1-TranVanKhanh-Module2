package _19_string_regex.exercise.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static final String ACCOUNT_REGEX = "^[CAP]\\d{4}[GHIKLM]$";

    public ClassName() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
