public class showPrimeNumber {
    public static void main(String[] args) {
        int count = 0; // Số lượng số nguyên tố đã tìm thấy
        int number = 2; // Số nguyên dương đầu tiên để kiểm tra

        System.out.println("Danh sách 20 số nguyên tố đầu tiên:");

        while (count < 20) {
            if (isPrime(number)) {
                System.out.print(number + " ");
                count++;
            }
            number++;
        }
        System.out.print("\n");
//    Tìm các số nguyên tổ nhỏ hơn 100
        int count2 = 0; // Số lượng số nguyên tố đã tìm thấy
        int number2 = 2; // Số nguyên dương đầu tiên để kiểm tra
        System.out.println("Danh sách các số nguyên tố nhỏ hơn 100 :");

        while (number2 < 100) {
            if (isPrime(number2)) {
                System.out.print(number2 + " ");
                count2++;
            }
            number2++;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Kiểm tra từ 2 đến căn bậc hai của n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
