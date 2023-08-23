package imp;

import controller.ColorText;
import model.IProduct;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Product implements IProduct {

    String id;
    String name;
    double importPrice;
    double exportPrice;
    double profit;
    String description;
    boolean status;
    int categoryId;

    /*
     * Setter && Getter method
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    /**
     * コンストラクターメソッド
     */
    public Product(int categoryId) {
        this.categoryId = categoryId;
        this.id = "";
        this.name = "";
        this.description = "";
        this.importPrice = 0;
        this.exportPrice = 0;
    }

    /**
     * 入力データを処理するメソッド
     *
     * @param scanner     : 入力スキャナー
     * @param productList : 入力商品リスト
     */
    @Override
    public void inputData(Scanner scanner, List<Product> productList) {
        System.out.println("*********** Tiến hành thêm sản phẩm ***********");
        // IDを入力
        while (true) {
            try {
                if (this.id.isEmpty()) {
                    System.out.print("Nhập Id sản phẩm, bắt đầu từ ký tự (P) và có tổng tối đa 4 ký tự: ");
                    String id = scanner.nextLine();
                    if (id.length() == 4 && id.charAt(0) == 'P') {
                        this.id = id;
                        break;
                    } else {
                        throw new RuntimeException("Nhập sai yêu cầu!");
                    }
                } else {
                    System.out.println("Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật: ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.id = "";
                        continue;
                    } else {
                        System.out.println(ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật id, id hiện tại là: " +
                                ColorText.RESET + this.id);
                    }
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi: " + e.getMessage());
                System.out.println("*** Nhập lại Id ***");
            }
        }

        // 商品名を入力
        while (true) {
            try {
                if (this.name.isEmpty()) {
                    System.out.print("Hãy nhập tên sản phẩm từ 6 - 30 ký tự: ");
                    String productName = scanner.nextLine();
                    if (productName.isEmpty()) {
                        throw new RuntimeException("Tên sản phẩm không được để trống.");
                    } else if (productName.length() < 6 || productName.length() > 30) {
                        throw new RuntimeException("Nhập sai yêu cầu!");
                    }
                    for (Product item : productList) {
                        if (item.getName().equals(productName)) {
                            throw new RuntimeException("Tên sản phẩm đã tồn tại.");
                        }
                    }
                    this.name = productName;
                } else {
                    System.out.println("Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật: ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.name = "";
                        continue;
                    } else {
                        System.out.println(ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật tên, tên hiện tại là: " +
                                ColorText.RESET + this.name);
                    }
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi: " + e.getMessage());
                System.out.println("*** Nhập lại tên ***");
            }
        }

        // 購入価格を入力
        do {
            try {
                if (importPrice == 0) {
                    System.out.println("Nhập giá nhập: ");
                    double inputImportPrice = scanner.nextInt();
                    if (!scanner.hasNextInt()) {
                        throw new RuntimeException("Giá nhập phải là số nguyên");
                    } else if (inputImportPrice < 0) {
                        throw new RuntimeException("Giá nhập không được nhỏ hơn hoặc bằng 0");
                    }
                    this.importPrice = inputImportPrice;
                    break;
                } else {
                    System.out.println("Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật: ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.importPrice = 0;
                        continue;
                    } else {
                        System.out.println(ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật giá import, giá hiện tại là: " +
                                ColorText.RESET + this.importPrice + ColorText.GREEN_BRIGHT + " $" + ColorText.RESET);
                    }
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi :" + e.getMessage());
                System.out.println("*** Nhập lại giá bán ***");
            }
        } while (true);

        // 販売価格を入力
        do {
            try {
                if (this.exportPrice == 0) {
                    System.out.println("Nhập giá xuất: ");
                    double inputExportPrice = scanner.nextDouble();
                    if (!scanner.hasNextInt()) {
                        throw new RuntimeException("Giá xuất phải là số nguyên");
                    } else if (inputExportPrice <= 0) {
                        throw new RuntimeException("Giá xuất không được nhỏ hơn hoặc bằng 0");
                    } else if (inputExportPrice > MIN_INTEREST_RATE) {
                        throw new RuntimeException("Giá xuất cần tối thiểu :" + MIN_INTEREST_RATE + " $");
                    }
                    this.exportPrice = inputExportPrice;
                    break;
                } else {
                    System.out.println("Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật: ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.importPrice = 0;
                        continue;
                    } else {
                        System.out.println(ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật giá export, giá hiện tại là: " +
                                ColorText.RESET + this.exportPrice + ColorText.GREEN_BRIGHT + " $" + ColorText.RESET);
                    }
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi :" + e.getMessage());
                System.out.println("*** Nhập lại giá bán ***");
            }
        } while (true);

        // 商品の説明を入力
        do {
            try {
                if (this.description.isEmpty()) {
                    System.out.println("Nhập mô tả cho sản phẩm :");
                    this.description = scanner.nextLine();
                    if (description.isEmpty()) {
                        throw new RuntimeException("Mô tả không được để trống");
                    }
                    break;
                } else {
                    System.out.println("Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật: ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.description = "";
                        continue;
                    } else {
                        System.out.println(ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật desc" + ColorText.RESET);
                    }
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi :" + e.getMessage());
            }
        }
        while (true);
        // 状態を入力
        do {
            try {
                System.out.println("* Nhập trạng thái (true cho Active và false cho InActive): ");
                String status = scanner.nextLine().toLowerCase();
                if (status.equals("true"))
                    this.status = true;
                else if (status.equals("false"))
                    this.status = false;
                else {
                    throw new RuntimeException("Input không đúng yêu cầu");
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true);
    }

    /**
     * データを表示するメソッド
     */
    @Override
    public void displayData(List<Category> categoryList) {
        // tìm ra category theo idCategory của sản phẩm
        String nameCategory = "";
        for (Category ct : categoryList) {
            if (categoryId == ct.getId())
                nameCategory = ct.getName();
        }
        System.out.printf("%-10s %-20s %-20f %-20f %-20f %-20s %-20s %20s\n",
                id,
                name,
                importPrice,
                exportPrice,
                profit,
                description,
                status ? "Còn hàng" : "Ngừng kinh doanh",
                nameCategory);
    }

    /**
     * 利益を計算するメソッド
     */
    @Override
    public void calProfit() {
        this.profit = exportPrice - importPrice;
    }
}
