import controller.CategoryManager;
import controller.ColorText;
import controller.InventoryManagement;
import controller.ProductManager;
import imp.Category;

import java.util.InputMismatchException;
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
        do {
            System.out.println(ColorText.YELLOW_BRIGHT + "************ MENU ************");
            System.out.println("* 1. Quản lý danh mục sản phẩm");
            System.out.println("* 2. Quản lý sản phẩm");
            System.out.println("* 3. Thoát");
            System.out.println("******************************");
            System.out.print("Chọn một chức năng (1-3): " + ColorText.RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    int categoryChoice;
                    do {
                        System.out.println(ColorText.CYAN_BRIGHT +
                                "********************* CATALOG MANAGEMENT *********************\n" +
                                "* 1. Thêm mới danh mục\n" +
                                "* 2. Hiển thị thông tin các danh mục\n" +
                                "* 3. Cập nhật tên danh mục theo mã danh mục\n" +
                                "* 4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)\n" +
                                "* 5. Thoát (Quay lại Shop Management)");
                        System.out.println("*************************************************************" + ColorText.RESET);
                        categoryChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (categoryChoice) {
                            case 1 -> categoryManager.addCategory(scanner, categoryList);
                            case 2 -> categoryManager.displayCategory(categoryList);
                            case 3 -> categoryManager.updateNameCategory(scanner, categoryList);
                            case 4 -> categoryManager.deleteCategory(scanner, categoryList);
                            case 5 -> System.out.println(ColorText.GREEN_BRIGHT +
                                    " Đã quay về Shop Management" + ColorText.RESET);
                            default -> System.err.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại !");
                        }
                    } while (categoryChoice != 5);
                }
                case 2 -> {
                    // quay về menu nếu không có danh mục nào
                    if (inventoryManagement.getCategoryList().isEmpty()) {
                        System.err.println("Truy cập bị từ chối vì hiện tại chưa có danh mục nào !");
                        continue;
                    }
                    int productChoice;
                    do {
                        System.out.println("***************** PRODUCT MANAGEMENT *****************\n" +
                                "* 0. Chọn danh mục muốn vào\n" +
                                "* 1. Thêm mới sản phẩm\n" +
                                "* 2. Hiển thị thông tin sản phẩm\n" +
                                "* 3. Cập nhật giá sản phẩm theo mã sản phẩm\n" +
                                "* 4. Xóa sản phẩm theo mã sản phẩm\n" +
                                "* 5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                                "* 6. Sắp xếp sản phẩm theo tên tăng dần\n" +
                                "* 7. Thống kê số lượng sản phẩm theo danh mục sản phẩm\n" +
                                "* 8. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                                "* 9. Thoát (Quay lại Shop Management)\n" +
                                "****************************************************\n");
                        // nhập lệnh chọn
                        productChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (productChoice) {
                            case 0 -> {
                                System.out.println("------------- Danh sách danh mục -------------");
                                // lựa chọn danh mục
                                selectedCategory = categoryManager.selectCategory(inventoryManagement, scanner);
                            }
                            case 1 -> {
                                if (selectedCategory == null) {
                                    System.err.println(" Bạn chưa chọn danh mục !, " +
                                            "nhập lệnh ( 0 ) để chọn danh mục trước.");
                                    break;
                                }
                                // Create và add vào category
                                productManager.addProduct(scanner, selectedCategory);
                            }
                            case 2 -> productManager.displayProduct(selectedCategory, inventoryManagement);
                            case 3 -> productManager.updateProduct(selectedCategory, scanner);
                            case 4 -> productManager.deleteProduct(selectedCategory, scanner);
                            case 5 -> productManager.sortProductByNameAToZ(selectedCategory);
                            case 6 -> productManager.sortProductByProfitHighToLow(selectedCategory);
                            case 8 -> productManager.findProductByName(selectedCategory, categoryList, scanner);
                            case 9 -> System.out.println(ColorText.GREEN_BRIGHT +
                                    " Đã quay về Shop Management" + ColorText.RESET);
                            default -> System.out.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại ! ");
                        }

                    }
                    while (productChoice != 9);
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
