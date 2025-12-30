import java.io.File;
import java.io.IOException;

public class FileInfoEx {

    public static void main(String[] args) {

        try {
            File file = new File("testfile.txt");

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            if (file.exists()) {
                System.out.println("Absolute Path: " + file.getAbsolutePath());
                System.out.println("File Size: " + file.length() + " bytes");
                System.out.println("Readable: " + file.canRead());
            }

        } catch (IOException e) {
            System.out.println("Error occurred while handling the file.");
        }
    }
}
