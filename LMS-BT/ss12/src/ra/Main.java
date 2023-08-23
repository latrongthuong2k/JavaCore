package ra;

import ra.Imp.BookImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookImp bookImp = new BookImp();

        while (true) {
            System.out.println("********MENU********");
            System.out.println("* 1. Nhập thông tin các sách");
            System.out.println("* 2. In thông tin các sách ra file demo.txt");
            System.out.println("* 3. Đọc file demo.txt và in ra các sách có giá trong khoảng 10000 đến 20000");
            System.out.println("* 4. Thoát");
            System.out.println("********************");

            System.out.print("Chọn một chức năng (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> bookImp.inputBooks();
                case 2 -> bookImp.saveToFile();
                case 3 -> bookImp.readAndPrintInRange(10000, 20000);
                case 4 -> {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                default -> System.out.println("Chức năng không hợp lệ.");
            }
        }
    }
}
