import java.util.Scanner;

import ra.entity.Book;

import java.util.HashMap;

public class BookImp {
    private static final int MAX_BOOKS = 100;

    private final Book[] books;
    private int numBooks;


    public BookImp() {
        books = new Book[MAX_BOOKS];
        numBooks = 0;
    }

    public static void main(String[] args) {
        BookImp bookImp = new BookImp();
        Scanner scanner = new Scanner(System.in);

        //
        int choice;
        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookImp.inputBooksData(scanner);
                    break;
                case 2:
                    bookImp.calculateProfit();
                    break;
                case 3:
                    bookImp.displayBooks();
                    break;
                case 4:
                    bookImp.sortByExportPriceAscending();
                    break;
                case 5:
                    bookImp.sortByProfitDescending();
                    break;
                case 6:
                    bookImp.searchBooksByName(scanner);
                    break;
                case 7:
                    bookImp.statisticsByYear();
                    break;
                case 8:
                    bookImp.statisticsByAuthor();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }

    // nhập n cuốn sách

    private void inputBooksData(Scanner scanner) {

        System.out.println("Nhập sô lượng sách cần nhập (n): ");
        int n;
        boolean isOK = true;
        n = scanner.nextInt();
        // check trong phạm vi 1 - 100
        while (isOK) {
            if (n > 0 && n < MAX_BOOKS)
                isOK = false;
            else {
                System.out.println("Hãy nhập đúng lại trong phạm vi 1 - 100");
                n = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < books.length; j++) {
                if (books[j] == null) {
                    System.out.println("Nhập thông tin cho sách thứ " + (j + 1) + ":");
                    Book book = new Book();
                    while (true) {
                        if (book.inputBookData(scanner, books))
                            break;
                    }
                    books[j] = book;
                    numBooks++;
                    break;
                }
            }
        }
    }

    // tính lợi nhuận
    private void calculateProfit() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Lợi nhuận của các sách:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Sách thứ " + (i + 1) + ":");
            System.out.println("Lợi nhuận: " + books[i].getInterest());
        }
    }

    // hàm display mới khác với trong class để check một số thứ
    private void displayBooks() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("Thông tin tất cả sách:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Sách thứ " + (i + 1) + ":");
            books[i].displayBook();
        }
    }

    // xếp theo giá bán tăng dần
    private void sortByExportPriceAscending() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        // Bubble sort
        for (int i = 0; i < numBooks - 1; i++) {
            for (int j = 0; j < numBooks - i - 1; j++) {
                if (books[j].getExportPrice() > books[j + 1].getExportPrice()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }

        System.out.println("Sách đã được sắp xếp theo giá bán tăng dần:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Sách thứ " + (i + 1) + ":");
            books[i].displayBook();
        }
    }

    private void sortByProfitDescending() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }
        // Selection sort :))
        for (int i = 0; i < numBooks - 1; i++) {
            int maxProfitIndex = i;
            for (int j = i + 1; j < numBooks; j++) {
                if (books[j].getInterest() > books[maxProfitIndex].getInterest()) {
                    maxProfitIndex = j;
                }
            }
            Book temp = books[i];
            books[i] = books[maxProfitIndex];
            books[maxProfitIndex] = temp;
        }

        System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần:");
        for (int i = 0; i < numBooks; i++) {
            System.out.println("Sách thứ " + (i + 1) + ":");
            books[i].displayBook();
        }
    }

    private boolean checkBookName(String bookName) {
        boolean found = false;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookName().equalsIgnoreCase(bookName)) {
                System.out.println("Kết quả tìm kiếm:");
                books[i].displayBook();
                found = true;
                break;
            }
        }
        return found;
    }

    // tìm sách
    private void searchBooksByName(Scanner scanner) {
        boolean found = false;
        while (!found) {
            System.out.println("Nhập tên sách cần tìm (hoặc nhập 'exit' để thoát): ");
            String bookName = scanner.nextLine();

            if (bookName.equalsIgnoreCase("exit")) {
                System.out.println("Đã thoát khỏi chức năng tìm kiếm sách theo tên.");
                break;
            }

            found = checkBookName(bookName);

            if (!found) {
                System.out.println("Không tìm thấy sách với tên: " + bookName);
            }
        }
    }

    // thống kê số lượng theo năm xuất bản
    private void statisticsByYear() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        int[] years = new int[numBooks];
        int[] bookCounts = new int[numBooks];

        for (int i = 0; i < numBooks; i++) {
            years[i] = books[i].getYear();
            bookCounts[i] = 1;
        }

        for (int i = 0; i < numBooks; i++) {
            for (int j = i + 1; j < numBooks; j++) {
                if (years[i] == years[j]) {
                    bookCounts[i]++;
                    years[j] = -1;
                }
            }
        }

        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int i = 0; i < numBooks; i++) {
            if (years[i] != -1) {
                System.out.println("Năm " + years[i] + ": " + bookCounts[i] + " cuốn sách.");
            }
        }
    }


    private void statisticsByAuthor() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        // Tạo một mảng song song để lưu trữ số lượng sách của mỗi tác giả
        String[] authors = new String[numBooks];
        int[] bookCounts = new int[numBooks];

        // giá trị count ban đầu là 1 vì , có 1 tác giả thì phải có 1 sách
        for (int i = 0; i < numBooks; i++) {
            authors[i] = books[i].getAuthor();
            bookCounts[i] = 1;
        }

        // Đếm
        for (int i = 0; i < numBooks; i++) {
            for (int j = i + 1; j < numBooks; j++) {
                if (authors[i].equals(authors[j])) {
                    // Nếu ông tg tại vị trí j giống với ông tg tại vị trí i, tăng số lượng sách tại vị trí i lên 1
                    bookCounts[i]++;
                    // Để tránh đếm lại tác giả đã xét, thì cho ông tác giả ở vị trí j thành ""
                    authors[j] = "";
                }
            }
        }

        // In thông tin số lượng sách của mỗi tác giả
        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < numBooks; i++) {
            if (!authors[i].isEmpty()) {
                System.out.println("Tác giả " + authors[i] + ": " + bookCounts[i] + " cuốn sách.");
            }
        }
    }


    private void statisticsByAuthor2() {
        if (numBooks == 0) {
            System.out.println("No books available.");
            return;
        }

        // Sử dụng HashMap để đếm số lượng sách của mỗi tác giả
        HashMap<String, Integer> bookCountByAuthor = new HashMap<>();

        for (int i = 0; i < numBooks; i++) {
            String author = books[i].getAuthor();
            bookCountByAuthor.put(author, bookCountByAuthor.getOrDefault(author, 0) + 1);
        }

        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (String author : bookCountByAuthor.keySet()) {
            int count = bookCountByAuthor.get(author);
            System.out.println("Tác giả " + author + ": " + count + " cuốn sách.");
        }
    }

}


//    private static void sortBooksByExportPriceAscending() {
//        Collections.sort(books, Comparator.comparing(Book::getExportPrice));
//        displayBooks();
//    }
//
//    private static void sortBooksByProfitDescending() {
//        Collections.sort(books, Comparator.comparing(Book::getInterest).reversed());
//        displayBooks();
//    }