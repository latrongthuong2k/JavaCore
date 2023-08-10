import java.util.Scanner;


// Hiển thị các loại hình
public class MenuShowRectangleAndSquareTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        String kyHieu = "*";
        do {
            System.out.println("Menu lựa chọn hiển thị các hình");
            System.out.println("Hãy nhập từ 1-4 để thực hiện các lệnh hiển thị");
            System.out.println("Menu:\n" +
                    "1. Print the rectangle\n" +
                    "2. Print the square triangle (The corner is square at 4 different angles: top-left,\n" +
                    "top-right, bottom-left, bottom-right)\n" +
                    "3. Print isosceles triangle\n" +
                    "4. Exit");
            System.out.print("Thực hiện lệnh số :");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("1. Print the rectangle");
                    int chieuDai = 7;
                    int chieuRong = 3;
                    for (int i = 0; i < chieuRong; i++) {
                        for (int j = 0; j < chieuDai; j++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("2. Print the square triangle");
                    int h = 5; // Chiều cao của tam giác vuông
                    for (int i = 1; i <= h; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    System.out.println();

                    for (int i = h; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    System.out.println();

                    for (int i = 1; i <= h; i++) {
                        for (int j = h; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    System.out.println();

                    for (int i = h; i >= 1; i--) {
                        for (int j = h; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("3. Print isosceles triangle");
                    int n = 5; // Chiều cao của tam giác cân
                    for (int i = 1; i <= n; i++) {
                        for (int j = n; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print(kyHieu);
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.out.println("4. Exit");
                    break;
                default:
                    System.out.println("Không hợp lệ. Hãy nhập số từ 1 đến 4.");
            }

        } while (number != 4);

        System.out.println("Chương trình kết thúc.");
    }
}
