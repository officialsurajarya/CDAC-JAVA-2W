package Code;

import java.util.Scanner;

public class isPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        if(num == 2) {
            System.out.println("n is prime number");
        }else {
        boolean isPrime = true;
            for(int i = 2; i<num-1; i++) {
                if (num%i==0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.println("Number is prime: "+num);
            }else {
                System.out.println("Number is not a prime");
            }
        }
        sc.close();
    }
}