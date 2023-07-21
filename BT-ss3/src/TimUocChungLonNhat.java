import java.util.Scanner;

public class TimUocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        int uocChungLonNhat = timUocChungLonNhat(a, b);
        String[] BAse = new String[6];
        System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + uocChungLonNhat);

        scanner.close();
    }

    // Hàm tìm ước số chung lớn nhất bằng thuật toán Euclid (đệ quy)
    public static int timUocChungLonNhat(int a, int b) {
        // Nếu b == 0, ước số chung lớn nhất của a và b là a
        // Ngược lại, tiếp tục tìm ước số chung lớn nhất của b và a % b (phần dư của a khi chia b)
        if (b == 0) {
            return a;
        } else {
            return timUocChungLonNhat(b, a % b);
        }
    }
}
