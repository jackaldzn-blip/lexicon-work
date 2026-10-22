package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

/** Exercise 7: Calculate circle area and circumference. */
public class CircleCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.print("Enter radius: ");
            double radius = scanner.nextDouble();
            if (!Double.isFinite(radius) || radius < 0) {
                System.out.println("Radius must be a non-negative, finite number.");
                return;
            }

            double area = Math.PI * Math.pow(radius, 2);
            double circumference = 2 * Math.PI * radius;
            System.out.printf(Locale.US, "Area         : %.2f%n", area);
            System.out.printf(Locale.US, "Circumference: %.2f%n", circumference);
        }
    }
}
