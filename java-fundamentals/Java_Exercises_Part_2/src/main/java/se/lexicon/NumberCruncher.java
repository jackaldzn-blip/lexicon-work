package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

/** Exercise 10: Practice three static methods. */
public class NumberCruncher {
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static double average(int a, int b, int c) {
        return (a + (double) b + c) / 3.0;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number : ");
            int a = scanner.nextInt();
            System.out.print("Enter second number: ");
            int b = scanner.nextInt();
            System.out.print("Enter third number : ");
            int c = scanner.nextInt();

            System.out.println("Maximum : " + findMax(a, b, c));
            System.out.println("Minimum : " + findMin(a, b, c));
            System.out.printf(Locale.US, "Average : %.2f%n", average(a, b, c));
        }
    }
}
