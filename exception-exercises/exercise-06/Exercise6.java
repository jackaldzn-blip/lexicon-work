import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise6 {
    // Simple format check for a classroom exercise (not complete RFC validation).
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)+$");

    public static void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email address: use a format such as name@example.com.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your email address: ");
            String email = scanner.nextLine().trim();

            try {
                validateEmail(email);
                System.out.println("Email address is valid: " + email);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
