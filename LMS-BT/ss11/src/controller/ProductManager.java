package controller;

import btth.Category;
import btth.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManager {

    public ProductManager() {
    }

    //     Hiển thị toàn bộ thông tin sản phẩm
    public void displayProduct(Category selectedCategory) {
        if (selectedCategory != null) {
            System.out.println("***** Danh sách sản phẩm ở danh mục " + selectedCategory.getCategoryName() + " *****");
            selectedCategory.displayProducts();
        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }

    // Cập nhật giá sản phẩm theo mã
    public void updatePrice(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.println("Nhập mã sản phẩm cần cập nhật giá");
            String idProduct = scanner.nextLine();
            scanner.nextLine();
            boolean isFined = true;

            for (Product item : selectedCategory.getProductList()) {
                if (item.getProductId().equals(idProduct)) {
                    System.out.println("Đã tìm thấy sản phẩm " + item.getProductName() +
                            ", Id " + item.getProductId() +
                            ", ở danh mục có id là: " + item.getCategoryId());
                    do {
                        System.out.println("Giá cũ: " + item.getPrice());
                        System.out.println("Nhập giá mới cho sản phẩm: ");
                        String input = scanner.nextLine();
                        if (input.isEmpty() || !input.matches("\\d+")) {
                            System.out.println("Chỉ được nhập số cho giá sản phẩm, hãy nhập lại");
                        } else {
                            int newPrice = Integer.parseInt(input);
                            item.setPrice(newPrice);
                            System.out.println("*** Giá của ( " + item.getProductName() + " ) đã được cập nhật thành công ***");
                            item.displayData();
                            break;
                        }
                    } while (true);
                    break;
                }
                if (!isFined)
                    System.err.println("Sản phẩm không tìm thấy, vui lòng nhập chính xác id của sản phẩm !");
            }

        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }

    // xoá sản phẩm
    public void deleteProduct(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.println("Nhập mã sản phẩm cần xoá");
            String idProduct = scanner.nextLine();
            scanner.nextLine();
            for (Product item : selectedCategory.getProductList()) {
                if (item.getProductId().equals(idProduct)) {
                    System.out.println("Đã tìm thấy sản phẩm " + item.getProductName() +
                            ", Id " + item.getProductId() +
                            ", ở danh mục " + item.getProductId());
                    System.out.println("Bạn có chắc muốn xoá nhấn ( Yes ) để xoá, hoặc ( No ) để thoát");
                    do {
                        String command = scanner.nextLine();

                        if (command.isEmpty() || !command.equals("Yes") && !command.equals("No")) {
                            System.err.println("Nhập không đúng lệnh, hãy nhập lại lệnh ( Yes or No ) ");
                        } else if (command.equals("Yes")) {
                            selectedCategory.removeProduct(idProduct);
                            break;
                        } else {
                            System.out.println("Đã huỷ lệnh xoá");
                            break;
                        }
                    } while (true);
                    break;
                }
            }

        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }

    // xắp xếp tăng dần theo giá
    public void sortProductByPriceLowToHigh(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.sortProductByIdLowToHigh();
            System.out.println("Xắp xếp tăng dần theo giá thành công");
        } else
            System.err.println("Danh mục đang chọn bị NUll");

    }

    // xắp xếp tăng dần theo tên
    public void sortProductByNameLowToHigh(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.sortProductByNameLowToHigh();
            System.out.println("Xắp xếp tăng dần theo tên thành công");
        } else
            System.err.println("Danh mục đang chọn bị NUll");

    }

    // Thốnd kê sản lượng sản phẩm theo danh mục sản phẩm
    public void StatisticProductOfEachCategory(List<Category> categoryList) {
        for (Category category : categoryList) {
            System.out.println("Danh mục " + category.getCategoryName() +
                    " với Id: " + category.getCategoryId() +
                    ", có: " + category.getProductList().size() + " sản phẩm.");
        }
    }

    // Tìm kiếm sản phẩm theo tên
    public void findProductByName(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.println("Nhập tên sản phẩm cần tìm kiếm");
            String nameProduct = scanner.nextLine();
            for (Product item : selectedCategory.getProductList()) {
                if (item.getProductName().equals(nameProduct)) {
                    System.out.println("Sản phẩm tìm kiếm được là :");
                    item.displayData();
                    break;
                } else
                    System.out.println("Sản phẩm không tồn tại");
            }
        } else
            System.err.println("Danh mục đang chọn bị NUll");
    }
}

