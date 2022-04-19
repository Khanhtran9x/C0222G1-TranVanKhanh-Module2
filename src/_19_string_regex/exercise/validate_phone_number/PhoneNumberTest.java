package _19_string_regex.exercise.validate_phone_number;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    public static final String[] validPhoneNumber = new String[] { "(84)-(0978489648)", "(85)-(0915224942)" };
    public static final String[] invalidPhoneNumber = new String[] { "(84)-0978489648)", "(a8)-(22222222)" };

    public static void main(String args[]) {
        phoneNumber = new PhoneNumber();
        for (String item : validPhoneNumber) {
            boolean isvalid = phoneNumber.validate(item);
            System.out.println("Class name is " + item +" is valid: "+ isvalid);
        }
        for (String item : invalidPhoneNumber) {
            boolean isvalid = phoneNumber.validate(item);
            System.out.println("Class name is " + item +" is valid: "+ isvalid);
        }
    }
}
