public class Main {
    public static void main(String[] args) {
        String str1 = "Rikkei Academy";
        String str3 = "Rikkei";
        String str2 = new String("Hello");
        int strLength1 = str1.length();
        int strLength2 = str2.length();
        System.out.printf("Độ dài của str1 %d\n", strLength1);
        System.out.printf("Độ dài của str2 %d\n", strLength2);
        if (str2.equals(str1)) {
            System.out.println("Chuỗi str1 = str2");
        }
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Chuỗi str1 = str2");
        }
        if (str1.startsWith("Rikkei")) {
            System.out.println("Chuỗi str1 có chứa Rikkei ở đoạn đầu");
        }
        if (str1.endsWith("Academy")) {
            System.out.println("Chuỗi str1 có chứa Academy ở đoạn sau ");
        }
        String str4 = str1.concat(str3);
        System.out.println(str4);
    }
}
