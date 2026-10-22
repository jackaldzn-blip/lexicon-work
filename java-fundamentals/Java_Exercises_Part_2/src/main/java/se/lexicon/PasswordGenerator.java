package se.lexicon;

import java.util.Scanner;

/** Exercise 12: Build a random alphanumeric password. */
public class PasswordGenerator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter password length: ");
            int length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Password length must be positive.");
                return;
            }

            String allowed = "abcdefghijklmnopqrstuvwxyz"
                    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * allowed.length());
                password.append(allowed.charAt(index));
            }
            System.out.println("Generated password: " + password);
            // Math.random is required by the exercise, but is not suitable for
            // generating security-sensitive real-world passwords.
        }
    }
}
