package se.lexicon;

import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int reversed = 0;
        int remaining = number;

        while (remaining > 0) {
            int digit = remaining % 10;
            reversed = reversed * 10 + digit;
            remaining = remaining / 10;
        }

        System.out.println("Reversed: " + reversed);

        scanner.close();
    }
}
