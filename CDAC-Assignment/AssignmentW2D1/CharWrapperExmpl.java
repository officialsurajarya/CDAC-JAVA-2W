public class CharWrapperExmpl {
    public static void main(String[] args) {

        char ch = 'a';
        char digit = '7';

        // character is a digit ??
        System.out.println(digit + " is a digit? :- " + Character.isDigit(digit));

        // Convert a char to uppercase
        System.out.println("uppercase of " + ch + " => " + Character.toUpperCase(ch));

        // Check char is letter
        System.out.println(ch + " is a letter? " + Character.isLetter(ch));
    }
}
