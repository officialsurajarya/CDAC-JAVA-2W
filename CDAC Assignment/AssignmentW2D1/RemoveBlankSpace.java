public class RemoveBlankSpace {
    public static void main(String[] args) {
        String str = "  Hello   How  Are You     ";

        String result = str.replace(" ", "");

        System.out.println(result);
    }
}