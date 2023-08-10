public class ReverseStringUsingStringBuffer {
    public static void main(String[] args) {
        String inputString = "Hello, world!";
        String reversedString = reverseString(inputString);
        System.out.println("Chuỗi ban đầu: " + inputString);
        System.out.println("Chuỗi đảo ngược: " + reversedString);
    }

    public static String reverseString(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
