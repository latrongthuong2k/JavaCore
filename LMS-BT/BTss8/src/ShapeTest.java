import entity2.Shape;
import entity2.Triangle;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        // toString circle
        System.out.println(shape);
        Triangle triangle = new Triangle(4.5, 6, 9);
        double area = triangle.getArea();
        double perimeter = triangle.getPerimeter();
        System.out.println("Diện tích của tam giác là :" + String.format("%.2f", area));
        System.out.println("Chu vi của tam giác là :" + String.format("%.2f", perimeter));
        // toString triangle
        System.out.println(triangle);

    }
}
