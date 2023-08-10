//import ra.impl.Student;
//
//import java.util.Scanner;
//
//class StudentManagement {
//    private final Student[] students;
//    private int numberOfStudents;
//
//    public StudentManagement() {
//        students = new Student[100];
//        numberOfStudents = 0;
//    }
//
//    public void addStudents(int n) {
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < students.length; i++) {
//                if (students[i] == null) {
//                    System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
//                    students[i] = new Student();
//                    numberOfStudents++;
//                    break;
//                }
//            }
//        }
//    }
//
//    public float calculateOverallAverage() {
//        float sum = 0;
//        for (int i = 0; i < numberOfStudents; i++) {
//            sum += students[i].calAvgMark();
//        }
//        return sum / numberOfStudents;
//    }
//
//    public void evaluateStudents() {
//        for (int i = 0; i < numberOfStudents; i++) {
//            System.out.println("Sinh viên " + students[i].getStudentName() + ": " + students[i].getStudentRank());
//        }
//    }
//
//    public void calculateStudentStatus() {
//        for (int i = 0; i < numberOfStudents; i++) {
//            System.out.println("Sinh viên " + students[i].getStudentName() + ": " + students[i].getStudentStatus());
//        }
//    }
//
//    public void displayAllStudents() {
//        for (int i = 0; i < numberOfStudents; i++) {
//            students[i].displayData();
//        }
//    }
//
//    public void sortByAverageMark() {
//        // Simple bubble sort for demonstration purposes
//        for (int i = 0; i < numberOfStudents - 1; i++) {
//            for (int j = 0; j < numberOfStudents - i - 1; j++) {
//                if (students[j].calAvgMark() > students[j + 1].calAvgMark()) {
//                    Student temp = students[j];
//                    students[j] = students[j + 1];
//                    students[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
//        displayAllStudents();
//    }
//
//    public void searchStudentByName(String name) {
//        int count = 0;
//        for (int i = 0; i < numberOfStudents; i++) {
//            if (students[i].getStudentName().equalsIgnoreCase(name)) {
//                students[i].displayData();
//                count++;
//            }
//        }
//        if (count == 0) {
//            System.out.println("Không tìm thấy sinh viên có tên " + name);
//        }
//    }
//
//    public void countStudentsByRank() {
//        int[] rankCount = new int[5]; // Yếu, Trung bình, Khá, Giỏi, Xuất sắc
//        for (int i = 0; i < numberOfStudents; i++) {
//            String rank = students[i].getStudentRank();
//            switch (rank) {
//                case "Yếu" -> rankCount[0]++;
//                case "Trung bình" -> rankCount[1]++;
//                case "Khá" -> rankCount[2]++;
//                case "Giỏi" -> rankCount[3]++;
//                case "Xuất sắc" -> rankCount[4]++;
//            }
//        }
//        System.out.println("Thống kê sinh viên theo xếp loại:");
//        System.out.println("Yếu: " + rankCount[0]);
//        System.out.println("Trung bình: " + rankCount[1]);
//        System.out.println("Khá: " + rankCount[2]);
//        System.out.println("Giỏi: " + rankCount[3]);
//        System.out.println("Xuất sắc: " + rankCount[4]);
//    }
//
//    public void countStudentsByStatus() {
//        int passCount = 0;
//        int failCount = 0;
//        for (int i = 0; i < numberOfStudents; i++) {
//            if (students[i].getStudentStatus().equals("PASS")) {
//                passCount++;
//            } else {
//                failCount++;
//            }
//        }
//        System.out.println("Thống kê sinh viên theo trạng thái:");
//        System.out.println("PASS: " + passCount);
//        System.out.println("FAIL: " + failCount);
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        StudentManagement studentManagement = new StudentManagement();
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("***************************MENU*************************");
//            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
//            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
//            System.out.println("3. Đánh giá xếp loại các sinh viên");
//            System.out.println("4. Tính trạng thái của sinh viên");
//            System.out.println("5. In thông tin các sinh viên");
//            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
//            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
//            System.out.println("8. Thống kê sinh viên theo xếp loại");
//            System.out.println("9. Thống kê sinh viên theo trạng thái");
//            System.out.println("10. Thoát");
//            System.out.print("Nhập lựa chọn của bạn: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Nhập số lượng sinh viên cần thêm (n): ");
//                    int n = scanner.nextInt();
//                    while (n < 0 && n > 100) {
//                        System.out.println("Số học sinh không được ngoài phạm vi 1 - 100");
//                        n = scanner.nextInt();
//                    }
//                    studentManagement.addStudents(n);
//                }
//                case 2 -> {
//                    float avg = studentManagement.calculateOverallAverage();
//                    System.out.println("Điểm trung bình tất cả sinh viên: " + avg);
//                }
//                case 3 -> studentManagement.evaluateStudents();
//                case 4 -> studentManagement.calculateStudentStatus();
//                case 5 -> studentManagement.displayAllStudents();
//                case 6 -> studentManagement.sortByAverageMark();
//                case 7 -> {
//                    scanner.nextLine(); // consume the newline character
//                    System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
//                    String searchName = scanner.nextLine();
//                    studentManagement.searchStudentByName(searchName);
//                }
//                case 8 -> studentManagement.countStudentsByRank();
//                case 9 -> studentManagement.countStudentsByStatus();
//                case 10 -> System.out.println("Kết thúc chương trình!");
//                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
//            }
//        } while (choice != 10);
//    }
//}

import ra.impl.Student;

import java.util.*;

class StudentManagement {
    private final List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudents(int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student student = new Student();
            students.add(student);
        }
    }

    public float calculateOverallAverage() {
        float sum = 0;
        for (Student student : students) {
            sum += student.calAvgMark();
        }
        return sum / students.size();
    }

    public void evaluateStudents() {
        for (Student student : students) {
            System.out.println("Sinh viên " + student.getStudentName() + ": " + student.getStudentRank());
        }
    }

    public void calculateStudentStatus() {
        for (Student student : students) {
            System.out.println("Sinh viên " + student.getStudentName() + ": " + student.getStudentStatus());
        }
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayData();
        }
    }

    public void sortByAverageMark() {
        students.sort(Comparator.comparingDouble(Student::calAvgMark));
        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        displayAllStudents();
    }

    public void searchStudentByName(String name) {
        int count = 0;
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                student.displayData();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy sinh viên có tên " + name);
        }
    }

    public void countStudentsByRank() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("Yếu", 0);
        rankCount.put("Trung bình", 0);
        rankCount.put("Khá", 0);
        rankCount.put("Giỏi", 0);
        rankCount.put("Xuất sắc", 0);

        for (Student student : students) {
            String rank = student.getStudentRank();
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        System.out.println("Thống kê sinh viên theo xếp loại:");
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void countStudentsByStatus() {
        int passCount = 0;
        int failCount = 0;
        for (Student student : students) {
            if (student.getStudentStatus().equals("PASS")) {
                passCount++;
            } else {
                failCount++;
            }
        }
        System.out.println("Thống kê sinh viên theo trạng thái:");
        System.out.println("PASS: " + passCount);
        System.out.println("FAIL: " + failCount);
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***************************MENU*************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Tính trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập số lượng sinh viên cần thêm (n): ");
                    int n = scanner.nextInt();
                    while (n < 0 && n > 100) {
                        System.out.println("Số học sinh không được ngoài phạm vi 1 - 100");
                        n = scanner.nextInt();
                    }
                    studentManagement.addStudents(n);
                }
                case 2 -> {
                    float avg = studentManagement.calculateOverallAverage();
                    System.out.println("Điểm trung bình tất cả sinh viên: " + avg);
                }
                case 3 -> studentManagement.evaluateStudents();
                case 4 -> studentManagement.calculateStudentStatus();
                case 5 -> studentManagement.displayAllStudents();
                case 6 -> studentManagement.sortByAverageMark();
                case 7 -> {
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    studentManagement.searchStudentByName(searchName);
                }
                case 8 -> studentManagement.countStudentsByRank();
                case 9 -> studentManagement.countStudentsByStatus();
                case 10 -> System.out.println("Kết thúc chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 10);
    }
}
