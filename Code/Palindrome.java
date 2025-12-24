package Code;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        int temp = n; 
        int ans = 0;

        while (n>0) {
            int rev = n%10;
            ans = (ans*10)+rev;
            n = n/10;

        }

        if (temp==ans) {
            System.out.println("Number is Palindrome: "+ans);
        } else {
            System.out.println("Number is not a Palindrome");
        }
        
        
    }
    
} 