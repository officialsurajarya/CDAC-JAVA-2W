import java.util.Scanner;

public class GradeFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter a Number 1-100: ");
    int num = sc.nextInt();

    if (num>=90 && num<=100) {
        System.out.println("Grade A");
    } else if(num>=75 && num<=89) {
        System.out.println("Grade B");
    }else if(num>=50 && num<=74){
        System.out.println("Grade C"); 
    }else if(num>=0 && num<=49){
        System.out.println("Fail"); 
    }else{
        System.out.println("Invalid Choice");
    }
    sc.close();
    }
}
