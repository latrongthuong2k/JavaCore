import java.util.Scanner;

public class BTXoaPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Nhập giá trị cần xoá từ bàn phím
        System.out.print("\nNhập giá trị cần xoá: ");
        int valueToDelete = sc.nextInt();
        // tìm giá trị
        int indexToDelete = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToDelete) {
                indexToDelete = i;
                break;
            }
        }
        // check
        if (indexToDelete != -1) {
            // Xoá phần tử tại vị trí indexToDelete
            for (int i = indexToDelete; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            // Giảm kích thước mảng đi 1
            int[] newArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length - 1);
            arr = newArr;

            // Hiển thị mảng sau khi xoá
            System.out.println("Mảng sau khi xoá:");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("Không tìm thấy giá trị cần xoá trong mảng.");
        }
        sc.close();
    }
}
