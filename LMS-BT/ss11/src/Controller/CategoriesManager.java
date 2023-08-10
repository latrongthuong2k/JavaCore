package Controller;

import BTTH.ra.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesManager {

    public List<Category> getCategoryList() {
        return categoryList;
    }

    private final List<Category> categoryList;

    // constructor
    public CategoriesManager() {
        categoryList = new ArrayList<>();
    }

    // add
    public void addCategories(Scanner scanner) {
        Category item = new Category();
        item.inputData(scanner, categoryList);
        categoryList.add(item);
        System.out.println("Thêm thành công");
    }

    // display
    public void disPlayCategory() {
        System.out.println("Hiện có tổng: " + categoryList.size() + ", danh mục trong Shop");
        for (Category item : categoryList) {
            System.out.println("Danh mục quản lý sản phẩm " + item.getCategoryId());
            item.displayData();
        }
    }

    // update name Category
    public void updateNameCategory(Scanner scanner) {
        System.out.println("Nhập tên hoặc id của category để đổi tên: ");
        String input = scanner.nextLine();
        int id = -1;
        boolean isNumber = true;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        if (isNumber) {
            for (Category item : categoryList) {
                if (item.getCategoryId() == id) {
                    editName(item, scanner);
                    break;
                }
            }
        } else {
            // Tìm danh mục dựa trên tên
            for (Category item : categoryList) {
                if (item.getCategoryName().equals(input)) {
                    editName(item, scanner);
                    break;
                }
            }
        }
    }

    // call back method of updateName
    public void editName(Category item, Scanner scanner) {
        String newName = "";
        boolean isExist = true;
        while (isExist) {
            System.out.println("Nhập tên mới cho danh mục:");
            newName = scanner.nextLine();

            if (newName.isEmpty()) {
                System.err.println("Tên danh mục không được trống.");
                continue;
            }
            if (item.getCategoryName().equals(newName)) {
                System.err.println("Tên danh mục đã tồn tại, hãy nhập tên khác.");
            } else {
                item.setCategoryName(newName);
                isExist = false;
            }
        }
    }


    // removeCategory

    public void deleteCategory(int id) {
        for (Category item : categoryList) {
            if (item.getCategoryId() == id) {
                categoryList.remove(item);
                System.out.println("Đã xoá danh mục: ( " + item.getCategoryName() + " ), có Id là: " + item.getCategoryId());
                break;
            }
        }
    }

}
