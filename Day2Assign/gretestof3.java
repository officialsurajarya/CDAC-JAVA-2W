import java.util.Scanner;

public class gretestof3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Number: ");
        int a = sc.nextInt();

        System.out.println("Enter Second Number: ");
        int b = sc.nextInt();

        System.out.println("Enter Third Number: ");
        int c = sc.nextInt();

        if (a>b && a>c) {
            System.out.println("A is Gratest");
        }
        else if(b>c) {
            System.out.println("B is Gratest");
        }
        else {
            System.out.println("c is gratest");
        }
        sc.close();
    }
}
