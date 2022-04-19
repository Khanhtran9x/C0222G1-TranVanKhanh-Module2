package _19_string_regex.exercise.validate_class_name;

public class ClassNameTest {
    private static ClassName className;
    public static final String[] validClassName = new String[] { "C0318G", "A0318G", "C0318M" };
    public static final String[] invalidClassName = new String[] { "M03A8G", "P0323A", "P0323_P" };

    public static void main(String args[]) {
        className = new ClassName();
        for (String item : validClassName) {
            boolean isvalid = className.validate(item);
            System.out.println("Class name is " + item +" is valid: "+ isvalid);
        }
        for (String item : invalidClassName) {
            boolean isvalid = className.validate(item);
            System.out.println("Class name is " + item +" is valid: "+ isvalid);
        }
    }
}
