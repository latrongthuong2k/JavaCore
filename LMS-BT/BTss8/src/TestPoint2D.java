import entity4.Point2D;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(2.5f, 3.8f);
        System.out.println("Point 1: " + point1);

        Point2D point2 = new Point2D();
        System.out.println("Point 2: " + point2);

        point2.setX(5.2f);
        point2.setY(6.7f);
        System.out.println("Point 2 after setting X and Y: " + point2);

        float[] xy = point1.getXY();
        System.out.println("Coordinates of Point 1: (" + xy[0] + "," + xy[1] + ")");
    }
}
