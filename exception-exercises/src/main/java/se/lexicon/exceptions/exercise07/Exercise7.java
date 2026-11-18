package se.lexicon.exceptions.exercise07;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            NameManager manager = new NameManager();
            try {
                manager.addName("Alice");
                manager.addName("Bob");
            } catch (DuplicateNameException e) {
                System.out.println("Setup error: " + e.getMessage());
                return;
            }

            while (true) {
                System.out.println("\nNames: " + manager.getNames());
                System.out.println("1. Add name  2. Find name  0. Exit");
                System.out.print("Select an option: ");
                String option = scanner.nextLine().trim();

                if (option.equals("0")) {
                    System.out.println("Goodbye!");
                    break;
                }
                try {
                    if (option.equals("1")) {
                        System.out.print("Enter a name to add: ");
                        String name = scanner.nextLine();
                        manager.addName(name);
                        System.out.println("Name added successfully.");
                    } else if (option.equals("2")) {
                        System.out.print("Enter a name to find: ");
                        String name = scanner.nextLine();
                        System.out.println("Found: " + manager.findName(name));
                    } else {
                        System.out.println("Please select 0, 1, or 2.");
                    }
                } catch (DuplicateNameException | NameNotFoundException | IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
