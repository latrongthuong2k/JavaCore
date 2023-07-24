import java.util.Scanner;

public class StudentGradeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng học sinh: ");
        int numStudents = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] studentScores = new double[numStudents][];
        double[] averageScores = new double[numStudents];
        String[] grades = new String[numStudents];
        System.out.print("Nhập số lượng môn học của học sinh : ");
        int numSubjects = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Nhập tên học sinh " + (i + 1) + ": ");
            studentNames[i] = scanner.next();
            studentScores[i] = new double[numSubjects];

            double sum = 0;
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Nhập điểm môn học " + (j + 1) + " của học sinh " + studentNames[i] + ": ");
                studentScores[i][j] = scanner.nextDouble();
                sum += studentScores[i][j];
            }

            averageScores[i] = sum / numSubjects;

            if (averageScores[i] >= 9) {
                grades[i] = "Xuất sắc";
            } else if (averageScores[i] >= 8) {
                grades[i] = "Giỏi";
            } else if (averageScores[i] >= 6.5) {
                grades[i] = "Khá";
            } else if (averageScores[i] >= 5) {
                grades[i] = "Trung bình";
            } else {
                grades[i] = "Yếu";
            }
        }

        System.out.println("Bảng điểm và xếp loại của học sinh:");
        System.out.printf("%-20s", "Tên học sinh");

        // In các tiêu đề cột điểm môn học
        for (int i = 0; i < studentScores[0].length; i++) {
            System.out.printf("%-20s", "Điểm môn học " + (i + 1));
        }
        System.out.printf("%-20s%-20s\n", "Điểm trung bình", "Xếp loại");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s", studentNames[i]);

            for (int j = 0; j < studentScores[i].length; j++) {
                System.out.printf("%-20.2f", studentScores[i][j]);
            }

            System.out.printf("%-20.2f%-20s\n", averageScores[i], grades[i]);
        }

        scanner.close();
    }
}
