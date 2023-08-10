package bt1;

public class Main {
    public static void main(String[] args) {
        MyClass myObj = new MyClass();
        System.out.println("Giá trị thuộc tính myString ban đầu: " + myObj.getMyString());
        // thay đổi
        myObj.setMyString("Hello, World!");
        //in ra
        System.out.println("Giá trị thuộc tính myString sau khi thay đổi: " + myObj.getMyString());
    }
}
