package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

public class CafeApp {
    private static final String[] ITEMS = {
        "Espresso", "Cappuccino", "Latte", "Croissant", "Sandwich"
    };
    private static final double[] PRICES = {25.0, 35.0, 40.0, 30.0, 55.0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome! What is your name? ");
        String customerName = scanner.nextLine().trim();
        System.out.println("Hi " + customerName + "! Here is our menu:\n");
        displayMenu();

        int itemNumber = readNumber(scanner, "Enter item number (1-5): ", 1, 5);
        int quantity = readNumber(scanner, "How many? ", 1, Integer.MAX_VALUE);
        boolean isMember = readMembership(scanner);

        double subtotal = calculateSubtotal(PRICES[itemNumber - 1], quantity);
        double discount = calculateDiscount(subtotal, isMember);
        double vat = calculateVat(subtotal - discount);
        double total = calculateTotal(subtotal, discount, vat);

        printReceipt(customerName, ITEMS[itemNumber - 1], quantity,
                subtotal, discount, vat, total);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("==============================");
        System.out.println("       Lexicon Cafe");
        System.out.println("==============================");
        for (int i = 0; i < ITEMS.length; i++) {
            System.out.printf(Locale.US, "%d. %-16s %5.2f SEK%n", i + 1, ITEMS[i], PRICES[i]);
        }
        System.out.println("==============================\n");
    }

    private static int readNumber(Scanner scanner, String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= minimum && value <= maximum) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Ask again below.
            }
            System.out.println("Invalid number. Please try again.");
        }
    }

    private static boolean readMembership(Scanner scanner) {
        while (true) {
            System.out.print("Loyalty member? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("yes")) return true;
            if (answer.equalsIgnoreCase("no")) return false;
            System.out.println("Please enter yes or no.");
        }
    }

    private static double calculateSubtotal(double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    private static double calculateDiscount(double subtotal, boolean isMember) {
        if (isMember) return subtotal * 0.15;
        if (subtotal > 150.0) return subtotal * 0.10;
        return 0.0;
    }

    private static double calculateVat(double discountedAmount) {
        return discountedAmount * 0.12;
    }

    private static double calculateTotal(double subtotal, double discount, double vat) {
        return subtotal - discount + vat;
    }

    private static void printReceipt(String customer, String item, int quantity,
                                     double subtotal, double discount, double vat, double total) {
        System.out.println("\n==============================");
        System.out.println("      LEXICON CAFE");
        System.out.println("==============================");
        System.out.println("Customer  : " + customer);
        System.out.println("Item      : " + item + " x " + quantity);
        System.out.printf(Locale.US, "Subtotal  : %.2f SEK%n", subtotal);
        if (discount > 0) {
            System.out.printf(Locale.US, "Discount  : -%.2f SEK%n", discount);
        }
        System.out.printf(Locale.US, "VAT       : %.2f SEK%n", vat);
        System.out.println("------------------------------");
        System.out.printf(Locale.US, "TOTAL     : %.2f SEK%n", total);
        System.out.println("==============================");
        System.out.println("   Thank you, " + customer + "!");
        System.out.println("   See you next time.");
        System.out.println("==============================");
    }
}
