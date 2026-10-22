package se.lexicon;

import java.util.Random;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int target = random.nextInt(500) + 1;
        int guesses = 0;
        int guess;

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            guesses++;

            if (guess < target) {
                System.out.println("Too small!");
            } else if (guess > target) {
                System.out.println("Too big!");
            }
        } while (guess != target);

        System.out.println("Correct! You got it in " + guesses + " guesses.");

        scanner.close();
    }
}
