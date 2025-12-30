import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

    public static void main(String[] args) {

        String data = "Welcome to File Handling in Java";
        String filename = "notes.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            System.out.println("Data written successfully to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
