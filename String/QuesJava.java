package String;

public class QuesJava {
    public static void main(String[] args) {
        String str1 = "Java Program";
        String str2 = "Java Program";
        String str3 = new String("Java Program");
        String str4 = new String("Java Program");

        // System.out.println(str1 == str2);
        // System.out.println(str1.equals(str2));
        // System.out.println(str3 == str4);
        // System.out.println(str3.equals(str4));

        // System.out.println(str1 == str3);
        str1.equals(str3);
        String word2 = "Program";
        // System.out.println(str1 == "Java Program");
        // System.out.println(str1 == ("Java" + " Program"));
        System.out.println(str1 == ("Java " + word2));
    }
}
