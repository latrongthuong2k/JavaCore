public class FindTheSecondHighestE {

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7, 6, 8};
        // tránh trường hợp trong mảng là số âm thì khi cho bằng 0 thì sẽ không check được giá trị âm
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Phần tử lớn thứ 2 trong mảng là: " + secondLargest);
    }
}
