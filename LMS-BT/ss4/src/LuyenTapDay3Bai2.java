import java.util.Scanner;
//import java.lang.System;

public class LuyenTapDay3Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng và số cột");
        System.out.print("Số hàng : ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.print("Số cột : ");
        int column = Integer.parseInt(scanner.nextLine());
        int[][] arrInt = new int[row][column];
        boolean inMenu = true;
        do {
            System.out.println("*********MENU*********\n" +
                    "1. Nhập các giá trị phần tử mảng \n" +
                    "2. In ra các giá trị phần tử mảng\n" +
                    "3. In ra các giá trị của phần tử chia hết cho 3\n" +
                    "4. Tính tổng các phần tử của mảng\n" +
                    "5. In chỉ số giá trị lớn nhất\n" +
                    "6. Thoát !\n");
            System.out.print("Nhập lệnh :");
            int commandNumber = scanner.nextInt();
            switch (commandNumber) {
                case 1:
                    for (int i = 0; i < arrInt.length; i++) {
                        System.out.println("Hàng " + i);
                        for (int j = 0; j < arrInt[i].length; j++) {
                            System.out.print("Nhập giá trị cho phần tử thứ " + j + ": ");
                            arrInt[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Các giá trị phần tử mảng:");
                    for (int i = 0; i < arrInt.length; i++) {
                        for (int j = 0; j < arrInt[i].length; j++) {
                            System.out.print(arrInt[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Các giá trị của phần tử chia hết cho 3:");
                    for (int i = 0; i < arrInt.length; i++) {
                        for (int j = 0; j < arrInt[i].length; j++) {
                            if (arrInt[i][j] % 3 == 0) {
                                System.out.print(arrInt[i][j] + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    int sum = 0;
                    for (int i = 0; i < arrInt.length; i++) {
                        for (int j = 0; j < arrInt[i].length; j++) {
                            sum += arrInt[i][j];
                        }
                    }
                    System.out.println("Tổng các phần tử của mảng: " + sum);
                    break;
                case 5:
                    int max = arrInt[0][0];
                    int maxRow = 0;
                    int maxCol = 0;
                    for (int i = 0; i < arrInt.length; i++) {
                        for (int j = 0; j < arrInt[i].length; j++) {
                            if (arrInt[i][j] > max) {
                                max = arrInt[i][j];
                                maxRow = i;
                                maxCol = j;
                            }
                        }
                    }
                    System.out.println("Chỉ số giá trị lớn nhất: hàng " + maxRow + ", cột " + maxCol);
                    break;
                case 6:
                    inMenu = false;
                    break;
                default:
                    System.out.println("Lệnh không hợp lệ!");
            }
        } while (inMenu);
    }
}
