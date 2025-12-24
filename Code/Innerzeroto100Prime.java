package Code;

public // import java.util.Scanner;

class Innerzeroto100Prime {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter a Number: ");
        // int num = sc.nextInt();
        for (int num = 2; num <= 100; num++) {

            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.print(num + ", ");
            } // else {
              // System.out.println("Number is not a prime");
              // }
        }
        // sc.close();
    }
}