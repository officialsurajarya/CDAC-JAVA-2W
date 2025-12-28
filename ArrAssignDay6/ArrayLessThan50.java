import java.util.Scanner;

public class ArrayLessThan50 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Positions of elements ");

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 50) {
                System.out.println("Index: " + (i) + " (Value: " + arr[i] + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No element is less than 50");
        }

        sc.close();
    }
}
