interface MathUtils {
    static int square(int x) {
        return x * x;
    }
}

public class MathUtilsDemo {
    public static void main(String[] args) {
        System.out.println(MathUtils.square(5));
    }
}
