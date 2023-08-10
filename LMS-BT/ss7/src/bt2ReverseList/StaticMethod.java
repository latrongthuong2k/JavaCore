package bt2ReverseList;

class StaticMethod {
    static final double PI = 3.14;

    static double calCircleArea(double R) {
        return PI * R * R;
    }

    static double calRectangleArea(double width, double height) {
        return width * height;
    }

    static double calTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

