package bt2ReverseList;

public class Main {
    public static void main(String[] args) {
        // Hình tròn có bán kính lần lượt là 3.5 và 6
        double circleRadius1 = 3.5;
        double circleRadius2 = 6;
        double circleArea1 = StaticMethod.calCircleArea(circleRadius1);
        double circleArea2 = StaticMethod.calCircleArea(circleRadius2);

        System.out.println("Diện tích hình tròn với bán kính 3.5 là: " + circleArea1);
        System.out.println("Diện tích hình tròn với bán kính 6 là: " + circleArea2);

        // Hình tam giác có các cạnh là (3, 4, 5) và (4.5, 7, 6)
        double triangleSide1a = 3;
        double triangleSide1b = 4;
        double triangleSide1c = 5;
        double triangleArea1 = StaticMethod.calTriangleArea(triangleSide1a, triangleSide1b, triangleSide1c);

        double triangleSide2a = 4.5;
        double triangleSide2b = 7;
        double triangleSide2c = 6;
        double triangleArea2 = StaticMethod.calTriangleArea(triangleSide2a, triangleSide2b, triangleSide2c);

        System.out.println("Diện tích tam giác với các cạnh (3, 4, 5) là: " + triangleArea1);
        System.out.println("Diện tích tam giác với các cạnh (4.5, 7, 6) là: " + triangleArea2);

        // Hình chữ nhật có kích thước (2.5, 6) và (4, 7)
        double rectangleWidth1 = 2.5;
        double rectangleHeight1 = 6;
        double rectangleArea1 = StaticMethod.calRectangleArea(rectangleWidth1, rectangleHeight1);

        double rectangleWidth2 = 4;
        double rectangleHeight2 = 7;
        double rectangleArea2 = StaticMethod.calRectangleArea(rectangleWidth2, rectangleHeight2);

        System.out.println("Diện tích hình chữ nhật có kích thước (2.5, 6) là: " + rectangleArea1);
        System.out.println("Diện tích hình chữ nhật có kích thước (4, 7) là: " + rectangleArea2);
    }
}
