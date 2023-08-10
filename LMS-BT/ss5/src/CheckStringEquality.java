public class CheckStringEquality {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "Hello";

        if (areStringsEqual(str1, str2)) {
            System.out.println("Chuỗi 1 và chuỗi 2 giống nhau.");
        } else {
            System.out.println("Chuỗi 1 và chuỗi 2 không giống nhau.");
        }

        if (areStringsEqual(str1, str3)) {
            System.out.println("Chuỗi 1 và chuỗi 3 giống nhau.");
        } else {
            System.out.println("Chuỗi 1 và chuỗi 3 không giống nhau.");
        }
    }

    public static boolean areStringsEqual(String str1, String str2) {
        return str1.equals(str2);
    }
}
