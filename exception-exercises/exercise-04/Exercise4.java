import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("File name [numbers.txt]: ");
            String input = scanner.nextLine().trim();
            Path path = Path.of(input.isEmpty() ? "numbers.txt" : input);

            // Outer try/catch is responsible for file access errors.
            try {
                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i).trim();
                    if (line.isEmpty()) {
                        continue;
                    }

                    // Inner try/catch is responsible for integer parsing errors.
                    try {
                        int number = Integer.parseInt(line);
                        System.out.println("Line " + (i + 1) + ": " + number);
                    } catch (NumberFormatException e) {
                        System.out.println("Line " + (i + 1) + ": '" + line + "' is not an integer.");
                    }
                }
            } catch (NoSuchFileException e) {
                System.out.println("File not found: " + path);
            } catch (IOException e) {
                System.out.println("Could not read the file: " + e.getMessage());
            }
        }
    }
}
