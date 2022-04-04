package _05_access_modifier_static.pratice.build_class;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("JohnSena");
        student.setClasses("C03");
        System.out.println("Tên sinh viên là: " + student.getName());
    }
}
