import java.util.Scanner;

public class MoneyExchangeApp {
    public static void main(String[] args) {
        float exchangeRate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền muốn chuyển đổi : ... USD");
        float usdAmount = scanner.nextFloat();

        float exchangedMoney = usdAmount * exchangeRate;
        System.out.println("Số tiền VND sau khi chuyển đổi là : ");
        System.out.printf("%.2f USD = %.2f VND",usdAmount,exchangedMoney );
    }
}
