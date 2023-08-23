package ra;

public class Book {
    private String bookId;
    private String bookName;
    private float price;

    public Book() {
    }
    public Book(String bookId, String bookName, float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public float getPrice() {
        return price;
    }
}
