package controller;


import imp.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryManager {

    // 1 Category Manager have 1 list Category

    // constructor
    public CategoryManager() {
    }

    // add
    public void addCategory(Scanner scanner, List<Category> categoryList) {
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
            Category category = new Category();
            category.inputData(scanner, categoryList);
            categoryList.add(category);
            System.out.println(ColorText.GREEN_BRIGHT + "Thêm thành công" + ColorText.RESET);
        }
    }

    // display
    public void displayCategory(List<Category> categoryList) {
        System.out.println("Hiện có tổng: " + categoryList.size() + ", danh mục trong kho");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s\n",
                "ID", "Tên danh mục", "Mô tả", "Trạng thái");
        for (Category item : categoryList) {
            item.displayData();
        }
        System.out.println("---------------------------------------------------------------");
    }

    // update name Category
    public void updateNameCategory(Scanner scanner, List<Category> categoryList) {
        System.out.println("Nhập tên hoặc id của category để cập nhật: ");
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
                if (item.getId() == id) {
                    item.inputData(scanner, categoryList);
                    break;
                }
            }
        } else {
            // Tìm danh mục dựa trên tên
            for (Category item : categoryList) {
                if (item.getName().equals(input)) {
                    item.inputData(scanner, categoryList);
                    break;
                }
            }
        }
    }

    /**
     * カテゴリを削除するメソッド
     *
     * @param scanner      : 入力を受け取るスキャナー
     * @param categoryList : カテゴリのリスト
     */
    public void deleteCategory(Scanner scanner, List<Category> categoryList) {
        // 削除対象のカテゴリのIDまたは名前を入力
        System.out.println("Nhập Id hoặc tên danh mục cần xoá");
        String input;
        int id;
        boolean isNumber = true;

        // 入力を受け取るループ
        while (true) {
            try {
                input = scanner.nextLine();
                id = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                isNumber = false;
            }
        }

        // 入力が数字の場合
        if (isNumber) {
            // カテゴリリストをループして対応する名前のカテゴリを削除確認
            for (Category item : categoryList) {
                if (item.getId() == id) {
                    askForDeleteCallBackFunc(item, scanner, categoryList);
                    break;
                }
            }
        }
        // 入力が文字列の場合
        else {
            // カテゴリリストをループして対応する名前のカテゴリを削除確認
            for (Category item : categoryList) {
                if (item.getName().equals(input)) {
                    askForDeleteCallBackFunc(item, scanner, categoryList);
                    break;
                }
            }
        }
    }

    // call back func of Delete category
    public void askForDeleteCallBackFunc(Category item, Scanner scanner, List<Category> categoryList) {
        System.out.println(ColorText.GREEN + "Đã tìm thấy danh mục tên: " + item.getName() + ColorText.RESET);
        System.out.println("Bạn có chắc muốn xoá nhấn ( yes ) để xoá, hoặc ( no ) để thoát");
        do {
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("yes")) {
                categoryList.remove(item);
                System.out.println("Đã xoá danh mục tên: " + item.getName());
            } else if (command.equals("no")) {
                System.out.println("Đã huỷ lệnh xoá");
                break;
            } else {
                System.err.println("Nhập không đúng lệnh, hãy nhập lại lệnh ( yes or no ) ");
            }
        } while (true);
    }


    /**
     * @param inventoryManagement :在庫管理クラスのインスタンス
     * @param scanner             : 入力を受け取るスキャナー
     * @return : 選択されたカテゴリのインスタンス
     */
    public Category selectCategory(InventoryManagement inventoryManagement, Scanner scanner) {
        // 選択されたカテゴリを保持するオブジェクトを生成
        Category selectedCategory = new Category();

        // カテゴリリストを取得
        List<Category> categoryList = inventoryManagement.getCategoryList();

        // ショップ内のカテゴリ数を表示
        System.out.println("Hiện tại có " + categoryList.size() + " danh mục trong shop");
        System.out.println("Danh sách đanh mục");

        // カテゴリリストをループして表示
        for (Category item : categoryList) {
            System.out.println("Danh mục tên ( " + item.getName() + " ) có id là ( " + item.getId() + " )");
        }

        // カテゴリ選択の指示を表示
        System.out.println("Hãy nhập ( Id hoặc tên ) của danh mục mà bạn muốn chọn");

        // ユーザー入力を受け取る
        String target = scanner.nextLine();

        // 入力された文字列を数値に変換し、数字かどうか判定
        int categoryId = -1;
        boolean isNumeric = true;
        try {
            categoryId = Integer.parseInt(target);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }

        // 入力が数字の場合
        if (isNumeric) {
            // カテゴリリストをループして、入力されたIDに対応するカテゴリを選択
            for (Category item : categoryList) {
                if (item.getId() == categoryId) {
                    selectedCategory = item;
                    break;
                }
            }

        }
        // 入力が文字列の場合
        else {
            // カテゴリリストをループして、入力された名前に対応するカテゴリを選択
            for (Category item : categoryList) {
                if (item.getName().equals(target)) {
                    selectedCategory = item;
                    break;
                }
            }
        }
        // 選択されたカテゴリを返す
        return selectedCategory;
    }

}
