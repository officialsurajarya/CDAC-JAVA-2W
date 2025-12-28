public class CountOccurrence {
    public static void main(String[] args) {

        int arr[] = { 2, 4, 3, 1, 4, 4, 3, 2, 5 };
        int find = 4;
        int Occurrence = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) {
                Occurrence++;
            }
        }
        System.out.println("Occurrence of " + find + " = " + Occurrence);
    }
}
