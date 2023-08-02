import java.util.Scanner;

public class StudentImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] arrStudent2 = new Student[100];
        System.out.println("Hãy nhập số sinh viên : ");
//        Student[] arrStudent2 = new Student[studentTotal];
        boolean isMenu = true;

        do {
            System.out.println("**********************MENU*********************\n" +
                    "1. Nhập vào thông tin n sinh viên (n nhập từ bàn phím)\n" +
                    "2. Tính điểm trung bình tất cả sinh viên\n" +
                    "3. Hiển thị thông tin tất cả sinh viên\n" +
                    "4. Sắp xếp sinh viên theo điểm trung bình giảm dần\n" +
                    "5. Tìm kiếm sinh viên theo tên sinh viên (Tên sinh viên cần tìm nhập từ\n" +
                    "bàn phím)\n" +
                    "6. Thoát");
            System.out.print("Hãy nhập vào lệnh số : ");
            short commandNumber = scanner.nextShort();
            scanner.nextLine();
            switch (commandNumber) {
                case 1:
                    System.out.println("Hãy nhập số thứ tự của sinh viên để thêm thông tin");
                    int studentIndex = scanner.nextInt();
                    int length = arrStudent2.length;
                    for (int i = 0; i < length; i++) {
                        if (studentIndex == i) {
                            Student optionalStudent = new Student();
                            System.out.println("Hãy nhập Id");
                            String id = scanner.nextLine();
                            System.out.println("Hãy nhập Tên");
                            String name = scanner.nextLine();
                            System.out.println("Hãy nhập Tuổi");
                            int age = scanner.nextInt();
                            System.out.println("Hãy nhập true hoặc false cho giới tính");
                            boolean gender = scanner.nextBoolean();
                            System.out.println("Hãy nhập điểm Html");
                            float html = scanner.nextFloat();
                            System.out.println("Hãy nhập điểm Css");
                            float css = scanner.nextFloat();
                            System.out.println("Hãy nhập điểm JavaScript");
                            float javaScript = scanner.nextFloat();
                            scanner.nextLine();
                            //
                            optionalStudent.inputData(id, name, age, gender, html, css, javaScript);
                            optionalStudent.calAvgScore();
                            arrStudent2[i] = optionalStudent;
                        }
                    }
                    break;
                case 2:
                    float scoreTotalStudent = 0;
                    System.out.println("*** Tổng điểm trung bình của từng học sinh : ");
                    for (Student student : arrStudent2) {
                        scoreTotalStudent += student.getAvgScore();
                        System.out.println("DTB học sinh : " + student.getStudentName());
                    }
                    float avgScoreTotalStudent = scoreTotalStudent / arrStudent2.length;
                    System.out.println("*** Tổng điểm trung bình của toàn bộ học sinh là : " + avgScoreTotalStudent);
                    break;
                case 3:
                    for (Student student : arrStudent2) {
                        System.out.println(student.toString());
                    }
                    break;
                case 4:
                    // thuật toán bubble sort
                    for (int i = 0; i < arrStudent2.length - 1; i++) {
                        for (int j = 0; j < arrStudent2.length - i - 1; j++) {
                            if (arrStudent2[j].getAvgScore() < arrStudent2[j + 1].getAvgScore()) {
                                Student temp = arrStudent2[j];
                                arrStudent2[j] = arrStudent2[j + 1];
                                arrStudent2[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Danh sách sinh viên sau khi sắp xếp:");
                    for (Student student : arrStudent2) {
                        System.out.println(student.toString());
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Student student : arrStudent2) {
                        if (student.getStudentName().equalsIgnoreCase(searchName)) {
                            System.out.println("Thông tin sinh viên có tên " + searchName + ":");
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sinh viên có tên " + searchName);
                    }
                    break;
                case 6:
                    isMenu = false;
                    System.out.println("Đã thoát khỏi chương trình.");
                    break;
            }
        }
        while (isMenu);

    }
}

//import java.util.Scanner;
//
//// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
//// then press Enter. You can now see whitespace characters in your code.
//public class Studentlmp {
//    public static void main(String[] args) {
//        Student[] arrStudent = new Student[100];
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("*********************MENU********************");
//            System.out.println("1. Nhập vào thông tin n sinh viên (n nhập từ bàn phím)");
//            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
//            System.out.println("3. Hiển thị thông tin tất cả sinh viên");
//            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình giảm dần");
//            System.out.println("5. Tìm kiếm sinh viên theo tên sinh viên (Tên sinh viên cần tìm nhập từ bàn phím)");
//            System.out.println("6. Thoát");
//            System.out.println("Sự lựa chọn của bạn là: ");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//
//                    System.out.println("Nhập vào thứ tự sinh viên muốn nhập thông tin ");
//                    int number = Integer.parseInt(scanner.nextLine());
//                    System.out.printf("Nhập thông tin sinh viên %d:", number);
//                    System.out.print("\n");
//                    for (int i = 0; i < arrStudent.length; i++) {
//                        Student student = new Student();
//                        if (i == number) {
//                            student.inputData(scanner);
//                            arrStudent[i] = student;
//                            System.out.println(arrStudent[i].toString());
//                            student.calAvgScore();
//                        }
//                    }
//
//                    break;
//                case 2:
//                    for (Student student : arrStudent) {
//                        if (student != null) {
//                            //                        String name = student.getStudentName();
//                            float avgScore = student.getAvgScore();
//                            //             System.out.println(name+"--->"+avgScore);
//                            System.out.println(avgScore);
//                        }
//
//                    }
//
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//                case 5:
//                    break;
//                case 6:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Vui lòng chọn 1-6");
//            }
//        } while (true);
//    }
//}
