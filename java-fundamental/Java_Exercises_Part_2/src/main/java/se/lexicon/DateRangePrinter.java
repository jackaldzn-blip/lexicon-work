package se.lexicon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

/** Exercise 18: Print an inclusive range of dates. */
public class DateRangePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startText = scanner.nextLine();
        System.out.print("Enter end date   (yyyy-MM-dd): ");
        String endText = scanner.nextLine();

        LocalDate start;
        LocalDate end;
        try {
            start = LocalDate.parse(startText);
            end = LocalDate.parse(endText);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Use yyyy-MM-dd.");
            return;
        }
        if (start.isAfter(end)) {
            System.out.println("Start date must not be after end date.");
            return;
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy (eeee)", Locale.ENGLISH);
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            System.out.println(date.format(format));
        }
    }
}
