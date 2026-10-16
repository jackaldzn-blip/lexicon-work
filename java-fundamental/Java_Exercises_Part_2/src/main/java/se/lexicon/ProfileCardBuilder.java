package se.lexicon;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/** Exercise 20: Make a profile card with StringBuilder. */
public class ProfileCardBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name      : ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date: ");
        String dateText = scanner.nextLine();
        System.out.print("Enter city      : ");
        String city = scanner.nextLine();
        System.out.print("Enter email     : ");
        String email = scanner.nextLine();

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid birth date. Use yyyy-MM-dd.");
            return;
        }
        if (birthDate.isAfter(LocalDate.now())) {
            System.out.println("Birth date cannot be in the future.");
            return;
        }
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        String[] lines = {
                "Name  : " + name,
                "Age   : " + age,
                "City  : " + city,
                "Email : " + email
        };
        int width = 30;
        for (String line : lines) {
            width = Math.max(width, line.length() + 2);
        }
        String title = "Profile Card";
        int leftPadding = (width - title.length()) / 2;
        String centeredTitle = " ".repeat(leftPadding) + title;

        StringBuilder card = new StringBuilder();
        card.append("╔").append("═".repeat(width)).append("╗\n");
        addRow(card, centeredTitle, width);
        card.append("╠").append("═".repeat(width)).append("╣\n");
        for (String line : lines) {
            addRow(card, line, width);
        }
        card.append("╚").append("═".repeat(width)).append("╝\n");
        System.out.println();
        System.out.print(card);
    }

    private static void addRow(StringBuilder card, String text, int width) {
        // One space on both sides of the content inside the border.
        card.append("║ ").append(text);
        card.append(" ".repeat(width - text.length() - 2));
        card.append(" ║\n");
    }
}
