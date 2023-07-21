//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldExit = false;

        do {
            System.out.println("Nhập vào một số nguyên:");
            int number = scanner.nextInt();
            System.out.println("Nhập yêu cầu từ 1-4:\n 1. Kiểm tra chẵn lẻ\n2. Kiểm tra chia hết cho 3 và 5\n3. Kiểm tra số nguyên tố\n4. Kiểm tra số hoàn hảo\n5. Thoát");
            int command = scanner.nextInt();
            switch (command) {
                case 0:
                    System.out.println("Hãy nhập 0 nếu bạn muốn thoát");
                    shouldExit = true;
                    break;
                case 1:
                    System.out.println("1. Kiểm tra số chẵn lẻ:");
                    if (number % 2 == 0) {
                        System.out.printf("%d là số chẵn\n", number);
                    } else {
                        System.out.printf("%d là số lẻ\n", number);
                    }
                    break;
                case 2:
                    System.out.println("2. Kiểm tra số có chia hết cho 3 và 5:");
                    if (number % 3 == 0 && number % 5 == 0) {
                        System.out.printf("%d có chia hết cho 3 và 5\n", number);
                        break;
                    }

                    System.out.printf("%d không chia hết cho 3 và 5\n", number);
                    break;
                case 3:
                    System.out.println("3. Kiểm tra số nguyên tố: " + (isPrime(number) ? "Số nguyên tố" : "Không phải số nguyên tố"));
                    break;
                case 4:
                    System.out.println("4. Kiểm tra số hoàn hảo: " + (isPerfectNumber(number) ? "Số hoàn hảo" : "Không phải số hoàn hảo"));
                    break;
                default:
                    System.out.println("Yêu cầu không hợp lệ");
            }
        } while(!shouldExit);

        scanner.close();
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 1;

        for(int i = 2; (double)i <= Math.sqrt((double)number); ++i) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }

        return sum == number;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for(int i = 2; (double)i <= Math.sqrt((double)number); ++i) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
