package se.lexicon.exercises.part2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/** Exercise 14: Display today's date and weekday/weekend status. */
public class TodaysCalendar {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(
                "EEEE, d MMMM yyyy", Locale.ENGLISH);
        boolean weekend = today.getDayOfWeek() == DayOfWeek.SATURDAY
                || today.getDayOfWeek() == DayOfWeek.SUNDAY;

        System.out.println("Today is: " + today.format(format));
        System.out.println("It is a " + (weekend ? "Weekend" : "Weekday") + ".");
    }
}
