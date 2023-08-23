package controller;

import imp.Category;
import imp.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public ProductManager() {
    }

    //     Hiển thị toàn bộ thông tin sản phẩm
    public void displayProduct(Category selectedCategory, InventoryManagement inventoryManagement) {
        try {
            // selected category must not Null
            System.out.println("***** Danh sách sản phẩm ở danh mục " + selectedCategory.getName() + " *****");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20f %-20f %-20f %-20s %-20s %20s\n",
                    "ProductID", "Tên", "Giá nhập", "Giá xuất", "Lợi nhuận", "Mô tả", "Trạng thái", "Tên danh mục");
            for (Product item : selectedCategory.getProductList()) {
                item.displayData(inventoryManagement.getCategoryList());
            }
            System.out.println("---------------------------------------------------------------");
        } catch (NullPointerException e) {
            System.err.println("Danh mục đang chọn bị NUll");
        }
    }

    public void addProduct(Scanner scanner, Category selectedCategory) {
        System.out.println("Nhập só lượng cần thêm");
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Lỗi : input không phải là số ! ");
            }
        }
        for (int i = 0; i < number; i++) {
            Product product = new Product(selectedCategory.getId());
            product.inputData(scanner, selectedCategory.getProductList());
            selectedCategory.getProductList().add(product);
        }
    }


    // Cập nhật giá sản phẩm theo mã
    public void updateProduct(Category selectedCategory, Scanner scanner) {
        try {
            System.out.println("** Hãy nhập tên hoặc mã sản phẩm cần tìm để thực hiện cập nhật thông tin");
            String input = scanner.nextLine();
            // logic
            for (Product item : selectedCategory.getProductList()) {
                if (item.getId().equals(input) || item.getName().equals(input)) {
                    System.out.println(ColorText.GREEN_BRIGHT + "Đã tìm thấy sản phẩm : " + item.getName() + ColorText.RESET);
                    // update Information
                    System.out.println("***** Tiến hành cập nhật *****");
                    item.inputData(scanner, selectedCategory.getProductList());
                    break;
                } else
                    System.err.println("Sản phẩm không tìm thấy, vui lòng nhập chính xác id, hoặc tên của sản phẩm !");
            }
        } catch (NullPointerException e) {
            System.err.println("Danh mục đang chọn bị NUll");
        }
    }

    // xoá sản phẩm
    public void deleteProduct(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.println("Nhập tên hoặc mã sản phẩm cần xoá: ");
            String input = scanner.nextLine();
            for (Product item : selectedCategory.getProductList()) {
                if (item.getId().equals(input) || item.getName().equals(input)) {
                    System.out.println(ColorText.GREEN_BRIGHT + "Đã tìm thấy sản phẩm " + item.getName() + ColorText.RESET);
                    System.out.println("Bạn có chắc muốn xoá nhấn ( yes ) để xoá, hoặc ( no ) để thoát");
                    do {
                        String command = scanner.nextLine().toLowerCase();

                        if (command.equals("yes")) {
                            selectedCategory.getProductList().remove(item);
                        } else if (command.equals("no")) {
                            System.out.println("Đã huỷ lệnh xoá");
                            break;
                        } else {
                            System.err.println("Nhập không đúng lệnh, hãy nhập lại lệnh ( yes or no ) ");
                        }
                    } while (true);
                    break;
                }
            }
        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }

    // xắp xếp A-Z theo tên sản phẩm
    public void sortProductByNameAToZ(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.getProductList().sort(Comparator.comparing(Product::getName));
            System.out.println(ColorText.GREEN_BRIGHT + "Xắp xếp sản phẩm A-Z thành công" + ColorText.RESET);
        } else
            System.err.println("Danh mục đang chọn bị NUll");

    }

    // xắp xếp lợi nhuận cao đến thấp
    public void sortProductByProfitHighToLow(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.getProductList().sort(Comparator.comparingDouble(Product::getProfit).reversed());
            System.out.println(ColorText.GREEN_BRIGHT + "Xắp xếp lợi nhuận cao-thấp thành công" + ColorText.RESET);
        } else
            System.err.println("Danh mục đang chọn bị NUll");

    }

    // Tìm kiếm sản phẩm theo tên hoặc id
    public void findProductByName(Category selectedCategory, List<Category> categoryList, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.println("Nhập tên hoặc id sản phẩm cần tìm kiếm");
            String input = scanner.nextLine();
            for (Product item : selectedCategory.getProductList()) {
                if (item.getName().equals(input) || item.getId().equals(input)) {
                    System.out.println("Sản phẩm tìm kiếm được là :");
                    System.out.println("-----------------------------------------------------");
                    System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %20s\n",
                            "IDProduct",
                            "Name",
                            "Giá nhập",
                            "Giá xuất",
                            "Lợi nhuận",
                            "Mô tả",
                            "Trạng thái",
                            "Tên danh mục"
                    );
                    item.displayData(categoryList);
                    System.out.println("-----------------------------------------------------");
                    break;
                } else
                    System.out.println("Sản phẩm không tồn tại");
            }
        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }
}

