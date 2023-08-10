import java.util.Scanner;

public class BTAddIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khai báo và khởi tạo mảng
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;

        // Hiển thị mảng trước khi thêm
        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Nhập giá trị cần thêm vào mảng từ bàn phím
        System.out.print("\nNhập giá trị cần thêm vào mảng: ");
        int valueToAdd = sc.nextInt();

        // Tạo mảng mới có kích thước lớn hơn mảng ban đầu
        int[] newArr = new int[n + 1];

        // Sao chép tất cả các phần tử từ mảng ban đầu sang mảng mới
        System.arraycopy(arr, 0, newArr, 0, n);

        // Thêm phần tử mới vào cuối mảng mới
        newArr[n] = valueToAdd;

        // Gán mảng mới cho mảng ban đầu
        arr = newArr;

        // Hiển thị mảng sau khi thêm
        System.out.println("Mảng sau khi thêm:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
