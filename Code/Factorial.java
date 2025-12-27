package Code;

public class Factorial {

    void fact(int n) {
        int ans = 1;
        for (int i = n; i >= 1; i--) {
            ans *= i;
        }
        System.out.println("Factorial of " + n + " is: " + ans);
    }

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        obj.fact(5);
    }
}
