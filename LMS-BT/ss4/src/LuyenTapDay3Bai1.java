import java.util.Scanner;
//import java.lang.System;

public class LuyenTapDay3Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số phần tử mảng: ");
        int arrLength = scanner.nextInt();
        int[] arr = new int[arrLength];
        boolean inMenu = true;
        do {
            System.out.println("*********MENU*********\n" +
                    "1. Nhập các giá trị phần tử mảng \n" +
                    "2. In ra các giá trị phần tử mảng\n" +
                    "3. In ra các giá trị của phần tử là số chẵn\n" +
                    "4. In ra các giá trị của phần tử là số lẻ\n" +
                    "5. Tính tổng các phần tử của mảng\n" +
                    "6. Thoát !\n");
            System.out.print("Nhập lệnh :");
            int commandNumber = scanner.nextInt();
            switch (commandNumber) {
                case 1:
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print("Nhập giá trị cho phần tử thứ " + i + ": ");
                        arr[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.print("Các giá trị phần tử mảng: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.printf("%d ", arr[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Các giá trị của phần tử là số chẵn: ");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0) {
                            System.out.printf("%d ", arr[i]);
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Các giá trị của phần tử là số lẻ: ");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 != 0) {
                            System.out.printf("%d ", arr[i]);
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        sum += arr[i];
                    }
                    System.out.println("Tổng các phần tử của mảng là: " + sum);
                    break;
                case 6:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Lệnh không hợp lệ. Vui lòng nhập lại.");
            }
        }
        while (inMenu);

        scanner.close();
    }
}
