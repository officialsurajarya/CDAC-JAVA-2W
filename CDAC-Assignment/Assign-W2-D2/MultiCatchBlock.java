public class MultiCatchBlock {

    public static void main(String[] args) {

        try {
            int[] arr = { 10, 20, 30 };

            int result = arr[5] / 0;
            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}
