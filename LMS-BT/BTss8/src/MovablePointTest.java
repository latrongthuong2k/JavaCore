import entity3.Point;
import entity3.MovablePoint;

public class MovablePointTest {
    public static void main(String[] args) {

        Point point = new Point(2.5f, 3.8f);
        System.out.println("Point: " + point);

        MovablePoint movablePoint = new MovablePoint(1.2f, 0.5f);
        System.out.println("Movable Point: " + movablePoint);

        movablePoint.move();
        System.out.println("After moving: " + movablePoint);
    }
}