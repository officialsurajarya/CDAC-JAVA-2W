package Pattern;

public class CharPerimid {

    public static void main(String[] args) {
        int num = 6;
        char ch = 'A';
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
