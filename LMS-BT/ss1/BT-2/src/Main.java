import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc (0 - 999): ");
        int number = scanner.nextInt();
        scanner.close();

        if (number < 0 || number > 999) {
            System.out.println("out of ability");
            return;
        }

        String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        if (number == 0) {
            System.out.println("zero");
            return;
        }

        if (number >= 100) {
            int hundredsDigit = number / 100;
            System.out.print(ones[hundredsDigit] + " hundred");
            number %= 100;
            if (number > 0) {
                System.out.print(" and ");
            }
        }

        if (number >= 20) {
            int tensDigit = number / 10;
            System.out.print(tens[tensDigit]);
            number %= 10;
            if (number > 0) {
                System.out.print(" ");
            }
        }

        if (number > 0) {
            if (number < 10) {
                System.out.print(ones[number]);
            } else {
                System.out.print(teens[number - 10]);
            }
        }

        System.out.println();
    }
}
