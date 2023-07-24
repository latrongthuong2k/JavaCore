import java.util.Scanner;

public class FindTheHighestElementIn2DArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.println("nhập số hàng của ma trận: ");
        int columns = scanner.nextInt();

        double[][] matrix = new double[rows][columns];
        System.out.println("Nhập các phần tử của ma trận");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Nhập phần tử lại vị trí [" + i + "][" + j + "]");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        double maxValueMatrix = matrix[0][0];
        int maxRow = 0;
        int maxColumn = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > maxValueMatrix) {
                    maxValueMatrix = matrix[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất trong ma trận là: " + maxValueMatrix);
        System.out.println("Tọa độ của phần tử lớn nhất là: [" + maxRow + "][" + maxColumn + "]");
    }
}
