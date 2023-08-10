package entity2;

public class Customer {
    private String name;
    private int age;
    private String idNumber;
    private Room room;


    public Customer() {
    }

    public Customer(String name, int age, String idNumber, Room room) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
        this.room = room;
    }

    // getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + " ID Number :" + idNumber;
    }

}
