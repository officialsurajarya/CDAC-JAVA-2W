public class StringCompareIgnoreCase {
    public static void main(String[] args) {

        String str1 = "CDAC Patna";
        String str2 = "Cdac Patna";

        boolean result = str1.equalsIgnoreCase(str2);

        System.out.println(str1 + " == " + str2 + " ? " + result);
    }
}
