import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        int[] mergedArr = mergeArrays(arr1, arr2);
        System.out.println("Merged array: " + Arrays.toString(mergedArr));
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // Tính kích thước của mảng thứ ba
        int size = arr1.length + arr2.length;

        int[] mergedArr = new int[size];

        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);


        // Gộp mảng arr2 vào mảng thứ ba
        System.arraycopy(arr2, 0, mergedArr, arr1.length, arr2.length);

        return mergedArr;
    }
    
}
