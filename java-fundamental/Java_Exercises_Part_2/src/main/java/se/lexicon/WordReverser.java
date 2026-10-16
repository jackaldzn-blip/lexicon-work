package se.lexicon;

import java.util.Scanner;

/** Exercise 1: Reverse a word with StringBuilder. */
public class WordReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}
