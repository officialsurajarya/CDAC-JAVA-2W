class EmptyStringException extends RuntimeException {
    public EmptyStringException(String message) {
        super(message);
    }
}

public class TestEmptyString {

    static void checkString(String str) {
        if (str == null || str.isEmpty()) {
            throw new EmptyStringException("String cannot be null or empty");
        }
        System.out.println("Valid string: " + str);
    }

    public static void main(String[] args) {

        try {
            checkString("Hello");
            checkString("");
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        }
    }
}
