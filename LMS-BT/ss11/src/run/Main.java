package run;

import BTTH.ra.Category;
import BTTH.ra.Product;
import Controller.CategoriesManager;
import Controller.ProductManager;
import Controller.ShopManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    if (shopManagement.getCategoriesManager().getCategoryList().isEmpty()) {
                        System.err.println("Hiện tại danh sách các danh mục hiện đang trống" +
                                " cần lựa chọn 1 để vào MENU danh mục để thêm danh mục trước");
                        continue;
                    }
                    int productChoice;
                    do {
                        System.out.println("***************** PRODUCT MANAGEMENT *****************\n" +
                                "1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm mà sản phẩm thuộc về)\n" +
                                "2. Hiển thị thông tin sản phẩm\n" +
                                "3. Cập nhật giá sản phẩm theo mã sản phẩm\n" +
                                "4. Xóa sản phẩm theo mã sản phẩm\n" +
                                "5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần\n" +
                                "6. Sắp xếp sản phẩm theo tên tăng dần\n" +
                                "7. Thống kê số lượng sản phẩm theo danh mục sản phẩm\n" +
                                "8. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                                "9. Thoát (Quay lại Shop Management)\n" +
                                "**** Nhập lựa chọn của bạn ****\n");
                        productChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (productChoice) {
                            case 1 -> {
                                // Thực hiện tìm kiếm ở hàm selectCategory
                                if (selectedCategory == null)
                                    selectedCategory = productManager.selectCategory(shopManagement.getCategoriesManager());
                                // lấy productList từ selected ra
                                Product product = new Product();
                                product.inputData(scanner, selectedCategory.getProductList());
                                // set idCatagory mà product thuộc về
                                product.setCategoryId(selectedCategory.getCategoryId());
                                // add vào product vào category
                                selectedCategory.addProduct(product);
                            }
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
