public class ReplaceUsingStringBuilder {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Java is cool");
        sb.replace(0, 4, "Python");
        System.out.println(sb);
    }
}
