package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private int year;
    private float interest;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
        this.calculateInterest();
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
        this.calculateInterest();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getInterest() {
        return interest;
    }

    // validate bookName (4 characters, starts with 'B')
    private boolean validateBookName(String bookName) {
        return bookName.length() == 4 && bookName.startsWith("B");
    }

    // validate importPrice (greater than 0)
    private boolean validateImportPrice(float importPrice) {
        return importPrice > 0;
    }

    private boolean validateExportPrice(float exportPrice, float importPrice) {
        return exportPrice > 1.3 * importPrice;
    }

    // Method to validate author (from 6 to 50 characters)
    private boolean validateAuthor(String author) {
        return author.length() >= 6 && author.length() <= 50;
    }

    private boolean validateYear(int year) {
        return year > 2000;
    }

    private void calculateInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public boolean inputBookData(Scanner scanner, Book[] books) {
        scanner.nextLine();
        System.out.println("Nhập Book ID: ");
        String bookId = scanner.nextLine();
        if (bookId != null) {
            for (Book item : books) {
                if (item != null && item.getBookId().equals(bookId)) {
                    System.err.println("Id đã tồn tại");
                    return false;
                }
            }
        }
        boolean isValid = true;
        System.out.println("Nhập tên Book  (Với 4 ký tự, và bắt dầu với chữ cái 'B'): ");
        String bookName = scanner.nextLine();
        if (!validateBookName(bookName)) {
            System.err.println("Nhập Tên sách bị sai");
            isValid = false;
        }
        System.out.println("Nhập giá sách (Giá phải lớn hơn 0): ");
        float importPrice = scanner.nextFloat();
        if (!validateImportPrice(importPrice)) {
            System.err.println("Nhập giá import sách sai");
            isValid = false;
        }
        System.out.println("Nhập giá xuất của sách (lớn hơn 30% so với giá nhập): ");
        float exportPrice = scanner.nextFloat();
        if (!validateExportPrice(exportPrice, importPrice)) {
            System.err.println("Nhập giá export sách sai");
            isValid = false;
        }
        System.out.println("Nhập tên tác giả (Từ 6 dến 50 ký tự) ");
        scanner.nextLine();
        String author = scanner.nextLine();
        if (!validateAuthor(author)) {
            System.err.println("Nhập tên tác giả sách sai");
            isValid = false;
        }
        System.out.println("Nhập năm (phải trên năm 2000): ");
        int year = scanner.nextInt();
        if (!validateYear(year)) {
            System.err.println("Nhập năm sai");
            isValid = false;
        }
        if (isValid) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.importPrice = importPrice;
            this.exportPrice = exportPrice;
            this.author = author;
            this.year = year;
            this.calculateInterest();

            System.out.println("Book information:");
            System.out.println("Book ID: " + bookId);
            System.out.println("Book Name: " + bookName);
            System.out.println("Import Price: " + importPrice);
            System.out.println("Export Price: " + exportPrice);
            System.out.println("Author: " + author);
            System.out.println("Year: " + year);
            System.out.println("Interest: " + interest);
        } else {
            // chỗ này sẽ đi kèm thêm mấy cái error validate trước đó nữa
            System.err.println("Hãy nhập lại cho đúng");
        }
        return isValid;
    }

    public float calculateInterest(float exportPrice, float importPrice) {
        return exportPrice - importPrice;
    }

    public void displayBook() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Book information:\n" +
                "Book ID: " + bookId + "\n" +
                "Book Name: " + bookName + "\n" +
                "Import Price: " + importPrice + "\n" +
                "Export Price: " + exportPrice + "\n" +
                "Author: " + author + "\n" +
                "Year: " + year + "\n" +
                "Interest: " + interest + "\n";
    }
}
