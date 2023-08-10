package bt5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Rekkei Academy để nông dân biết code";

        String[] words = text.split("\\s+");

        List<String> shortestWords = new ArrayList<>();

        int shortestLength = Integer.MAX_VALUE;
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength < shortestLength) {
                // Nếu tìm thấy từ có độ dài nhỏ hơn, cập nhật shortestLength và xóa danh sách các từ ngắn nhất cũ (nếu có)
                shortestLength = wordLength;
                shortestWords.clear();
                shortestWords.add(word);
            } else if (wordLength == shortestLength) {
                // Nếu tìm thấy từ có độ dài bằng shortestLength, thêm từ này vào danh sách
                shortestWords.add(word);
            }
        }
        //
        System.out.println("Đoạn văn bản: " + text);
        System.out.println("Chuỗi ngắn nhất có độ dài " + shortestLength + " là:");
        for (String shortestWord : shortestWords) {
            System.out.println(shortestWord);
        }
    }
}
