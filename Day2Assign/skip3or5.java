public class skip3or5 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Skip");
                continue;
            }
            System.out.println(i);
        }
    }
}
