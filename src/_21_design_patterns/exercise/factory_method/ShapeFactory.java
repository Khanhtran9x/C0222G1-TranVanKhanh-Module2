package _21_design_patterns.exercise.factory_method;

public class ShapeFactory {
    public Shape getShape(String type) {
        if ("circle".equals(type)) {
            return new Circle();
        } else if ("square".equals(type)) {
            return new Square();
        } else if ("rectangle".equals(type)){
            return new Rectangle();
        } else {
            return null;
        }
    }
}
