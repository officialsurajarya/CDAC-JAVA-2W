package Code;

public class IsPrimeByFunc {
    void checkPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime == true) {
            System.out.println("prime");
        } else {
            System.out.println("Not prime");

        }
    }

    public static void main(String[] args) {
        IsPrimeByFunc obj = new IsPrimeByFunc();
        obj.checkPrime(8);
    }
}
