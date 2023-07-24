import java.util.Scanner;

public class FindTheLowestValueInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài mảng: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];

        int minValue = arr[0];

        System.out.println("Nhập giá trị cho mảng: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int j : arr) {
            if (minValue > j) {
                minValue = j;
            }
        }
        System.out.println("Gía trị nhỏ nhất trong mảng là :" + minValue);

    }
}
