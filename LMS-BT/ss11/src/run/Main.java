package run;

import btth.Category;
import btth.Product;
import controller.CategoriesManager;
import controller.ProductManager;
import controller.ShopManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Reset
        final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        final String BLACK = "\033[0;30m";   // BLACK
        final String RED = "\033[0;31m";     // RED
        final String GREEN = "\033[0;32m";   // GREEN
        final String YELLOW = "\033[0;33m";  // YELLOW
        final String BLUE = "\033[0;34m";    // BLUE
        final String PURPLE = "\033[0;35m";  // PURPLE
        final String CYAN = "\033[0;36m";    // CYAN
        final String WHITE = "\033[0;37m";   // WHITE
        System.out.println();

        // Bold
        final String BLACK_BOLD = "\033[1;30m";  // BLACK
        final String RED_BOLD = "\033[1;31m";    // RED
        final String GREEN_BOLD = "\033[1;32m";  // GREEN
        final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        final String BLUE_BOLD = "\033[1;34m";   // BLUE
        final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        final String CYAN_BOLD = "\033[1;36m";   // CYAN
        final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        final String RED_UNDERLINED = "\033[4;31m";    // RED
        final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        final String RED_BACKGROUND = "\033[41m";    // RED
        final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        final String RED_BRIGHT = "\033[0;91m";    // RED
        final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

        ShopManagement shopManagement = new ShopManagement();
        ProductManager productManager = new ProductManager();
        CategoriesManager categoriesManager = shopManagement.getCategoriesManager();
        List<Category> categoryList = shopManagement.getCategoriesManager().getCategoryList();
        Category selectedCategory = null;
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***************************MENU*************************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    int categoryChoice;
                    do {
                        System.out.println("***************** CATALOG MANAGEMENT *****************\n" +
                                "1. Thêm mới danh mục\n" +
                                "2. Hiển thị thông tin các danh mục\n" +
                                "3. Cập nhật tên danh mục theo mã danh mục\n" +
                                "4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)\n" +
                                "5. Thoát (Quay lại Shop Management)");
                        categoryChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (categoryChoice) {
                            case 1 -> categoriesManager.addCategories(scanner);
                            case 2 -> categoriesManager.disPlayCategory();
                            case 3 -> categoriesManager.updateNameCategory(scanner);
                            case 4 -> {
                                System.out.println("Nhập Id của danh mục mà bạn muốn xoá: ");
                                int id = scanner.nextInt();
                                categoriesManager.deleteCategory(id);
                            }
                            case 5 -> System.out.println("Đã quay về Shop Management");
                            default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                        }
                    } while (categoryChoice != 5);
                }
                case 2 -> {
                    // quay về menu nếu không có danh mục nào
                    if (shopManagement.getCategoriesManager().getCategoryList().isEmpty()) {
                        System.err.println("Hiện tại danh sách các danh mục hiện đang trống" +
                                " cần lựa chọn 1 để vào MENU danh mục để thêm danh mục trước");
                        continue;
                    }
                    int productChoice;
                    do {
                        System.out.println("***************** PRODUCT MANAGEMENT *****************\n" +
                                "0. Chọn danh mục chứa sản phẩm\n" +
                                "1. Thêm mới sản phẩm\n" +
                                "2. Hiển thị thông tin sản phẩm\n" +
                                "3. Cập nhật giá sản phẩm theo mã sản phẩm\n" +
                                "4. Xóa sản phẩm theo mã sản phẩm\n" +
                                "5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                                "6. Sắp xếp sản phẩm theo tên tăng dần\n" +
                                "7. Thống kê số lượng sản phẩm theo danh mục sản phẩm\n" +
                                "8. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                                "9. Thoát (Quay lại Shop Management)\n" +
                                "**** Nhập lựa chọn của bạn ****\n");
                        // nhập lệnh chọn
                        productChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (productChoice) {
                            case 0 -> {
                                System.out.println("**** Danh sách danh mục ****");
                                // lựa chọn danh mục
                                selectedCategory = categoriesManager.selectCategory(shopManagement.getCategoriesManager());
                            }
                            case 1 -> {
                                if (selectedCategory == null) {
                                    System.err.println("Bạn chưa chọn danh mục !, nhập lệnh ( 0 ) để chọn danh mục trước.");
                                    break;
                                }
                                // lấy productList từ selected ra
                                Product product = new Product();
                                product.inputData(scanner, selectedCategory.getProductList());
                                // set idCatagory mà product thuộc về
                                product.setCategoryId(selectedCategory.getCategoryId());
                                // add vào product vào category
                                selectedCategory.addProduct(product);
                            }
                            // các case sau trong phương thức đã có check != null rồi
                            case 2 -> productManager.displayProduct(selectedCategory);
                            case 3 -> productManager.updatePrice(selectedCategory, scanner);
                            case 4 -> productManager.deleteProduct(selectedCategory, scanner);
                            case 5 -> productManager.sortProductByPriceLowToHigh(selectedCategory);
                            case 6 -> productManager.sortProductByNameLowToHigh(selectedCategory);
                            case 7 -> productManager.StatisticProductOfEachCategory(categoryList);
                            case 8 -> productManager.findProductByName(selectedCategory, scanner);
                            case 9 -> System.out.println("Đã quay về Shop Management");
                            default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                        }

                    }
                    while (productChoice != 9);
                }
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
        while (choice != 10);
    }
}
