package LoanCaculateApp;

import java.util.Scanner;

public class loanCaculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số lượng tiền cho vay: ");
        int loanMoney = scanner.nextInt();

        System.out.print("Nhập vào tỉ lệ lãi suất theo tháng (%): ");
        double interestRatePerMonth = scanner.nextDouble() / 100; // Chuyển tỉ lệ lãi suất từ phần trăm sang đơn vị

        System.out.print("Nhập vào số tháng cho vay: ");
        int loanMonths = scanner.nextInt();

        // Tính tiền lãi
        double interest = loanMoney * interestRatePerMonth * loanMonths;

        // Tính tổng số tiền có được khi hết thời hạn cho vay
        double totalMoney = loanMoney + interest;

        // Hiển thị kết quả
        System.out.println("Tiền lãi: " + interest + " VND");
        System.out.println("Tổng số tiền có được khi hết thời hạn cho vay: " + totalMoney + " VND");

        scanner.close();
    }
}
