public class ImplicitTypeConversion {
    public static void main(String[] args) {

        int intValue = 50;
        double doubleValue = intValue;

        long longValue = 100000L;
        float floatValue = longValue;

        System.out.println("int value: " + intValue);
        System.out.println("Converted double value: " + doubleValue);

        System.out.println("long value: " + longValue);
        System.out.println("Converted float value: " + floatValue);
    }
}
