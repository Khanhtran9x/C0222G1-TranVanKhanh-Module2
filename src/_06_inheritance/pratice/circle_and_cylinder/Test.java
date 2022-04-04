package _06_inheritance.pratice.circle_and_cylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0, "blue");
        Cylinder cylinder = new Cylinder(20.0, "red", 10.0);
        System.out.println("Thông tin về hình tròn là: " + circle.toString());
        System.out.println("Diện tích của hình tròn là: " + circle.getArea());
        System.out.println("Thông tin về hình trụ là: " + cylinder.toString());
        System.out.println("Thể tích của hình trụ là: " + cylinder.getVolume());
    }
}
