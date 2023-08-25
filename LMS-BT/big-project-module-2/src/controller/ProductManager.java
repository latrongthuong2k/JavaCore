package controller;

import imp.Category;
import imp.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public ProductManager() {
    }

    /**
     * Phương thức setup bảng và hiển thị toàn bộ sản phẩm ra bảng
     *
     * @param selectedCategory :  tham chiếu đên đối tượng danh mục chọn ở trong kho
     */
    public void displayProduct(Category selectedCategory, List<Category> categoryList) {
        try {
            // selected category must not Null
            System.out.println("***** Danh sách sản phẩm ở danh mục " + selectedCategory.getName() + " *****");
            System.out.println("---------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------------------");
            System.out.printf(ColorText.WHITE_BOLD_BRIGHT + "%-10s %-20s %-20s %-20s %-20s %-20s %-20s %20s\n" +
                            ColorText.RESET,
                    "ID", "Tên", "Giá nhập", "Giá xuất", "Lợi nhuận", "Mô tả", "Trạng thái", "Tên danh mục");
            for (Product item : selectedCategory.getProductList()) {
                item.displayData(categoryList);
            }
            System.out.println("---------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------");
        } catch (NullPointerException e) {
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll");
        }
    }

    /**
     * Phương thức thêm sản phẩm
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     * @param scanner:đối      tượng scanner để lấy input
     */
    public void addProduct(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.print("-- Nhập só lượng cần thêm :");
            int number;
            while (true) {
                try {
                    number = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi : *_* input không phải là số ! ");
                }
            }
            System.out.println("*********** Tiến hành thêm sản phẩm ***********");
            for (int i = 0; i < number; i++) {
                Product product = new Product(selectedCategory.getId());
                product.inputData(scanner, selectedCategory.getProductList());
                selectedCategory.getProductList().add(product);
                System.out.println(ColorText.GREEN_BRIGHT + " ^_^ Thêm thành công" + ColorText.RESET);
            }
        } else {
            System.err.println(" Bạn chưa chọn danh mục !, " + "nhập lệnh ( 0 ) để chọn danh mục trước.");
        }
    }

    /**
     * Cập nhật giá sản phẩm theo mã
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     * @param scanner          : đối tượng scanner để lấy input
     */
    public void updateProduct(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            boolean isFound = false;

            while (!isFound) {
                System.out.print("-- Hãy nhập tên hoặc mã sản phẩm cần tìm để thực hiện cập nhật :");
                String input = scanner.nextLine().toLowerCase();
                // logic
                if (selectedCategory.getProductList().isEmpty()) {
                    System.out.println(ColorText.YELLOW_BRIGHT + "Hiện :( không có sản phẩm nào tên" +
                            input + ColorText.RESET);
                    return;
                }
                for (Product item : selectedCategory.getProductList()) {
                    if (item.getId().toLowerCase().equals(input) || item.getName().toLowerCase().equals(input)) {
                        System.out.println(ColorText.GREEN_BRIGHT +
                                "Đã tìm thấy sản phẩm : " +
                                item.getName() + ColorText.RESET);

                        isFound = true;
                        // update Information
                        System.out.println("***** Tiến hành cập nhật *****");
                        item.inputData(scanner, selectedCategory.getProductList());
                        System.out.println(ColorText.GREEN_BRIGHT + "^_^ Cập nhật thành công" + ColorText.RESET);
                        break;
                    } else
                        System.err.println(" :(  Sản phẩm không tìm thấy, " +
                                "vui lòng nhập chính xác id, hoặc tên của sản phẩm !");
                }
            }
        } else
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll");
    }

    /**
     * xoá sản phẩm
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     * @param scanner          : đối tượng scanner để lấy input
     */
    public void deleteProduct(Category selectedCategory, Scanner scanner) {
        if (selectedCategory != null) {
            boolean isDone = false;
            while (!isDone) {
                System.out.print("-- Nhập tên hoặc mã sản phẩm cần xoá: ");
                String input = scanner.nextLine().toLowerCase();

                // find product
                if (selectedCategory.getProductList().isEmpty()) {
                    System.out.println(ColorText.YELLOW_BRIGHT + "Hiện :( không có sản phẩm nào tên" +
                            input + ColorText.RESET);
                    return;
                }
                //
                for (Product item : selectedCategory.getProductList()) {
                    if (item.getId().toLowerCase().equals(input) || item.getName().toLowerCase().equals(input)) {
                        System.out.println(ColorText.GREEN_BRIGHT +
                                "Đã tìm thấy sản phẩm " +
                                item.getName() + ColorText.RESET);

                        // delete case
                        System.out.println("Bạn có chắc muốn xoá nhấn ( yes/y ) để xoá, hoặc ( no/n ) để thoát");
                        do {
                            String command = scanner.nextLine().toLowerCase();

                            if (command.equals("yes") || command.equals("y")) {
                                selectedCategory.getProductList().remove(item);
                                System.out.println(ColorText.GREEN_BRIGHT + "^_^ Xoá thành công" + ColorText.RESET);
                                break;
                            } else if (command.equals("no") || command.equals("n")) {
                                System.out.println(ColorText.GREEN_BRIGHT + "Đã huỷ lệnh xoá ^_^ " + ColorText.RESET);
                                break;
                            } else {
                                System.err.println(" *_* Nhập không đúng lệnh, " +
                                        "hãy nhập lại lệnh ( yes or no ) ");
                            }
                        } while (true);
                        isDone = true;
                    }
                    // not found product
                    else
                        System.err.println(" :( Sản phẩm không tìm thấy, " +
                                "vui lòng nhập chính xác id, hoặc tên của sản phẩm !");
                }
            }
        } else
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll");
    }

    /**
     * xắp xếp A-Z theo tên sản phẩm
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     */
    public void sortProductByNameAToZ(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.getProductList().sort(Comparator.comparing(Product::getName));
            System.out.println(ColorText.GREEN_BRIGHT + "-- Xắp xếp sản phẩm A-Z thành công ^_^ --" + ColorText.RESET);
        } else
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll !");

    }


    /**
     * xắp xếp lợi nhuận cao đến thấp
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     */
    public void sortProductByProfitHighToLow(Category selectedCategory) {
        if (selectedCategory != null) {
            selectedCategory.getProductList().sort(Comparator.comparingDouble(Product::getProfit).reversed());
            System.out.println(ColorText.GREEN_BRIGHT + "-- Xắp xếp lợi nhuận cao-thấp thành công ^_^ --" + ColorText.RESET);
        } else
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll");

    }


    /**
     * Tìm kiếm sản phẩm theo tên hoặc id
     *
     * @param selectedCategory : tham chiếu đên đối tượng danh mục chọn ở trong kho
     * @param categoryList     : lấy danh sách các danh mục để bắt buộc truyền vào hàm displayData
     * @param scanner          : đối tượng scanner để lấy input
     */
    public void findProductByName(Category selectedCategory, List<Category> categoryList, Scanner scanner) {
        if (selectedCategory != null) {
            System.out.print("-- Nhập tên hoặc id sản phẩm cần tìm kiếm :");
            String input = scanner.nextLine();
            for (Product item : selectedCategory.getProductList()) {
                if (item.getName().equals(input) || item.getId().equals(input)) {
                    System.out.println("-- Sản phẩm tìm kiếm được là :");
                    System.out.println("-----------------------------------------------------");
                    System.out.printf(ColorText.WHITE_BOLD_BRIGHT +
                                    "%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n" + ColorText.RESET,
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
                    System.err.println(" :( Sản phẩm không tồn tại !");
            }
        } else
            System.err.println("Lỗi : *_* Danh mục đang chọn bị NUll");
    }
}

