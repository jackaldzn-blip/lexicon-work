package se.lexicon;

import java.util.Scanner;

/** Exercise 5: Check a word ignoring letter case. */
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine().trim();
        if (word.isEmpty()) {
            System.out.println("Please enter a word.");
            return;
        }

        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is NOT a palindrome.");
        }
    }
}
