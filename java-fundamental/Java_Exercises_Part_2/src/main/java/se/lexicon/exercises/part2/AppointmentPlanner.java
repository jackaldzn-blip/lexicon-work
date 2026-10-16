package se.lexicon.exercises.part2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Exercise 17: Sort and display three appointments. */
public class AppointmentPlanner {
    private static class Appointment {
        String name;
        LocalDateTime dateTime;

        Appointment(String name, LocalDateTime dateTime) {
            this.name = name;
            this.dateTime = dateTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern(
                "eeee, dd MMMM yyyy 'at' HH:mm", Locale.ENGLISH);
        List<Appointment> appointments = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter appointment " + i + " name: ");
            String name = scanner.nextLine();
            System.out.print("Enter appointment " + i + " date-time (yyyy-MM-dd HH:mm): ");
            String input = scanner.nextLine();
            try {
                LocalDateTime dateTime = LocalDateTime.parse(input, inputFormat);
                appointments.add(new Appointment(name, dateTime));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date-time. Please re-enter this appointment.");
                i--;
            }
        }

        appointments.sort(Comparator.comparing(a -> a.dateTime));
        System.out.println("\n--- Your Schedule ---");
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            System.out.printf("%d. %-13s – %s%n", i + 1, appointment.name,
                    appointment.dateTime.format(outputFormat));
        }
    }
}
