package _07_abstract_class_and_interface.practice.interface_colorable_for_shapes;


public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0, "red", true);
        shapes[1] = new Square(4.0, "blue", true);
        shapes[2] = new Rectangle(6.0, 5.0, "green", true);
        System.out.println("Shapes before coloring");
        for (Shape shape: shapes) {
            System.out.println(shape);
        }
        System.out.println("Shapes after coloring");
        for (Shape shape: shapes) {
            System.out.println(shape);
            shape.howToColor();
        }
    }
}
