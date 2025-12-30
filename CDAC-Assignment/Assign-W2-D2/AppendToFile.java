import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendToFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to append to log.txt: ");
        String input = sc.nextLine();

        String filename = "log.txt";

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(input + System.lineSeparator()); // Add new line after input
            System.out.println("Data appended successfully to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
