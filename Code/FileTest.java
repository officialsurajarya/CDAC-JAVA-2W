import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File f1 = new File("data.txt");
        try {
            if (f1.createNewFile()) {
                System.out.println("File Created");
            } else {
                System.out.println("File Not Created");
            }

        } catch (Exception e) {

        }
    }
}
