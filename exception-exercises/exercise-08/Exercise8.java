import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text to save: ");
            String text = scanner.nextLine();
            Path output = Path.of("output.txt");

            // BufferedWriter implements AutoCloseable. It closes automatically.
            try (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
                writer.write(text);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing the file: " + e.getMessage());
                return;
            }
            System.out.println("Saved text to: " + output.toAbsolutePath());
        }
    }
}
