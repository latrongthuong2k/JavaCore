package bt1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = createRandomIntegerList(10);

        System.out.println("List số nguyên: " + integerList);

        // Tìm phần tử lớn nhất trong List sử dụng Collections.max()
        int maxElement = Collections.max(integerList);
        System.out.println("Phần tử lớn nhất trong List: " + maxElement);
    }

    private static List<Integer> createRandomIntegerList(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100)); // Giới hạn giá trị ngẫu nhiên từ 0 đến 99
        }
        return list;
    }
}
