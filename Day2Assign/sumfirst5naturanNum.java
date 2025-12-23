public class sumfirst5naturanNum {
    public static void main(String[] args) {

        int i = 1;
        int sum = 0;

        while (i <= 5) {
            sum = sum + i;
            i++;
        }

        System.out.println("Sum of first 5 natural numbers = " + sum);
    }
}
