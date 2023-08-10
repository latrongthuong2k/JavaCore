package BTTH.ra;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop<Product> {
    private int productId;
    private String productName;
    private float price;
    private String title;
    private int categoryId;
    private boolean status;

    public Product() {
    }

    public Product(int productId, String productName, float price, String title, int categoryId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.categoryId = categoryId;
        this.status = status;
    }

    // Getter and setter methods


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Action
    @Override
    public void inputData(Scanner scanner, List<Product> productList) {
        System.out.println("*********** Tiến hành thêm sản phẩm ***********");
        // tự động tạo id
        int id = 0;
        for (Product item : productList) {
            if (item.getProductId() == id) {
                id++;
            }
        }
        productId = id;
        // Nhập tên sản phẩm
        boolean isExist = true;
        do {
            System.out.println("Hãy nhập tên sản phẩm:");
            productName = scanner.nextLine();
            if (productName.isEmpty()) {
                System.out.println("Tên sản phẩm không được để trống.");
                continue;
            } else if (productList.isEmpty()) {
                isExist = false;
            }
            for (Product item : productList) {
                if (item.getProductName().equals(productName)) {
                    System.err.println("Tên sản phẩm đã tồn tại.");
                } else isExist = false;
            }
        } while (isExist);
        // Nhập giá
        System.out.println("Nhập giá sản phẩm");
        price = scanner.nextFloat();
        scanner.nextLine();
        // nhập tiêu đề
        System.out.println("Nhập tiêu đề sản phẩm");
        title = scanner.nextLine();
        // nhập status
        System.out.println("Nhập trạng thái sản phẩm, true (Active) hoặc false(InActive) : ");
        status = scanner.nextBoolean();
        while (status != true && status != false) {
            System.out.println("Nhập không đúng vui lòng nhập lại ( true hoặc false )");
            status = scanner.nextBoolean();
        }
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price + '$');
        System.out.println("Title: " + title);
        System.out.println("Product of category: " + categoryId);
        System.out.println("Status: " + (status ? "Active" : "InActive"));
        System.out.println("-------------------");
    }
}


