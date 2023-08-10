import entity4.Point3D;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D1 = new Point3D(2.5f, 3.8f, 1.0f);
        System.out.println("Point 3D 1: " + point3D1);

        Point3D point3D2 = new Point3D();
        System.out.println("Point 3D 2: " + point3D2);

        point3D2.setXYZ(5.2f, 6.7f, 2.0f);
        System.out.println("Point 3D 2 after setting X, Y, and Z: " + point3D2);

        float[] xyz = point3D1.getXYZ();
        System.out.println("Coordinates of Point 3D 1: (" + xyz[0] + "," + xyz[1] + "," + xyz[2] + ")");
    }
}