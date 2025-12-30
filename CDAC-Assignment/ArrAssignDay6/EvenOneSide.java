public class EvenOneSide {
    public static void main(String[] args) {

        int arr[] = { 2, 3, 1, 6, 3, 2, 5, 7, 8, 6 };
        int[] result = new int[10];

        int index = 0;

        for (int i = 0; i < 10; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }

        System.out.println("Array after arranging even elements on one side:");

        for (int i = 0; i < 10; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
