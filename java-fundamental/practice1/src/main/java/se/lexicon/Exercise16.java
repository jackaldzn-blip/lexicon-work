package se.lexicon;

import java.util.Scanner;

public class Exercise16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        int count = 0;

        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            total += number;
            count++;

            System.out.println("Total: " + total + " | Count: " + count);
        }

        System.out.println("--- Summary ---");
        System.out.println("Count:   " + count);
        System.out.println("Total:   " + total);

        if (count > 0) {
            double average = (double) total / count;
            System.out.println("Average: " + average);
        } else {
            System.out.println("Average: 0.0");
        }

        scanner.close();
    }
}
