package se.lexicon.exercises.part2;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/** Exercise 9: Check the Pythagorean theorem against three sides. */
public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.print("Enter side a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter side b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter side c: ");
        double c = scanner.nextDouble();

        double[] sides = { a, b, c };
        Arrays.sort(sides);
        System.out.println("Longest side: " + sides[2]);

        if (!Double.isFinite(sides[2]) || sides[0] <= 0
                || sides[0] + sides[1] <= sides[2]) {
            System.out.println("These sides do not form a valid triangle.");
            return;
        }

        double sumOfSquares = Math.pow(sides[0], 2) + Math.pow(sides[1], 2);
        double longestSquared = Math.pow(sides[2], 2);
        boolean rightTriangle = Math.abs(sumOfSquares - longestSquared) <= 1e-9 * Math.max(1.0, longestSquared);

        System.out.println(rightTriangle
                ? "This IS a right triangle."
                : "This is NOT a right triangle.");
    }
}
