public class PrintShape {
    public static void main(String[] args) {
        int length = 7;
        int spaces = length;

        // In tam giác đặc
        for (int row = 1; row <= length; row++) {
            // In dấu cách trước các số
            for (int s = spaces; s > 1; s--) {
                System.out.print(" ");
            }

            // In các số từ 1 đến i
            for (int num = 1; num <= row; num++) {
                System.out.print(num);
            }

            // In các số từ i-1 xuống 1 (loại trừ số 1)
            for (int num = row - 1; num >= 1; num--) {
                System.out.print(num);
            }

            System.out.println();
            spaces--;
        }

        // Thiết lập lại số lượng dấu cách
        spaces = 2;

        // In tam giác rỗng
        for (int row = length - 1; row >= 1; row--) {
            // In dấu cách trước các số
            for (int s = 1; s < spaces; s++) {
                System.out.print(" ");
            }

            // In các số từ i đến 1
            for (int num = row; num >= 1; num--) {
                System.out.print(num);
            }

            // In các số từ 2 đến i (loại trừ số 1)
            for (int num = 2; num <= row; num++) {
                System.out.print(num);
            }

            System.out.println();
            spaces++;
        }
    }
}
