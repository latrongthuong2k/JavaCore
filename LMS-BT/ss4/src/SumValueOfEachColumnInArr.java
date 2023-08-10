import java.util.Scanner;

public class SumValueOfEachColumnInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.println("nhập số cột của ma trận: ");
        int columns = scanner.nextInt();

        double[][] matrix = new double[rows][columns];
        System.out.println("Nhập các phần tử của ma trận");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Nhập phần tử lại vị trí [" + i + "][" + j + "]");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Hãy nhập số thứ tự của cột cần tính");
        int targetColumn = scanner.nextInt();
        while (targetColumn > columns) {
            System.out.println("Số cột vượt quá số cột trong ma trận, hãy nhập số thứ tự của cột < " + columns + ": ");
            targetColumn = scanner.nextInt();
        }
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][targetColumn];
        }

        System.out.println("Tổng các phần tử của cột " + targetColumn + " là: " + sum);
    }
}
