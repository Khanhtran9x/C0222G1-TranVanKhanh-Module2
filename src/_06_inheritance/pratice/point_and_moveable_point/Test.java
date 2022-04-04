package _06_inheritance.pratice.point_and_moveable_point;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(4.5f, 3.5f);
        MoveablePoint moveablePoint = new MoveablePoint(4.5f, 3.4f, 3.1f, 5.6f);

        point.setXY(5.5f, 6.5f);
        System.out.println("Toạ độ của point là: " + point.getXY());

        moveablePoint.setXY(5.5f, 7.5f);
        System.out.println("Tọa độ của moveablePoint là: " + moveablePoint.getXY());
        moveablePoint.setSpeed(3.5f, 2.5f);
        System.out.println("Tốc độ của moveablePoint là: " + moveablePoint.getSpeed());
        System.out.println("Di chuyển moveablePoint với tốc độ có sẵn, tọa độ của moveablePoint sau khi di chuyển là: " + moveablePoint.move());
    }
}
