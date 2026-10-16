package se.lexicon.exercises.part2;

import java.util.Scanner;

/** Exercise 3: Count characters in a sentence. */
public class StringStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (Character.isDigit(ch)) {
                digits++;
            } else if (ch == ' ') {
                spaces++;
            } else if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(Character.toLowerCase(ch)) >= 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            // Punctuation and other symbols are not counted.
        }

        System.out.println("Vowels    : " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits    : " + digits);
        System.out.println("Spaces    : " + spaces);
    }
}
