package Array;

public class ArrBigest {

    public static int getLargestNumArr(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int arr[] = { 3, 5, 7, 3, 8, 2, 1 };
        int largestNum = getLargestNumArr(arr);
        System.out.println(largestNum);
    }
}
