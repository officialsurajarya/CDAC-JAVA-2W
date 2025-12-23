import java.util.Scanner;

public class simpleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Operator (+, -, *, /): ");
        char oper = sc.next().charAt(0);

        System.out.print("Enter Scond Number: ");
        int b = sc.nextInt();

        if(oper == '+') {
            System.out.println(a + " + " + b + " = "+ (a + b));
        }
        else if(oper == '-') {
            System.out.println(a + " - " + b + " = "+ (a - b));
        }
        else if(oper == '*') {
            System.out.println(a + " * " + b + " = "+ (a * b));
        }
        else if(oper == '/') {
            if(b !=0){
                System.out.println(a + " / " + b + " = "+ (a / b));
            }else {
                System.out.println("Division by 0 is not allowed");
            }
        }else {
            System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
