package bt2ReverseList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = createIntegerList();

        // In danh sách trước khi đảo ngược
        System.out.println("Danh sách ban đầu: " + integerList);

        reverseList(integerList);

        // In danh sách sau khi đảo ngược
        System.out.println("Danh sách sau khi đảo ngược: " + integerList);
    }

    private static List<Integer> createIntegerList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }

    // Phương thức đảo ngược danh sách List
    private static void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }
}
