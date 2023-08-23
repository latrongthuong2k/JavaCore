package ra.Imp;

import ra.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
        private List<Book> books;

        public BookImp() {
            books = new ArrayList<>();
        }

    /**
     * Input books func
     */
    public void inputBooks() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số lượng sách cần nhập: ");
            int numBooks = scanner.nextInt();
            scanner.nextLine(); // xoá bộ nhớ đệm scanner

            for (int i = 0; i < numBooks; i++) {
                System.out.println("Enter details for Book " + (i + 1) + ":");
                System.out.print("Book ID: ");
                String bookId = scanner.nextLine();
                System.out.print("Book Name: ");
                String bookName = scanner.nextLine();
                System.out.print("Price: ");
                float price = scanner.nextFloat();
                scanner.nextLine(); // Consume the newline

                Book book = new Book(bookId, bookName, price);
                books.add(book);
            }
        }

    /**
     * Save data to file txt
     */
    public void saveToFile() {
            try (PrintWriter writer = new PrintWriter("Books.txt")) {
                for (Book book : books) {
                    writer.println("Book ID: " + book.getBookId());
                    writer.println("Book Name: " + book.getBookName());
                    writer.println("Price: " + book.getPrice());
                    writer.println();
                }
                System.out.println("Đã lưu ra demo.txt");
            } catch (IOException e) {
                System.out.println("Error saving to file: " + e.getMessage());
            }
        }

    /**
     * Phương thức đọc và in ra màng hình console thông tin file
     * @param minPrice : giá thấp nhất
     * @param maxPrice : giá cao nhất
     */
    public void readAndPrintInRange(float minPrice, float maxPrice) {
        try (BufferedReader reader = new BufferedReader(new FileReader("demo.txt"))) {
            String line;
            String bookId = null;
            String bookName = null;
            float price = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Book ID: ")) {
                    bookId = line.substring(9);
                } else if (line.startsWith("Book Name: ")) {
                    bookName = line.substring(11);
                } else if (line.startsWith("Price: ")) {
                    price = Float.parseFloat(line.substring(7));
                } else if (line.trim().isEmpty()) {
                    if (price >= minPrice && price <= maxPrice) {
                        System.out.println("Book details:");
                        System.out.println("Book ID: " + bookId);
                        System.out.println("Book Name: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
