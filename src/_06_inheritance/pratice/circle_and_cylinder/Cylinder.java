package _06_inheritance.pratice.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "radius=" + getRadius() + ", color=" + getColor() +
                ", height=" + height +
                '}';
    }
}
