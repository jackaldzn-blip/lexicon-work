package se.lexicon;

import java.util.Locale;
import java.util.Scanner;

/** Exercise 6: Count words and case-insensitive exact-word matches. */
public class WordCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a sentence  : ");
            String sentence = scanner.nextLine().trim();
            System.out.print("Enter word to find: ");
            String searchWord = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

            // Split on non-letter/non-digit characters, so commas and periods
            // are not included as part of a word.
            String[] words = sentence.isEmpty() ? new String[0]
                    : sentence.split("[^\\p{L}\\p{N}]+");
            int totalWords = 0;
            int matches = 0;
            for (String word : words) {
                if (!word.isEmpty()) {
                    totalWords++;
                    if (!searchWord.isEmpty()
                            && word.toLowerCase(Locale.ROOT).equals(searchWord)) {
                        matches++;
                    }
                }
            }

            System.out.println("Total words : " + totalWords);
            System.out.println("\"" + searchWord + "\" appears: " + matches + " times");
        }
    }
}
