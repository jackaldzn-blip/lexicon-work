package se.lexicon;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %-2d = %d%n", number, i, number * i);
        }

        scanner.close();
    }
}
