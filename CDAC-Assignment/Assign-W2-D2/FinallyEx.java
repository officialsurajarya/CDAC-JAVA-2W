public class FinallyEx {

    public static void main(String[] args) {

        try {
            int result = 10 / 0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Exception caught in catch block");

        } finally {
            System.out.println("Finally block executed");
        }

        System.out.println("Program continues after try-catch-finally");
    }
}
