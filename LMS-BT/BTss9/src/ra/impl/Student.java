package ra.impl;
import java.util.Scanner;
import ra.IStudent;
public class Student implements IStudent {
    private String studentID;
    private String studentName;
    private int age;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private boolean gender;
    private String studentRank;
    private String studentStatus;
    private float avgMark;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMark_html() {
        return mark_html;
    }

    public void setMark_html(float mark_html) {
        this.mark_html = mark_html;
    }

    public float getMark_css() {
        return mark_css;
    }

    public void setMark_css(float mark_css) {
        this.mark_css = mark_css;
    }

    public float getMark_javascript() {
        return mark_javascript;
    }

    public void setMark_javascript(float mark_javascript) {
        this.mark_javascript = mark_javascript;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getStudentRank() {
        return studentRank;
    }

    public void setStudentRank(String studentRank) {
        this.studentRank = studentRank;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    // Constructor
    public Student() {
        Scanner scanner = new Scanner(System.in);
        inputData(scanner);
        avgMark = calAvgMark();
        studentRank = calRank();
        studentStatus = calStatus();
    }
    // Input data method
    public void inputData(Scanner scanner) {

        System.out.print("Nhập Mã sinh viên (phải bắt đầu bằng 'SV' và gồm 4 ký tự): ");
        studentID = scanner.nextLine();
        while (!studentID.matches("SV\\d{2}")) {
            System.err.print("Mã sinh viên không hợp lệ! Vui lòng nhập lại: ");
            studentID = scanner.nextLine();
        }

        System.out.print("Nhập Tên sinh viên (6-50 ký tự): ");
        studentName = scanner.nextLine();
        while (studentName.length() < 6 || studentName.length() > 50) {
            System.err.print("Tên sinh viên không hợp lệ! Vui lòng nhập lại: ");
            studentName = scanner.nextLine();
        }

        System.out.print("Nhập Tuổi (phải lớn hơn hoặc bằng 18): ");
        age = scanner.nextInt();
        while (age < 18) {
            System.err.print("Tuổi không hợp lệ! Vui lòng nhập lại: ");
            age = scanner.nextInt();
        }

        System.out.print("Nhập Điểm HTML (0-10): ");
        mark_html = scanner.nextFloat();
        while (mark_html < 0 || mark_html > 10) {
            System.err.print("Điểm HTML không hợp lệ! Vui lòng nhập lại: ");
            mark_html = scanner.nextFloat();
        }

        System.out.print("Nhập Điểm CSS (0-10): ");
        mark_css = scanner.nextFloat();
        while (mark_css < 0 || mark_css > 10) {
            System.err.print("Điểm CSS không hợp lệ! Vui lòng nhập lại: ");
            mark_css = scanner.nextFloat();
        }

        System.out.print("Nhập Điểm JavaScript (0-10): ");
        mark_javascript = scanner.nextFloat();
        while (mark_javascript < 0 || mark_javascript > 10) {
            System.err.print("Điểm JavaScript không hợp lệ! Vui lòng nhập lại: ");
            mark_javascript = scanner.nextFloat();
        }

        scanner.nextLine(); // Tiêu thụ ký tự xuống dòng
        System.out.print("Nhập Giới tính sinh viên (true cho nam, false cho nữ): ");
        gender = scanner.nextBoolean();
    }

    // Display data method
    public void displayData() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("HTML Mark: " + mark_html);
        System.out.println("CSS Mark: " + mark_css);
        System.out.println("JavaScript Mark: " + mark_javascript);
        System.out.println("Average Mark: " + avgMark);
        System.out.println("Gender: " + (gender ? "Male" : "Female"));
        System.out.println("Student Rank: " + studentRank);
        System.out.println("Student Status: " + studentStatus);
    }

    // Calculate average mark method
    public float calAvgMark() {
        return (mark_html + mark_css + mark_javascript) / 3;
    }

    // Calculate student rank method
    public String calRank() {
        if (avgMark >= 9) {
            return "Xuất sắc";
        } else if (avgMark >= 8) {
            return "Giỏi";
        } else if (avgMark >= 7) {
            return "Khá";
        } else if (avgMark >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    // Calculate student status method
    public String calStatus() {
        return avgMark >= MARK_PASS ? "PASS" : "FAIL";
    }
}
