import java.util.Scanner;

public class TongDuongCheo {

    public static void main(String[] args) {

        // Nhập chiều cao của ma trận
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao của ma trận: ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập phần tử A[" + i + "][" + j + "]: ");
                A[i][j] = scanner.nextDouble();
            }
        }
        
        double sumDiagonal = 0;
        for (int i = 0; i < n; i++) {
            sumDiagonal += A[i][i];
        }

        // In ra tổng
        System.out.println("Tổng các số trên đường chéo chính là: " + sumDiagonal);
    }
}
