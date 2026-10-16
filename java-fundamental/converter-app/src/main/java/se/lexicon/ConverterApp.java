package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

public class ConverterApp {

    // Menu and sub-menu choices
    private static final int TEMPERATURE_OPTION = 1;
    private static final int CURRENCY_OPTION = 2;
    private static final int BMI_OPTION = 3;
    private static final int EXIT_OPTION = 4;
    private static final int FIRST_DIRECTION = 1;
    private static final int SECOND_DIRECTION = 2;

    // Temperature conversion constants
    private static final double CELSIUS_TO_FAHRENHEIT_FACTOR = 9.0 / 5.0;
    private static final double FAHRENHEIT_TO_CELSIUS_FACTOR = 5.0 / 9.0;
    private static final double FAHRENHEIT_OFFSET = 32.0;
    private static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    private static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    // Currency conversion constants (fixed workshop rates)
    private static final double SEK_PER_USD = 10.87;
    private static final double SEK_PER_EUR = 11.32;

    // BMI constants
    private static final double HEIGHT_EXPONENT = 2.0;
    private static final double UNDERWEIGHT_LIMIT = 18.5;
    private static final double NORMAL_WEIGHT_LIMIT = 25.0;
    private static final double OVERWEIGHT_LIMIT = 30.0;
    private static final double ZERO = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = readChoice(scanner, "Choose an option: ",
                    TEMPERATURE_OPTION, EXIT_OPTION);

            if (choice == EXIT_OPTION) {
                break;
            }

            System.out.println();
            switch (choice) {
                case TEMPERATURE_OPTION:
                    showTemperatureConverter(scanner);
                    break;
                case CURRENCY_OPTION:
                    showCurrencyConverter(scanner);
                    break;
                case BMI_OPTION:
                    showBmiCalculator(scanner);
                    break;
                default:
                    break;
            }

            System.out.println();
            if (!askToContinue(scanner)) {
                break;
            }
            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("==================================");
        System.out.println("      LEXICON CONVERTER APP");
        System.out.println("==================================");
        System.out.println("1. Temperature Converter");
        System.out.println("2. Currency Converter");
        System.out.println("3. BMI Calculator");
        System.out.println("4. Exit");
        System.out.println("==================================");
    }

    private static void showTemperatureConverter(Scanner scanner) {
        System.out.println("--- Temperature Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Celsius to Fahrenheit");
        System.out.println("  2. Fahrenheit to Celsius");

        int direction = readChoice(scanner, "Your choice: ",
                FIRST_DIRECTION, SECOND_DIRECTION);

        if (direction == FIRST_DIRECTION) {
            double celsius = readNumber(scanner, "Enter temperature in Celsius: ",
                    ABSOLUTE_ZERO_CELSIUS, true,
                    "Invalid value. Temperature cannot be below absolute zero (-273.15 C).");
            double fahrenheit = convertTemperature(celsius, direction);
            System.out.printf(Locale.US, "Result: %.2f C = %.2f F%n", celsius, fahrenheit);
        } else {
            double fahrenheit = readNumber(scanner, "Enter temperature in Fahrenheit: ",
                    ABSOLUTE_ZERO_FAHRENHEIT, true,
                    "Invalid value. Temperature cannot be below absolute zero (-459.67 F).");
            double celsius = convertTemperature(fahrenheit, direction);
            System.out.printf(Locale.US, "Result: %.2f F = %.2f C%n", fahrenheit, celsius);
        }
    }

    // direction 1: Celsius -> Fahrenheit; direction 2: Fahrenheit -> Celsius
    private static double convertTemperature(double value, int direction) {
        if (direction == FIRST_DIRECTION) {
            return value * CELSIUS_TO_FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
        }
        return (value - FAHRENHEIT_OFFSET) * FAHRENHEIT_TO_CELSIUS_FACTOR;
    }

    private static void showCurrencyConverter(Scanner scanner) {
        System.out.println("--- Currency Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. SEK to USD");
        System.out.println("  2. SEK to EUR");

        int direction = readChoice(scanner, "Your choice: ",
                FIRST_DIRECTION, SECOND_DIRECTION);
        double sek = readNumber(scanner, "Enter amount in SEK: ", ZERO, true,
                "Invalid value. Amount cannot be negative.");
        double converted = convertCurrency(sek, direction);
        String currency = direction == FIRST_DIRECTION ? "USD" : "EUR";
        System.out.printf(Locale.US, "Result: %.2f SEK = %.2f %s%n",
                sek, converted, currency);
    }

    // direction 1: SEK -> USD; direction 2: SEK -> EUR
    private static double convertCurrency(double sek, int direction) {
        if (direction == FIRST_DIRECTION) {
            return sek / SEK_PER_USD;
        }
        return sek / SEK_PER_EUR;
    }

    private static void showBmiCalculator(Scanner scanner) {
        System.out.println("--- BMI Calculator ---");
        double weight = readNumber(scanner, "Enter weight in kg: ", ZERO, false,
                "Invalid value. Weight must be greater than zero.");
        double height = readNumber(scanner, "Enter height in metres: ", ZERO, false,
                "Invalid value. Height must be greater than zero.");

        double bmi = calculateBmi(weight, height);
        System.out.printf(Locale.US, "BMI: %.2f  ->  %s%n", bmi, getBmiCategory(bmi));
    }

    private static double calculateBmi(double weight, double height) {
        return weight / Math.pow(height, HEIGHT_EXPONENT);
    }

    private static String getBmiCategory(double bmi) {
        if (bmi < UNDERWEIGHT_LIMIT) {
            return "Underweight";
        } else if (bmi < NORMAL_WEIGHT_LIMIT) {
            return "Normal weight";
        } else if (bmi < OVERWEIGHT_LIMIT) {
            return "Overweight";
        }
        return "Obese";
    }

    private static int readChoice(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.printf("Invalid choice. Please enter a number between %d and %d.%n",
                        min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static double readNumber(Scanner scanner, String prompt,
            double minimum, boolean includeMinimum,
            String invalidValueMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (!Double.isFinite(value)) {
                    System.out.println("Invalid input. Please enter a number.");
                } else if (value < minimum || (!includeMinimum && value == minimum)) {
                    System.out.println(invalidValueMessage);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Continue? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Invalid input. Please type yes or no.");
        }
    }
}
