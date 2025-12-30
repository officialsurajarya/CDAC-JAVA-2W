import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyEx {

    public static void main(String[] args) {

        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (FileReader fr = new FileReader(sourceFile);
                FileWriter fw = new FileWriter(destFile)) {

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destFile);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
