import controller.CategoryManager;
import controller.ColorText;
import controller.InventoryManagement;
import controller.ProductManager;
import imp.Category;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instance inventoryManagement
        InventoryManagement inventoryManagement = new InventoryManagement();
        List<Category> categoryList = inventoryManagement.getCategoryList();
        // Instance manager
        ProductManager productManager = new ProductManager();
        CategoryManager categoryManager = new CategoryManager();
        // Instance
        Category selectedCategory = null;
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(ColorText.YELLOW_BRIGHT + "************ MENU ************");
            System.out.println("* 1. Quản lý danh mục sản phẩm");
            System.out.println("* 2. Quản lý sản phẩm");
            System.out.println("* 3. Thoát");
            System.out.println("******************************");
            System.out.println();
            System.out.print("Chọn một chức năng (1-3): " + ColorText.RESET);
            /**
             * Check lỗi Input cho choice
             */
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.err.println("Lệnh chọn không hợp lệ! Vui lòng nhập số.");
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1 -> {
                    int categoryChoice;
                    /**
                     * MENU CATALOG MANAGEMENT
                     */
                    do {
                        System.out.println(ColorText.CYAN_BRIGHT +
                                "*********************** CATEGORY MENU ***********************\n" +
                                "* 1. Thêm mới danh mục\n" +
                                "* 2. Hiển thị thông tin các danh mục\n" +
                                "* 3. Cập nhật danh mục\n" +
                                "* 4. Xóa danh mục (Danh mục chưa chứa sản phẩm)\n" +
                                "* 5. Tìm kiếm danh mục theo tên" +
                                "* 5. Thoát (Quay lại kho)");
                        System.out.println("*****************************************************************");
                        System.out.println();
                        System.out.print("Chọn một chức năng (1-5): " + ColorText.RESET);

                        /**
                         * Check input để không nhập gì ngoài số
                         */
                        while (true) {
                            if (scanner.hasNextInt()) {
                                categoryChoice = scanner.nextInt();
                                break;
                            } else {
                                System.err.println(" * Lệnh chọn không hợp lệ! Vui lòng nhập số.");
                                scanner.nextLine();
                            }
                        }
                        scanner.nextLine();
                        switch (categoryChoice) {
                            case 1 ->
                                // Thêm danh mục
                                    categoryManager.addCategory(scanner, categoryList);
                            case 2 ->
                                // Hiển thị bảng danh mục
                                    categoryManager.displayCategory(categoryList);
                            case 3 ->
                                // Cập nhật danh mục
                                    categoryManager.updateCategory(scanner, categoryList);
                            case 4 ->
                                //  Xoá danh mục
                                    categoryManager.deleteCategory(scanner, categoryList);
                            case 5 ->
                                // Quay về kho
                                    System.out.println(ColorText.GREEN_BRIGHT +
                                            " Đã quay về kho" + ColorText.RESET);
                            default -> System.err.println(" * Lựa chọn không hợp lệ. Vui lòng chọn lại !");
                        }

                    } while (categoryChoice != 5);
                }
                case 2 -> {
                    /**
                     * Quay về menu nếu chưa có danh mục nào để thêm sản phẩm
                     */
                    if (inventoryManagement.getCategoryList().isEmpty()) {
                        System.err.println("Truy cập bị từ chối vì hiện tại chưa có danh mục nào !");
                        return;
                    }
                    int productChoice;
                    /**
                     * MENU PRODUCT MANAGEMENT
                     */
                    do {
                        System.out.println("""
                                 ----------------- PRODUCT MENU -----------------
                                 * 0. Chọn danh mục muốn vào
                                 * 1. Thêm mới sản phẩm
                                 * 2. Hiển thị thông tin sản phẩm
                                 * 3. Cập nhật sản phẩm 
                                 * 4. Xóa sản phẩm 
                                 * 5. Hiển thị sản phẩm theo A-Z
                                 * 6. Hiển thị sản phẩm theo lợi nhuận cao-thấp
                                 * 7. Tìm kiếm sản phẩm
                                 * 8. Thoát (Quay lại kho)
                                -------------------------------------------------
                                 """);
                        System.out.print("-- Chọn một chức năng (0-8): ");
                        /**
                         * Nhập lệnh
                         * -> check phải là số
                         */
                        while (true) {
                            if (scanner.hasNextInt()) {
                                productChoice = scanner.nextInt();
                                break;
                            } else {
                                System.err.println(" * Lệnh chọn không hợp lệ! Vui lòng nhập số.");
                            }
                        }
                        scanner.nextLine(); // xoá bộ nhớ đệm scanner
                        switch (productChoice) {
                            case 0 -> {
                                System.out.println("------------- Danh sách danh mục -------------");
                                /**
                                 * selectedCategory sẽ tham chiếu đến một item bên trong categoryList
                                 * mà hàm selectCategory đã trả về sau khi lọc từ categoryList
                                 */
                                selectedCategory = categoryManager.selectCategory(categoryList, scanner);
                            }
                            case 1 ->
                                // Thêm sản phẩm
                                    productManager.addProduct(selectedCategory, scanner);

                            case 2 ->
                                // Hiển thị san phẩm
                                    productManager.displayProduct(selectedCategory, categoryList);

                            case 3 ->
                                // Cập nhật sản phẩm
                                    productManager.updateProduct(selectedCategory, scanner);
                            case 4 ->
                                // xoá sản phẩm
                                    productManager.deleteProduct(selectedCategory, scanner);
                            case 5 ->
                                // sắp xếp sản phẩm từ A-Z
                                    productManager.sortProductByNameAToZ(selectedCategory);
                            case 6 ->
                                // sắp xếp sản phẩm theo lợi nhuận từ thấp đến cao
                                    productManager.sortProductByProfitHighToLow(selectedCategory);
                            case 7 ->
                                // Tìm sản phẩm theo tên
                                    productManager.findProductByName(selectedCategory, categoryList, scanner);
                            case 8 ->
                                // trở về kho
                                    System.out.println(ColorText.GREEN_BRIGHT +
                                            " Đã quay về kho" + ColorText.RESET);
                            default -> System.out.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại ! ");
                        }
                    }
                    while (productChoice != 8);
                }
                case 3 -> {
                    System.out.println("Đã thoát menu.");
                    System.exit(0);
                }
                default -> System.err.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
        while (true);
    }
}
