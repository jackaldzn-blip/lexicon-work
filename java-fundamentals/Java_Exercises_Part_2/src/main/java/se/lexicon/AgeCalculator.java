package se.lexicon;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/** Exercise 15: Calculate age and days to next birthday. */
public class AgeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter birth year : ");
            int year = scanner.nextInt();
            System.out.print("Enter birth month: ");
            int month = scanner.nextInt();
            System.out.print("Enter birth day  : ");
            int day = scanner.nextInt();

            LocalDate birthDate;
            try {
                birthDate = LocalDate.of(year, month, day);
            } catch (RuntimeException e) {
                System.out.println("Invalid birth date.");
                return;
            }
            LocalDate today = LocalDate.now();
            if (birthDate.isAfter(today)) {
                System.out.println("Birth date cannot be in the future.");
                return;
            }

            LocalDate birthdayThisYear = birthDate.withYear(today.getYear());
            int age = today.getYear() - birthDate.getYear();
            if (today.isBefore(birthdayThisYear)) {
                age--;
            }
            LocalDate nextBirthday = today.isAfter(birthdayThisYear)
                    ? birthDate.withYear(today.getYear() + 1)
                    : birthdayThisYear;
            long daysRemaining = ChronoUnit.DAYS.between(today, nextBirthday);

            System.out.println("Your age            : " + age + " years");
            System.out.println("Days until birthday : " + daysRemaining);
        }
    }
}
