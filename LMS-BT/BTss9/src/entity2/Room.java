package entity2;

public class Room {
    private double price;
    private String type;

    public Room() {
    }

    public Room(double price, String type) {
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price :" + price + "$" +
                " type: " + type;
    }
}
