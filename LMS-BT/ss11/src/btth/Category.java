package btth;

import java.util.*;

public class Category implements IShop<Category> {
    private int categoryId;
    private String categoryName;
    private boolean status;

    private int productCount;

    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public Category(int catalogId, String categoryName, boolean status) {
        this.categoryId = catalogId;
        this.categoryName = categoryName;
        this.status = status;
    }

    // Getter and setter methods
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Category() {
    }

    // note : categoryList truyền vào inputData đã có sẵn ở đối tượng categoryManager của shopManager rồi
    // nên là không cần truyền thêm từ bên ngoài vào
    @Override
    public void inputData(Scanner scanner, List<Category> categoryList) {
        // auto generate id
        int id = 0;
        if (!categoryList.isEmpty()) {
            for (Category item : categoryList) {
                if (item.getCategoryId() == id) {
                    id++;
                }
            }
            categoryId = id;
            //
            boolean isExist = true;
            while (isExist) {
                System.out.println("Nhập tên danh mục:");
                String name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Tên danh mục không được trống.");
                    continue;
                }
                for (Category item : categoryList) {
                    if (item.getCategoryName().equals(name)) {
                        System.err.println("Tên danh mục đã tồn tại.");
                    } else {
                        this.categoryName = name;
                        isExist = false;
                    }
                }
            }
        } else {
            categoryId = 0;
            boolean isExist = true;
            while (isExist) {
                System.out.println("Nhập tên danh mục:");
                String name = scanner.nextLine();

                if (name.isEmpty()) {
                    System.out.println("Tên danh mục không được trống.");
                } else {
                    this.categoryName = name;
                    break;
                }
            }
        }
        // Nhập trạng thái
        System.out.println("Nhập trạng thái (true cho Active và false cho InActive): ");
        status = scanner.nextBoolean();
        while (status != true && status != false) {
            System.out.println("Nhập không đúng hãy nhập lại");
            status = scanner.nextBoolean();
        }
    }

    public void addProduct(Product product) {
        System.out.println("Thêm thành công");
        productList.add(product);
    }

    // xắp xếp danh sách product theo giá
    public void sortProductByIdLowToHigh() {
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }

    // theo tên
    public void sortProductByNameLowToHigh() {
        productList.sort(Comparator.comparing(Product::getProductName));
    }

    // displayProducts
    public void displayProducts() {
        for (Product item : productList) {
            item.displayData();
        }
    }

    // removeProduct
    public void removeProduct(String id) {
        for (Product item : productList) {
            if (item.getProductId().equals(id)) {
                productList.remove(item);
                System.out.println("Đã xoá sản phẩm: ( " + item.getProductName() + " ), có Id là: " + item.getProductId());
                break;
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Catalog ID: " + categoryId);
        System.out.println("Name: " + categoryName);
        System.out.println("Status: " + (status ? "Active" : "InActive"));
        System.out.println("-------------------");
    }
}
