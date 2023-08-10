import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmailManagementApp {
    private final ArrayList<String> emailList;
    private final Scanner scanner;

    public EmailManagementApp() {
        emailList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addEmailToList();
                    break;
                case 2:
                    viewEmailList();
                    break;
                case 3:
                    removeEmailFromList();
                    break;
                case 4:
                    checkValidEmail();
                    break;
                case 5:
                    sortEmailList();
                    break;
                case 6:
                    countValidEmails();
                    break;
                case 7:
                    countInvalidEmails();
                    break;
                case 8:
                    System.out.println("Ứng dụng đã kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 8);
    }

    private void displayMenu() {
        System.out.println("\n===== Quản lý danh sách email =====");
        System.out.println("1. Thêm email vào danh sách");
        System.out.println("2. Xem danh sách email");
        System.out.println("3. Xóa email khỏi danh sách");
        System.out.println("4. Kiểm tra email hợp lệ");
        System.out.println("5. Sắp xếp danh sách email");
        System.out.println("6. Đếm số lượng email hợp lệ");
        System.out.println("7. Đếm số lượng email không hợp lệ");
        System.out.println("8. Thoát");
        System.out.print("Vui lòng chọn chức năng: ");
    }

    private void addEmailToList() {
        System.out.print("Nhập địa chỉ email muốn thêm: ");
        String email = scanner.nextLine();
        if (isValidEmail(email)) {
            emailList.add(email);
            System.out.println("Thêm email thành công.");
        } else {
            System.out.println("Địa chỉ email không hợp lệ. Thêm thất bại.");
        }
    }

    private void viewEmailList() {
        if (emailList.isEmpty()) {
            System.out.println("Danh sách email rỗng.");
        } else {
            System.out.println("Danh sách email:");
            for (String email : emailList) {
                System.out.println(email);
            }
        }
    }

    private void removeEmailFromList() {
        System.out.print("Nhập địa chỉ email muốn xóa: ");
        String email = scanner.nextLine();
        if (emailList.remove(email)) {
            System.out.println("Xóa email thành công.");
        } else {
            System.out.println("Email không tồn tại trong danh sách. Xóa thất bại.");
        }
    }

    private void checkValidEmail() {
        System.out.print("Nhập địa chỉ email cần kiểm tra: ");
        String email = scanner.nextLine();
        if (isValidEmail(email)) {
            System.out.println("Địa chỉ email hợp lệ.");
        } else {
            System.out.println("Địa chỉ email không hợp lệ.");
        }
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailPattern);
    }

    private void sortEmailList() {
        if (emailList.isEmpty()) {
            System.out.println("Danh sách email rỗng.");
            return;
        }

        System.out.println("Chọn thứ tự sắp xếp:");
        System.out.println("1. Thứ tự tăng dần");
        System.out.println("2. Thứ tự giảm dần");
        System.out.print("Vui lòng chọn: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sortChoice) {
            case 1:
                Collections.sort(emailList);
                System.out.println("Danh sách email đã được sắp xếp theo thứ tự tăng dần.");
                break;
            case 2:
                Collections.sort(emailList, Collections.reverseOrder());
                System.out.println("Danh sách email đã được sắp xếp theo thứ tự giảm dần.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void countValidEmails() {
        int validCount = 0;
        for (String email : emailList) {
            if (isValidEmail(email)) {
                validCount++;
            }
        }
        System.out.println("Số lượng email hợp lệ trong danh sách: " + validCount);
    }

    private void countInvalidEmails() {
        int invalidCount = 0;
        for (String email : emailList) {
            if (!isValidEmail(email)) {
                invalidCount++;
            }
        }
        System.out.println("Số lượng email không hợp lệ trong danh sách: " + invalidCount);
    }

    public static void main(String[] args) {
        EmailManagementApp app = new EmailManagementApp();
        app.run();
    }
}
