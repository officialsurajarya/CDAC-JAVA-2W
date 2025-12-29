public class FloatToIntExample {
    public static void main(String[] args) {
        float num = 12.75f;
        int convertedNum = (int) num;

        System.out.println("Original float value: " + num);
        System.out.println("Converted int value: " + convertedNum);
        System.out.println("Data loss occurred: decimal part is removed");
    }
}
