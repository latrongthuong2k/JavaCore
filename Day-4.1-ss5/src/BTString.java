import java.util.Scanner;

public class BTString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // nhập vào 2 chuỗi từ bàn phím
        System.out.print("Nhập chuỗi thứ nhất: ");
        String str1 = scanner.nextLine();

        System.out.print("Nhập chuỗi thứ hai: ");
        String str2 = scanner.nextLine();

        // 1. Kiểm tra hai chuỗi có phải là đảo ngược nhau hay không
        System.out.println("Check ngược nhau ?");
        if (isReverse(str1, str2)) {
            System.out.println("Có ngược nhau");
        } else {
            System.out.println("Không ngược nhau");
        }

        // 2. In các ký tự chỉ xuất hiện duy nhất 1 lần trong chuỗi
        printUniqueCharacters(str1);

        // 3. chuỗi đảo ngược
        System.out.println("Chuỗi đảo ngược của chuỗi thứ nhất: " + reverseString(str1));

        // 4. Check trong chuỗi có ký tự số ?
        System.out.println("Check trong chuỗi CÓ hay KO ký tự số ?");
        if (hasDigits(str1)) {
            System.out.println("Có ký tự số");
        } else {
            System.out.println("Không có ký tự số");
        }

        // 5. Chuẩn hóa chuỗi
        String normalizedString = normalizeString(str1);
        System.out.println("Chuỗi chuẩn hóa: " + normalizedString);

        // 6. Thay thế chuỗi
        String replacedString = str1.replace("Academy", "Học viện");
        System.out.println("Chuỗi sau khi thay thế: " + replacedString);

        // 7. Xóa các ký tự xuất hiện nhiều hơn 1 lần trong chuỗi và chỉ giữ lại ký tự
        // đầu tiên
        String uniqueCharsString = removeDuplicateCharacters(str1);
        System.out.println("Chuỗi sau khi xóa các ký tự trùng lặp: " + uniqueCharsString);

        // 8. Nối 2 chuỗi và cắt nếu cần
        String concatenatedString = concatenateStrings(str1, str2);
        System.out.println("Chuỗi sau khi nối: " + concatenatedString);
    }

    // 1. Kiểm tra hai chuỗi có phải là đảo ngược nhau hay không
    public static boolean isReverse(String str1, String str2) {
        return str1.equals(new StringBuilder(str2).reverse().toString());
    }

    // 2. In các ký tự chỉ xuất hiện duy nhất 1 lần trong chuỗi
    public static void printUniqueCharacters(String str) {
        System.out.println("Các ký tự chỉ xuất hiện duy nhất 1 lần trong chuỗi:");
        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    // 3. In ra chuỗi đảo ngược
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 4. Kiểm tra trong chuỗi có ký tự số không
    public static boolean hasDigits(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // 5. Chuẩn hóa chuỗi
    public static String normalizeString(String str) {
        String trimmedStr = str.trim();
        String[] words = trimmedStr.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // 7. Xóa các ký tự xuất hiện nhiều hơn 1 lần trong chuỗi và chỉ giữ lại ký tự
    // đầu tiên
    public static String removeDuplicateCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 8. Nối 2 chuỗi và cắt nếu cần
    public static String concatenateStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        return str1.substring(str1.length() - minLength) + str2.substring(str2.length() - minLength);
    }
}
