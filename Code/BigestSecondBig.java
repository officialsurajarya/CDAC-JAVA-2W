public class BigestSecondBig {

    public static void main(String[] args) {

        int[] arr = { 10, 33, 100, 431, 253 };
        int big = 0;
        int Secondbig = 0;
        int len = arr.length;
        int index = 0;
        for (int i = 0; i <= len - 1; i++) {
            if (big < arr[i]) {
                big = arr[i];
                index = i;
            }
        }

        for (int i = 0; i <= len - 1; i++) {
            if (Secondbig < arr[index] && (i != index)) {
                Secondbig = arr[i];
                // index = i;
            }
        }

        System.out.println(index);
        System.out.println(big);
        System.out.println(Secondbig);
    }
}