package _06_inheritance.pratice.point2d_point3d;

public class Test {
    public static void main(String[] args) {
        Point2D point2d = new Point2D(3.0f, 5.0f);
        Point3D point3d = new Point3D(5.0f, 4.5f, 3.4f);

        point2d.setXY(4.0f, 6.0f);
        System.out.println(point2d.toString());

        point3d.setXYZ(3.5f, 5.7f, 4.3f);
        System.out.println(point3d.toString());

    }
}
