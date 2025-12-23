import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter your name: ");
        String name = sc.nextLine();  // Read string input

        System.out.print("Enter your age: ");
        int age = sc.nextInt(); // Read integer input

        System.out.print("Enter your height: ");
        double height = sc.nextDouble();  // Read double input

        // Display the output
        System.out.println("Hello " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);

        sc.close(); // Close the Scanner object
    }
}
