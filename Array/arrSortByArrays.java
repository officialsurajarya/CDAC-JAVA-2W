package Array;

import java.util.Arrays;

public class arrSortByArrays {
    public static void main(String[] args) {
        int[] arr2 = { 5, 2, 4, 2, 10, 145, 0, 10 };
        Arrays.sort(arr2);
        for (int i : arr2) {
            System.out.print(i + ", ");
        }
    }
}
