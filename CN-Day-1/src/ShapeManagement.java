import java.util.Scanner;

public class ShapeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isMenu = true;
        do {
            System.out.println("Chọn loại hình học bạn muốn quản lý:");
            System.out.println("1. Hình vuông");
            System.out.println("2. Hình chữ nhật");
            System.out.println("3. Hình tròn");
            System.out.println("4. Kết thúc");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập độ dài cạnh của hình vuông: ");
                    double side = scanner.nextDouble();
                    double squareArea = side * side;
                    double squarePerimeter = 4 * side;

                    System.out.println("Diện tích hình vuông: " + squareArea);
                    System.out.println("Chu vi hình vuông: " + squarePerimeter);
                    break;
                case 2:
                    System.out.print("Nhập chiều dài của hình chữ nhật: ");
                    double length = scanner.nextDouble();
                    System.out.print("Nhập chiều rộng của hình chữ nhật: ");
                    double width = scanner.nextDouble();
                    double rectangleArea = length * width;
                    double rectanglePerimeter = 2 * (length + width);

                    System.out.println("Diện tích hình chữ nhật: " + rectangleArea);
                    System.out.println("Chu vi hình chữ nhật: " + rectanglePerimeter);
                    break;
                case 3:
                    System.out.print("Nhập bán kính của hình tròn: ");
                    double radius = scanner.nextDouble();
                    double circleArea = Math.PI * radius * radius;
                    double circlePerimeter = 2 * Math.PI * radius;

                    System.out.println("Diện tích hình tròn: " + circleArea);
                    System.out.println("Chu vi hình tròn: " + circlePerimeter);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

            scanner.close();
        }
        while (isMenu);
    }
}
