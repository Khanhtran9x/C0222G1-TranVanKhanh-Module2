package _05_access_modifier_static.pratice.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0);
        System.out.println("Hình tròn có bán kính là: " + circle.getRadius());
        System.out.println("Hình tròn có diện tích là: "+ circle.getArea());
    }
}
