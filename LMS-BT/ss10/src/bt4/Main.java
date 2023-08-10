package bt4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Bước 1: Tạo một chuỗi
        String inputString = "Rekkei Academy để nông dân biết code";

        // Bước 2: Tạo List có kiểu dữ liệu là String
        List<String> stringList = new ArrayList<>();

        // Bước 3: Convert chuỗi ở Bước 1 thành List và gán vào List đã tạo ở Bước 2
        String[] words = inputString.split("\\s+");
        Collections.addAll(stringList, words);

        // Bước 4: Duyệt List và in ra các phần tử có độ dài lớn hơn 3 ký tự
        for (String word : stringList) {
            if (word.length() > 3) {
                System.out.println(word);
            }
        }
    }
}
