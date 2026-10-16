package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

/** Exercise 8: Print powers 1 through 10 using Math.pow. */
public class PowerTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();

        for (int exponent = 1; exponent <= 10; exponent++) {
            double result = Math.pow(base, exponent);
            System.out.printf(Locale.US, "%s ^ %-2d = %12.1f%n",
                    base == (long) base ? Long.toString((long) base) : Double.toString(base),
                    exponent, result);
        }
    }
}
