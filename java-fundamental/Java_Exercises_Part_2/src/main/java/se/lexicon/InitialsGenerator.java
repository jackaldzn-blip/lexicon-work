package se.lexicon;

import java.util.Scanner;

/** Exercise 4: Turn full names into dotted initials. */
public class InitialsGenerator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Please enter a name.");
                return;
            }

            String[] names = fullName.split("\\s+");
            StringBuilder initials = new StringBuilder();
            for (String name : names) {
                initials.append(Character.toUpperCase(name.charAt(0))).append('.');
            }
            System.out.println("Initials: " + initials);
        }
    }
}
