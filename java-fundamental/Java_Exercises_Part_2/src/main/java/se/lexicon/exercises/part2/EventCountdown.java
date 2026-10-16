package se.lexicon;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/** Exercise 16: Count days until or since an event. */
public class EventCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event date (yyyy-MM-dd): ");
        String dateText = scanner.nextLine();

        LocalDate eventDate;
        try {
            eventDate = LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Use yyyy-MM-dd.");
            return;
        }

        long days = ChronoUnit.DAYS.between(LocalDate.now(), eventDate);
        if (days > 0) {
            System.out.println(name + " is in " + days + " days!");
        } else if (days < 0) {
            System.out.println(name + " was " + (-days) + " days ago.");
        } else {
            System.out.println(name + " is today!");
        }
    }
}
