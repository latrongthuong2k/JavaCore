package bt4;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Alice");
        student.setClasses("C03");

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Class: " + student.getClasses());
    }
}