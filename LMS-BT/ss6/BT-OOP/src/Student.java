public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private Boolean sex;
    private Float htmlScore;
    private Float cssScore;
    private Float javascriptScore;
    private Float avgScore;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, Boolean sex, Float htmlScore, Float cssScore, Float javascriptScore, Float avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgScore = avgScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(Float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public Float getCssScore() {
        return cssScore;
    }

    public void setCssScore(Float cssScore) {
        this.cssScore = cssScore;
    }

    public Float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(Float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public Float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }

    /////////////////////////////
// Method to update the properties of the Student object
    public void inputData(String studentId, String studentName, int age, Boolean sex, Float htmlScore, Float cssScore, Float javascriptScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
    }

    public void calAvgScore() {
        avgScore = (htmlScore + cssScore + javascriptScore) / 3;
//        System.out.println("Điểm trung bình của sinh viên " + studentName + " là : " + avgScore);
    }

    @Override
//    displayData
    public String toString() {
        String gender = sex ? "nam" : "nữ";
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", sex=" + gender +
                ", htmlScore=" + htmlScore +
                ", cssScore=" + cssScore +
                ", javascriptScore=" + javascriptScore +
                ", avgScore=" + String.format("%.2f", avgScore) +
                '}';
    }
}

////////////////////////////////////////////
//import java.util.Scanner;
//
//public class Student {
//    private String studentId;
//    private String studentName;
//    private int age;
//    private boolean sex;
//    private float htmlScore;
//    private float cssScore;
//    private float javascriptScore;
//    private float avgScore;
//
//    public Student() {
//    }
//
//    public Student(String studentId, String studentName, int age, boolean sex, float htmlScore, float cssScore, float javascriptScore, float avgScore) {
//        this.studentId = studentId;
//        this.studentName = studentName;
//        this.age = age;
//        this.sex = sex;
//        this.htmlScore = htmlScore;
//        this.cssScore = cssScore;
//        this.javascriptScore = javascriptScore;
//        this.avgScore = avgScore;
//    }
//
//    Scanner scanner = new Scanner(System.in);
//
//    public void inputData(Scanner scanner) {
//        System.out.println("Nhập vào mã sinh viên: ");
//        this.studentId = scanner.nextLine();
//        System.out.println("Nhập vào tên sinh viên: ");
//        this.studentName = scanner.nextLine();
//        System.out.println("Nhập vào tuổi sinh viên: ");
//        this.age = Integer.parseInt(scanner.nextLine());
//        System.out.println("Nhập vào giới tính sinh viên: ");
//        this.sex = Boolean.parseBoolean(scanner.nextLine());
//        System.out.println("Nhập vào điểm html sinh viên: ");
//        this.htmlScore = Float.parseFloat(scanner.nextLine());
//        System.out.println("Nhập vào điểm css sinh viên: ");
//        this.cssScore = Float.parseFloat(scanner.nextLine());
//        System.out.println("Nhập vào điểm javascript sinh viên: ");
//        this.javascriptScore = Float.parseFloat(scanner.nextLine());
//    }
//
//    public void displayData() {
////        System.out.printf("Mã sinh viên: %s - Tên sinh viên: %s - Tuổi: %d - Giới tính: %b - htmlScore: %f - cssScore: %f - javascriptScore: %f - Điểmn trung bình: %f",this.studentId,this.studentName,this.age,this.sex,this.htmlScore,this.cssScore,this.javascriptScore, this.avgScore);
////        System.out.printf("\n");
//
//    }
//
//    public float calAvgScore() {
//        return avgScore = (htmlScore + cssScore + javascriptScore) / 3;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public float getAvgScore() {
//        return avgScore;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId='" + studentId + '\'' +
//                ", studentName='" + studentName + '\'' +
//                ", age=" + age +
//                ", sex=" + sex +
//                ", htmlScore=" + htmlScore +
//                ", cssScore=" + cssScore +
//                ", javascriptScore=" + javascriptScore +
//                ", avgScore=" + avgScore +
//                ", scanner=" + scanner +
//                '}';
//    }
//}
