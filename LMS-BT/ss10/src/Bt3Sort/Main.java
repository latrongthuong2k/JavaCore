package Bt3Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = createIntegerList();

        System.out.println("Danh sách ban đầu: " + integerList);

        sortDescending(integerList);

        System.out.println("Danh sách sau khi sắp xếp giảm dần: " + integerList);
    }

    // Phương thức tạo danh sách List chứa các số nguyên
    private static List<Integer> createIntegerList() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(3);
        return list;
    }

    private static void sortDescending(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        list.sort(Comparator.naturalOrder());
    }
}

