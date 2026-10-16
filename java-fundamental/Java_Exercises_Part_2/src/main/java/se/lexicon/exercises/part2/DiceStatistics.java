package se.lexicon.exercises.part2;

import java.util.Scanner;

/** Exercise 11: Roll two dice and count doubles. */
public class DiceStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rolls? ");
        int rolls = scanner.nextInt();
        if (rolls <= 0) {
            System.out.println("Number of rolls must be positive.");
            return;
        }

        int doubles = 0;
        for (int i = 1; i <= rolls; i++) {
            int die1 = (int) (Math.random() * 6) + 1;
            int die2 = (int) (Math.random() * 6) + 1;
            boolean isDouble = die1 == die2;
            if (isDouble) {
                doubles++;
            }
            System.out.printf("Roll %d: %d + %d = %d%s%n", i,
                    die1, die2, die1 + die2, isDouble ? "  DOUBLE!" : "");
        }
        System.out.println("Doubles rolled: " + doubles + " out of " + rolls);
    }
}
