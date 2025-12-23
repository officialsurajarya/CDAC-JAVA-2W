public class WideningConversionExample {
    public static void main(String[] args) {

        // Declare and initialize int variable
        int intValue = 25;

        // Implicit conversion from int to double
        double doubleFromInt = intValue;

        // Declare and initialize long variable
        long longValue = 50000L;

        // Implicit conversion from long to float
        float floatFromLong = longValue;

        // Print original and converted values
        System.out.println("Original int value: " + intValue);
        System.out.println("Converted double value: " + doubleFromInt);

        System.out.println("Original long value: " + longValue);
        System.out.println("Converted float value: " + floatFromLong);
    }
}
