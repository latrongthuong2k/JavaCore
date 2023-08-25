package controller;


import imp.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryManager {

    // NOTE : 1 Category Manager have 1 list Category

    /**
     * Constructor của categoryManager
     */
    public CategoryManager() {
    }

    /**
     * Phương thức thêm category
     *
     * @param scanner      : Đối tượng scanner
     * @param categoryList : Danh sách các category của đối tượng Inventory ( Kho )
     */
    public void addCategory(Scanner scanner, List<Category> categoryList) {
        System.out.print("-- Nhập só lượng cần thêm: ");
        int number;
        while (true) {
            try {
                /**
                 * Thực hiện lấy số lượng, nếu parse không ra số thì ném ra lỗi
                 * và chạy lại vòng lặp mới
                 * nếu ok thì thoát vòng lặp
                 */
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Lỗi : :( input phải là số. Xin hãy nhập lại số lượng !");
            }
        }
        /**
         * Vòng lặp thêm dựa theo số lượng yêu cầu
         * -> Tạo mới
         * -> Thêm vào categoryList
         * -> Thông báo thành công
         */
        for (int i = 0; i < number; i++) {
            Category category = new Category();
            category.inputData(scanner, categoryList);
            categoryList.add(category);
            System.out.println(ColorText.GREEN_BRIGHT + "Thêm thành công ^_^ " + ColorText.RESET);
        }
    }

    /**
     * Phương thức hiển thị toàn bộ các category có trong 1 danh sách của Inventory
     *
     * @param categoryList : tham chiếu đến một danh sách category nào đó của Inventory
     */
    public void displayCategory(List<Category> categoryList) {
        System.out.println("-- Hiện có tổng: " + categoryList.size() + ", danh mục trong kho --");
        System.out.println("---------------------------------------------------------------");
        System.out.printf(ColorText.WHITE_BOLD_BRIGHT + "%-10s %-20s %-20s %-20s\n" + ColorText.RESET,
                "ID", "Tên danh mục", "Mô tả", "Trạng thái");
        for (Category item : categoryList) {
            item.displayData();
        }
        System.out.println("---------------------------------------------------------------");
    }

    /**
     * Phương thức Update category
     *
     * @param scanner      : tham chiếu đến scanner bên ngoài
     * @param categoryList : tham chiếu đến một danh sách category nào đó của Inventory
     */
    public void updateCategory(Scanner scanner, List<Category> categoryList) {
        if (!categoryList.isEmpty()) {
            System.out.print("-- Nhập tên hoặc id của category để cập nhật: ");
            /**
             * flag
             */
            boolean found = false;
            boolean idFound = false;
            boolean nameFound = false;

            while (!found) {
                try {
                    String input = scanner.nextLine();
                    int id;

                    try {
                        /**
                         * Thử đổi qua số nếu không được thì ném ra ngoại lệ
                         * Nếu ok thì so sánh với Id ( int ), và thực hiện inputData lại cho đối item
                         * -> Trong inputData có phương thức Update cụ thể cho đối tượng thay vì tạo mới
                         */
                        id = Integer.parseInt(input);

                        for (Category item : categoryList) {
                            if (item.getId() == id) {
                                System.out.println(ColorText.GREEN_BRIGHT + "Đã tìm thấy danh mục, " +
                                        "tiến hành cập nhật" + ColorText.RESET);
                                item.inputData(scanner, categoryList);
                                idFound = true;
                                break;
                            }
                        }
                        if (!idFound) {
                            System.err.println("Không có category Id : " + input + ", xin vui lòng nhập lại !");
                        }
                    } catch (NumberFormatException e) {
                        /**
                         * Ở ngoại lệ so sánh tên của các category (String)
                         */
                        for (Category item : categoryList) {
                            if (item.getName().equals(input)) {
                                System.out.println(ColorText.GREEN_BRIGHT + "Đã tìm thấy danh mục, " +
                                        "tiến hành cập nhật" + ColorText.RESET);
                                item.inputData(scanner, categoryList);
                                nameFound = true;
                                break;
                            }
                        }
                        if (!nameFound) {
                            System.err.println("Không có category tên: " + input + ", xin vui lòng nhập lại !");
                        }
                    }
                    /**
                     * -> Kết thúc update nếu tìm được tên hay id thì sẽ thoát vòng lặp
                     * -> Nếu không tìm được thì sẽ thông báo ở các else phía trên và chạy
                     * lại vòng lặp mới
                     */
                    if (idFound || nameFound)
                        found = true;
                } catch (NullPointerException e) {
                    System.err.println("Lỗi : " + e.getMessage());
                }
            }
        } else {
            System.err.println("Chưa có danh mục nào để cập nhật !");
        }
    }


    /**
     * カテゴリを削除するメソッド
     *
     * @param scanner      : 入力を受け取るスキャナー
     * @param categoryList : カテゴリのリスト
     */
    public void deleteCategory(Scanner scanner, List<Category> categoryList) {
        // Chạy các logic bên trong nếu categoryList không bị null, null thì thông báo ra
        if (!categoryList.isEmpty()) {

            // 削除対象のカテゴリのIDまたは名前を入力 : Nhập tên hoặc id để tìm kiếm rồi xoá
            System.out.print("-- Nhập Id hoặc tên danh mục cần xoá: ");
            String input;
            int id;
            boolean isIdFound = false;
            boolean isNameFound = false;
            boolean isFound = false;

            // 入力を受け取るループ : vòng lặp tìm kiếm
            while (!isFound) {
                input = scanner.nextLine();
                try {
                    // error test
                    id = Integer.parseInt(input);
                    // カテゴリリストをループして対応する名前のカテゴリを削除確認
                    for (Category item : categoryList) {
                        if (item.getId() == id) {
                            askForDeleteCallBackFunc(item, scanner, categoryList);
                            isIdFound = true;
                            break;
                        }
                    }
                    if (!isIdFound) {
                        System.err.println(" :( Không tìm thấy Id :" + input + ", xin hãy nhập lại !");
                    }

                } catch (NumberFormatException e) {
                    // カテゴリリストをループして対応する名前のカテゴリを削除確認
                    for (Category item : categoryList) {
                        if (item.getName().toLowerCase().equals(input)) {
                            askForDeleteCallBackFunc(item, scanner, categoryList);
                            isNameFound = true;
                            break;
                        }
                    }
                    if (!isNameFound) {
                        System.err.println(" :( Không tìm thấy tên :" + input + ", xin hãy nhập lại !");
                    }
                }
                if (isIdFound || isNameFound)
                    isFound = true;
            }


        } else
            System.err.println("Chưa có danh mục nào để xoá ! :( ");
    }

    /**
     * Phương thức phụ trợ cho phương thức deleteCategory
     *
     * @param item         : tham chiếu đối tượng truyền vào để xoá
     * @param scanner      : tham chiếu scanner
     * @param categoryList : tham chiếu danh sách thực hiện xoá lên
     */
    public void askForDeleteCallBackFunc(Category item, Scanner scanner, List<Category> categoryList) {
        System.out.println(ColorText.GREEN_BRIGHT +
                "Đã tìm thấy danh mục tên: " + item.getName() + ColorText.RESET);
        System.out.print(ColorText.YELLOW_BRIGHT +
                "Bạn có chắc muốn xoá nhấn ( yes ) để xoá, hoặc ( no ) để thoát: " + ColorText.RESET);
        do {
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("yes")) {
                categoryList.remove(item);
                System.out.println(ColorText.GREEN_BRIGHT +
                        " ^_^  Đã xoá danh mục tên: " + item.getName() + ColorText.RESET);
                break;
            } else if (command.equals("no")) {
                System.out.println(ColorText.GREEN_BRIGHT +
                        " *_*  Đã huỷ lệnh xoá " + ColorText.RESET + item.getName());
                break;
            } else {
                System.err.println(" *_* Nhập không đúng lệnh, hãy nhập lại lệnh ( yes or no ) ");
            }
        } while (true);
    }


    /**
     * @param categoryList : カテゴリリスト : tham chiếu danh sách category
     * @param scanner      : 入力を受け取るスキャナー : tham chiếu đối tượng scanner
     * @return : 選択されたカテゴリのインスタンス : Khi kết thúc trả về một Category
     */
    public Category selectCategory(List<Category> categoryList, Scanner scanner) {

        // 選択されたカテゴリを保持するオブジェクトを生成
        Category selectedCategory = null;

        if (!categoryList.isEmpty()) {
            // カテゴリリストを取得

            // ショップ内のカテゴリ数を表示
            System.out.println("-- Hiện tại có " + categoryList.size() + " danh mục trong shop --");
            // カテゴリリストをループして表示
            for (Category item : categoryList) {
                System.out.println(ColorText.WHITE_BRIGHT + "Danh mục ( " + item.getName() + " ) " +
                        "có id là ( " + item.getId() + " )" + ColorText.RESET);
            }
            // 削除対象のカテゴリのIDまたは名前を入力
            System.out.print("-- Nhập Id hoặc tên danh mục để vào: ");
            String input;
            int id;
            boolean isIdFound = false;
            boolean isNameFound = false;
            boolean isFound = false;

            // 入力を受け取るループ
            while (!isFound) {
                input = scanner.nextLine();
                try {
                    // error test
                    id = Integer.parseInt(input);
                    // カテゴリリストをループして対応する名前のカテゴリを削除確認
                    for (Category item : categoryList) {
                        if (item.getId() == id) {
                            selectedCategory = item;
                            isIdFound = true;
                            break;
                        }
                    }
                    if (!isIdFound) {
                        System.err.println(":( Không tìm thấy Id: " + input + ", xin hãy nhập lại!");
                    }
                } catch (NumberFormatException e) {
                    // カテゴリリストをループして対応する名前のカテゴリを削除確認
                    for (Category item : categoryList) {
                        if (item.getName().toLowerCase().equals(input)) {
                            selectedCategory = item;
                            isNameFound = true;
                            break;
                        }
                    }
                    if (!isNameFound) {
                        System.err.println(":( Không tìm thấy tên: " + input + ", xin hãy nhập lại!");
                    }
                }
                if (isIdFound || isNameFound) {
                    isFound = true;
                    System.out.println(ColorText.GREEN_BOLD_BRIGHT + "Danh mục hiện tại đang chọn là : "
                            + selectedCategory.getName() + ColorText.RESET);
                }
            }
        } else
            System.err.println("Chưa có danh mục nào để chọn ! :( ");
        // 選択されたカテゴリを返す , trả về địa chỉ tham chiếu item trong danh sách category
        return selectedCategory;
    }
}
