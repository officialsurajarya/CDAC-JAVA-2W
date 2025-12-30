import java.util.Scanner;

public class ArrayException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        System.out.println("Enter 5 integers:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        try {
            System.out.println("Accessing 10th index: " + arr[9]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: Index out of range");
        }

        System.out.println("Program executed successfully");
        sc.close();
    }
}
