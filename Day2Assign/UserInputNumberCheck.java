import java.util.Scanner;

public class UserInputNumberCheck {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a Number: ");
    int num = sc.nextInt();

    if (num>10) {
        System.out.println("Number is greater that 10");
    } else if(num<10) {
        System.out.println("Number is smaller than 10 ");
    }else{
        System.out.println("Number is equal to 10"); 
    }
    sc.close();
    }
}
