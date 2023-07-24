import java.util.Scanner;

public class CountElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String inputString = scanner.nextLine();

        System.out.print("Nhập ký tự cần đếm: ");
        char targetChar = scanner.next().charAt(0);

        int count = countOccurrences(inputString, targetChar);
        System.out.println("Số lần xuất hiện của ký tự '" + targetChar + "' trong chuỗi là: " + count);
    }

    public static int countOccurrences(String inputString, char targetChar) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == targetChar) {
                count++;
            }
        }
        return count;
    }
}
