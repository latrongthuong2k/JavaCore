import entity1.Cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5.0, "Red", 10.0);
        System.out.println(cylinder);
        System.out.println("Area: " + cylinder.getArea());
        System.out.println("Volume: " + cylinder.getVolume());

        cylinder.setRadius(7.5);
        cylinder.setColor("Blue");
        cylinder.setHeight(15.0);
        System.out.println(cylinder);
        System.out.println("Area: " + cylinder.getArea());
        System.out.println("Volume: " + cylinder.getVolume());
    }
}