package _07_abstract_class_and_interface.practice.interface_resizeable_for_shapes;

public class Square extends Shape implements Resizeable {
    private double side;
    public Square() {
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea(){
        return this.getSide() * this.getSide();
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", area="
                + this.getArea();
    }

    @Override
    public void resize(double percent) {
        this.setSide(this.getSide() + this.getSide() * percent / 100);
    }
}
