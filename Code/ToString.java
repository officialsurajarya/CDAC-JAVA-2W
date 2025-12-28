import java.util.Arrays;

public class ToString {
    public static void main(String[] args) {
        String[] arr = { "Official", "Suraj", "Arya" };
        String Ans = Arrays.toString(arr);
        System.out.println(Ans.getClass().getName());
        System.out.println(Ans);
    }
}
