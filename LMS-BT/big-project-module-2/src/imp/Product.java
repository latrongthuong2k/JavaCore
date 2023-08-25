package imp;

import controller.ColorText;
import model.IProduct;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Product implements IProduct {

    /**
     * Các variable của class
     */
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
     * コンストラクターメソッド : constructor khởi tạo object với một số thuộc tính mặt đinh
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
        inputID(scanner, productList);
        inputName(scanner, productList);
        inputImportPrice(scanner);
        inputExportPrice(scanner);
        inputDescription(scanner);
        inputStatus(scanner);

        calProfit(); // gọi cuối sau khi nhập Import và Export
    }

    /**
     * Các phương thức dùng trong phương thức inputData
     */
    public void inputID(Scanner scanner, List<Product> productList) {
        // IDを入力
        boolean isTrue = true;
        while (isTrue) {
            System.out.print("-- Nhập Id sản phẩm, bắt đầu từ ký tự (P) và có tổng tối đa 4 ký tự: ");
            try {
                /**
                 * Kiểm tra xem id đối tượng thao tác hiện tại có trống không
                 * Nếu có thì thực hiện quá trình thêm mới.
                 */
                if (this.id.isEmpty()) {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    if (id.length() == 4 && id.charAt(0) == 'P') {
                        this.id = id;
                        isTrue = false;
                    } else {
                        // nhập sai so với yêu cầu và thực hiện vòng lặp mới
                        throw new RuntimeException("Nhập sai yêu cầu !");
                    }
                    /**
                     * Kiểm tra xem là trong danh sách có đối tượng nào có id trùng không
                     */
                    for (Product item : productList) {
                        if (item.getName().equals(id)) {
                            throw new RuntimeException("Id sản phẩm đã tồn tại.");
                        }
                    }
                }
                /**
                 * Nếu đối tượng là một sản phẩm được thực hiện
                 * ở lệnh Update thì đối tượng đã có dữ liệu nên
                 * được cấp quyền cập nhật
                 */
                else {
                    /**
                     * hỏi trước khi cập nhật
                     */
                    System.out.print("-- Để Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật," +
                            " hoặc gõ bất kỳ để huỷ : ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.id = "";
                    } else {
                        /**
                         * huỷ thì thoát vòng lặp và không cập nhật
                         */
                        System.out.println(
                                ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật id, id hiện tại là: " +
                                        ColorText.RESET + this.id);
                        isTrue = false;
                    }
                }
            } catch (RuntimeException e) {
                System.err.println("Lỗi: " + e.getMessage() + " , xin hãy nhập lại Id");
            }
        }
    }

    public void inputName(Scanner scanner, List<Product> productList) {
        // 商品名を入力
        boolean exit = false;
        while (!exit) {
            System.out.print("-- Hãy nhập tên sản phẩm từ 6 - 30 ký tự: ");
            try {
                /**
                 * Kiểm tra xem tên đối tượng thao tác hiện tại có trống không
                 * Nếu có thì thực hiện quá trình thêm mới.
                 */
                if (this.name.isEmpty()) {
                    String productName = scanner.nextLine();
                    /**
                     * Check nếu có lỗi thì thực hiện vòng lặp mới
                     */
                    if (productName.isEmpty()) {
                        throw new RuntimeException("Tên sản phẩm không được để trống.");
                    } else if (productName.length() < 6 || productName.length() > 30) {
                        throw new RuntimeException("Nhập sai yêu cầu! ");
                    }
                    /**
                     * Kiểm tra xem là trong danh sách có đối tượng nào có tên trùng không
                     */
                    for (Product item : productList) {
                        if (item.getName().equals(productName)) {
                            throw new RuntimeException("Tên sản phẩm đã tồn tại.");
                        }
                    }
                    /**
                     * Nếu mọi thứ ok thì gán tên đã kiểm tra cho tên của đối tượng
                     * và thoát khỏi vòng lặp
                     */
                    this.name = productName;
                    exit = true;
                } else {
                    /**
                     * Hỏi để cập nhật
                     */
                    System.out.print("-- Để thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật, " +
                            "hoặc gõ bất kỳ để huỷ : ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.name = "";
                    } else {
                        /**
                         * Gõ một phím bất kỳ đẻ huỷ và thoát khỏi vòng lặp
                         */
                        System.out.println(
                                ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật tên, tên hiện tại là: " +
                                        ColorText.RESET + this.name);
                        exit = true; //  kết thúc vòng lặp
                    }
                }
                /**
                 * Bắt lỗi và in ra trước khi thực hiện vòng lặp mới
                 */
            } catch (RuntimeException e) {
                System.err.println("Lỗi: " + e.getMessage() + " , xin hãy nhập lại tên ");
            }
        }
    }

    public void inputImportPrice(Scanner scanner) {
        // 購入価格を入力
        boolean shouldContinue = true;
        do {
            System.out.print("-- Nhập giá nhập: ");
            try {
                if (importPrice == 0) {
                    String input = scanner.nextLine();
                    double importPrice = Double.parseDouble(input);
                    if (importPrice <= 0) {
                        // thả ra lỗi và di tới vòng lặp mới
                        throw new RuntimeException("Giá nhập không được nhỏ hơn hoặc bằng 0 !");
                    }
                    // nếu không lỗi thì gán giá cho đối tượng và thoát vòng lặp
                    this.importPrice = importPrice;
                    shouldContinue = false;
                } else {
                    /**
                     * nếu đối tượng có sẵn giá trị ở import price thì đối tượng được yêu cầu ở lệnh cập nhật
                     */
                    System.out.print("-- Thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật," +
                            " hoặc gõ bất kỳ để huỷ : ");
                    /**
                     * Hỏi trước khi cập nhật, và thoát bằng cách gõ một lệnh bất kỳ ngoài yes
                     * nếu chọn yes thì set lại giá trị của import thành 0, rồi cho chạy qua vòng
                     * lặp mới đẻ check điều kiện là empty thì cho nhập và gán lại
                     */
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.importPrice = 0;
                    } else {
                        /**
                         * Nếu huỷ cập nhật thì in thông báo và thoát khỏi vòng lặp
                         */
                        System.out.println(
                                ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật giá import, giá hiện tại là: " +
                                        ColorText.RESET + this.importPrice +
                                        ColorText.GREEN_BRIGHT + " $" + ColorText.RESET);
                        shouldContinue = false;
                    }
                }
                /**
                 * Nơi bắt các lỗi để in ra màng hình trước khi đi đến vòng lặp tiếp theo
                 */
            } catch (InputMismatchException e) {
                System.err.println("Lỗi: *_* Giá nhập phải là một số thực, hãy nhập lại !");
            } catch (RuntimeException e) {
                System.err.println("Lỗi : *_* " + e.getMessage() + ", hãy nhập lại giá nhập !");
            }
        } while (shouldContinue);
    }

    public void inputExportPrice(Scanner scanner) {
        // 販売価格を入力 : Nhập giá xuất
        boolean shouldContinue2 = true;
        do {
            System.out.print("-- Nhập giá xuất: ");
            try {
                if (this.exportPrice == 0) {
                    String inputPrice = scanner.nextLine();
                    double ExportPrice = Double.parseDouble(inputPrice);
                    // check các điều kiện và thả ra lỗi để đi đến vòng lặp mới
                    if (ExportPrice <= 0) {
                        throw new RuntimeException("Giá xuất không được nhỏ hơn" + MIN_INTEREST_RATE + "hoặc bằng 0 !");
                    } else if (ExportPrice < MIN_INTEREST_RATE) {
                        throw new RuntimeException("Giá xuất cần tối thiểu: " + MIN_INTEREST_RATE + " $");
                    }
                    // nếu không lỗi thì gán giá export cho đối tượng và thoát vòng lặp
                    this.exportPrice = ExportPrice;
                    shouldContinue2 = false;
                } else {
                    /**
                     * Hỏi trước khi cập nhật, và thoát bằng cách gõ một lệnh bất kỳ ngoài yes
                     * nếu chọn yes thì set lại giá trị của export thành 0, rồi cho chạy qua vòng
                     * lặp mới đẻ check điều kiện là empty thì cho nhập và gán lại
                     */
                    System.out.print("-- Để thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật," +
                            " hoặc gõ bất kỳ để huỷ : ");
                    String input = scanner.next().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.exportPrice = 0;
                    } else {
                        /**
                         * Nếu huỷ cập nhật thì in thông báo và thoát khỏi vòng lặp
                         */
                        System.out.println(
                                ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật giá export, giá hiện tại là: " +
                                        ColorText.RESET + this.exportPrice +
                                        ColorText.GREEN_BRIGHT + " $" + ColorText.RESET);
                        shouldContinue2 = false;
                    }
                }
            }
            // Nơi bắt các lỗi để in ra màng hình trước khi đi đến vòng lặp tiếp theo
            catch (InputMismatchException e) {
                System.err.println("Lỗi: *_* Giá xuất phải là một số thực, hãy nhập lại !");
            } catch (RuntimeException e) {
                System.err.println("Lỗi : *_* " + e.getMessage() + ", hãy nhập lại giá xuất !");
            }
        } while (shouldContinue2);

    }

    public void inputDescription(Scanner scanner) {
        // 商品の説明を入力 : Nhập mô tả
        do {
            System.out.print("-- Nhập mô tả cho sản phẩm: ");
            try {
                // kiểm tra nếu mô tả trống thì thực hiện nhập mô tả
                if (this.description.isEmpty()) {
                    this.description = scanner.nextLine();
                    if (description.isEmpty()) {
                        throw new RuntimeException("Mô tả không được để trống, xin hãy nhập lại !");
                    }
                    // nhập xong thì thoát khỏi vòng lặp
                    break;
                } else {
                    /**
                     * nếu đối tượng có sẵn giá trị ở description thì chuyển hướng sang cho phép cập nhật
                     */
                    System.out.println("-- Để thực hiện cập nhật, nhập 'y' hoặc 'yes' để cập nhật, " +
                            "hoặc gõ bất kỳ để huỷ : ");
                    /**
                     * Hỏi trước khi cập nhật, và thoát bằng cách gõ một lệnh bất kỳ ngoài yes
                     * nếu chọn yes thì set lại giá trị của desc thành rỗng, rồi cho chạy qua vòng
                     * lặp mới đẻ check điều kiện là empty thì cho nhập và gán lại
                     */
                    String input = scanner.nextLine().toLowerCase();
                    if (input.equals("y") || input.equals("yes")) {
                        this.description = "";
                    } else {
                        /**
                         * Nếu huỷ cập nhật thì in thông báo và thoát khỏi vòng lặp
                         */
                        System.out.println(
                                ColorText.YELLOW_BRIGHT + "Đã huỷ cập nhật desc" +
                                        ColorText.RESET);
                        break;
                    }
                }
            }
            /*
             * Nơi bắt lỗi khi có lỗi thì bắt ở đây rồi in thông báo trước khi qua vòng
             * lặp mới
             */ catch (RuntimeException e) {
                System.err.println("Lỗi : *_* " + e.getMessage());
            }
        }
        while (true);
    }

    public void inputStatus(Scanner scanner) {
        // 状態を入力 : nhập trạng thái
        do {
            // Hỏi và đưa ra các gợi ý
            System.out.print("-- Nhập trạng thái sản phẩm 'true' : " +
                    ColorText.GREEN_BRIGHT + "Active" + ColorText.RESET +
                    " or 'false' : " + ColorText.YELLOW_BRIGHT + "InActive" + ColorText.RESET + ": ");
            try {
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("true"))
                    this.status = true;
                else if (input.equals("false"))
                    this.status = false;
                else {
                    // nếu các điều kiện không được thoả mãng thì sẽ nhả ra lỗi
                    throw new Exception(" *_* Nhập không đúng yêu cầu. Xin hãy nhập lại !");
                }
                break;
            }

            // bắt lỗi và in thông báo trước khi qua vòng lặp hỏi mới
            catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true);
    }

    /*
     *--------------------------------------------------------------------------
     */

    /**
     * データを表示するメソッド : phương thức hiển thị thông tin sản phẩm
     */
    @Override
    public void displayData(List<Category> categoryList) {
        // tìm ra category theo idCategory của sản phẩm
        String nameCategory = "";
        for (Category ct : categoryList) {
            if (categoryId == ct.getId())
                nameCategory = ct.getName();
        }
        /**
         * Bản hiển thị sản phẩm
         */
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                id,
                name,
                String.format("%.2f", importPrice) + " $",
                String.format("%.2f", exportPrice) + " $",
                String.format("%.2f", profit) + " $",
                description,
                status ? "Còn hàng" : "Ngừng kinh doanh",
                nameCategory);
    }

    /**
     * 利益を計算するメソッド : phương thức tính toán lợi nhuận
     */
    @Override
    public void calProfit() {
        this.profit = exportPrice - importPrice;
    }
}
