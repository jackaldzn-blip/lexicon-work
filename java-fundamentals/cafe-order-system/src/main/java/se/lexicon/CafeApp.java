package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

public class CafeApp {
    // Shared menu for both the console and the GUI.
    static final String[] ITEMS = {"Espresso", "Cappuccino", "Latte", "Croissant", "Sandwich"};
    static final double[] PRICES = {25, 35, 40, 30, 55};
    static final int MAX_QUANTITY = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customers = 0;
        double revenue = 0;

        // Challenge 1: repeat until the cashier enters done.
        while (true) {
            System.out.print("Next customer name (or 'done' to close): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("done")) break;
            if (name.isEmpty()) {
                System.out.println("Please enter a name.");
                continue;
            }

            System.out.println("Hi " + name + "! Here is our menu:\n");
            showMenu();
            boolean member = readMembership(scanner);
            Order order = new Order(name, member); // Challenge 3

            // Challenge 4: collect multiple products in one order.
            while (true) {
                int number = readNumber(scanner, "Item number (0 to finish): ", 0, ITEMS.length);
                if (number == 0) {
                    if (!order.items.isEmpty()) break;
                    System.out.println("Please add at least one item.");
                    continue;
                }
                int quantity = readNumber(scanner, "How many? ", 1, MAX_QUANTITY);
                order.addItem(ITEMS[number - 1], PRICES[number - 1], quantity);
                System.out.println(ITEMS[number - 1] + " added.\n");
            }

            order.printReceipt();
            customers++;
            revenue += order.total();
        }

        System.out.println("\n======= END OF DAY =======");
        System.out.println("Customers served: " + customers);
        System.out.printf(Locale.US, "Total revenue: %.2f SEK%n", revenue);
    }

    static void showMenu() {
        System.out.println("======= LEXICON CAFE =======");
        for (int i = 0; i < ITEMS.length; i++) {
            System.out.printf(Locale.US, "%d. %-12s %.2f SEK%n", i + 1, ITEMS[i], PRICES[i]);
        }
    }

    // Challenge 2: read a number and ask again if it is invalid.
    static int readNumber(Scanner scanner, String question, int min, int max) {
        while (true) {
            System.out.print(question);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) return number;
            } catch (NumberFormatException e) {
                // Non-numeric input; show the same message below.
            }
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
    }

    static boolean readMembership(Scanner scanner) {
        while (true) {
            System.out.print("Loyalty member? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("yes")) return true;
            if (answer.equalsIgnoreCase("no")) return false;
            System.out.println("Please enter yes or no.");
        }
    }
}
