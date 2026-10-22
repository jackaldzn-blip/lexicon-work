package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

/** Exercise 19: Demonstrate overloaded convert methods. */
public class UnitConverter {
    // Kilometres to miles.
    public static double convert(double km) {
        return km * 0.621371;
    }

    // Kilograms to pounds (unit must be "lbs").
    public static double convert(double kg, String unit) {
        if (!"lbs".equalsIgnoreCase(unit)) {
            throw new IllegalArgumentException("Unit must be lbs.");
        }
        return kg * 2.2046226218;
    }

    // Celsius to Fahrenheit (true) or Kelvin (false).
    public static double convert(double celsius, boolean toFahrenheit) {
        return toFahrenheit ? celsius * 9.0 / 5.0 + 32 : celsius + 273.15;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            System.out.println("Choose conversion:");
            System.out.println("1. km -> miles");
            System.out.println("2. kg -> lbs");
            System.out.println("3. °C -> °F / K");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value in km: ");
                    double km = scanner.nextDouble();
                    System.out.printf(Locale.US, "%.1f km = %.2f miles%n", km, convert(km));
                    break;
                case 2:
                    System.out.print("Enter value in kg: ");
                    double kg = scanner.nextDouble();
                    System.out.printf(Locale.US, "%.1f kg = %.2f lbs%n", kg, convert(kg, "lbs"));
                    break;
                case 3:
                    System.out.print("Enter value in Celsius: ");
                    double celsius = scanner.nextDouble();
                    if (celsius < -273.15) {
                        System.out.println("Temperature cannot be below absolute zero.");
                        return;
                    }
                    System.out.print("Convert to Fahrenheit? (y/n; n = Kelvin): ");
                    String answer = scanner.next();
                    boolean toFahrenheit = answer.equalsIgnoreCase("y");
                    if (!toFahrenheit && !answer.equalsIgnoreCase("n")) {
                        System.out.println("Please enter y or n.");
                        return;
                    }
                    System.out.printf(Locale.US, "%.1f °C = %.2f %s%n", celsius,
                            convert(celsius, toFahrenheit), toFahrenheit ? "°F" : "K");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }
    }
}
