import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileStream {

    public static void main(String[] args) {

        String data = "Hello, Java!";
        String filename = "output.txt";

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(data.getBytes());
            System.out.println("Data written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(filename)) {
            int i;
            System.out.print("File content: ");
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
