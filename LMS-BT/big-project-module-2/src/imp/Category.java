package imp;

import model.ICategory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Category implements ICategory {
    private int id;
    private String name;
    private String description;
    private boolean status;

    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    // 取得と設定メソッド
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     * コンストラクターメソッド
     */
    public Category() {
    }

    /**
     * 入力データを処理するメソッド
     *
     * @param scanner      : 入力スキャナー
     * @param categoryList : カテゴリーリスト
     */
    @Override
    public void inputData(Scanner scanner, List<Category> categoryList) {
        // カテゴリー情報の入力を開始します
        System.out.println("********* Nhập thông tin danh mục *********");
        do {
            System.out.println("Nhập tên danh mục 6 - 30 ký tự:");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                System.err.println("Lỗi : Tên danh mục không được trống.");
                continue;
            } else if (name.length() < 6 || name.length() > 30) {
                System.err.println("Lỗi : Tên danh mục không đạt yêu cầu, xin hãy nhập lại !");
                continue;
            }

            boolean nameExists = false;
            if (!categoryList.isEmpty()) {
                for (Category item : categoryList) {
                    if (item.getName().equals(name)) {
                        System.err.println("Lỗi : Tên danh mục đã tồn tại.");
                        nameExists = true;
                        break;
                    }
                }
            }

            if (!nameExists) {
                // カテゴリ名が重複しない場合、名前とIDを設定
                this.name = name;
                int id = 0;
                if (!categoryList.isEmpty()) {
                    for (Category item : categoryList) {
                        if (item.getId() >= id) {
                            id = item.getId() + 1;
                        }
                    }
                }
                this.id = id;

                break;
            }
        } while (true);

        // カテゴリーの説明を入力します
        do {
            try {
                System.out.println("Nhập mô tả cho danh mục :");
                this.description = scanner.nextLine();
                if (description.isEmpty()) {
                    throw new RuntimeException("Mô tả không được để trống");
                }
                break;
            } catch (RuntimeException e) {
                System.err.println("Lỗi :" + e.getMessage());
            }
        }
        while (true);
        // カテゴリーの状態を入力します
        do {
            try {
                System.out.println("Nhập trạng thái (true cho Active và false cho InActive): ");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("true"))
                    this.status = true;
                else if (input.equals("false"))
                    this.status = false;
                else
                    throw new Exception("Input không đúng yêu cầu");
                break;
            } catch (Exception e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true);
    }

    /**
     * 利益を計算するメソッド
     */
    @Override
    public void displayData() {
        // ID、名前、説明、ステータスの情報を表示します
        System.out.printf("%-10d %-20s %-20s %-20s\n",
                id, name, description, status ? "Active" : "InActive");
    }
}
