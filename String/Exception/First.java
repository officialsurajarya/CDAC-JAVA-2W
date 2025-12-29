public class First {
    public static void main(String[] args) {
        x();
    }

    static void x() {
        y();
    }

    static void y() {
        int a = 7 / 0;
    }
}