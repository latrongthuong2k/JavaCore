public class CheckEmptyString {
    public static void main(String[] args) {
        String inputString = "Hello, world!";

        if (isEmptyString(inputString)) {
            System.out.println("Chuỗi rỗng.");
        } else {
            System.out.println("Chuỗi không rỗng.");
        }
    }
    public static boolean isEmptyString(String str) {
        return str.isEmpty();
    }
}
