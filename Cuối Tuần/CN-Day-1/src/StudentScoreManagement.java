import java.util.Scanner;

public class StudentScoreManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên trong lớp học: ");
        int numStudents = scanner.nextInt();
        int[] scores = new int[numStudents];
        int sum = 0;

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Nhập tên và điểm của sinh viên " + (i + 1) + "từ (0 - 100 ) : ");
            scores[i] = scanner.nextInt();
            sum += scores[i];
        }

        System.out.println("Điểm của tất cả sinh viên trong lớp:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
        }

        double averageScore = (double) sum / numStudents;
        System.out.println("Điểm trung bình của lớp học: " + averageScore);

        int maxScore = scores[0];
        int minScore = scores[0];
        for (int i = 1; i < numStudents; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
            if (scores[i] < minScore) {
                minScore = scores[i];
            }
        }

        System.out.println("Sinh viên có điểm cao nhất: " + maxScore);
        System.out.println("Sinh viên có điểm thấp nhất: " + minScore);

        scanner.close();
    }
}
