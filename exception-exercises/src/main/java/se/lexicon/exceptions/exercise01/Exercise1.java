package se.lexicon.exceptions.exercise01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Enter the first integer: ");
                int first = scanner.nextInt();

                System.out.print("Enter the second integer: ");
                int second = scanner.nextInt();

                // Division by zero throws an ArithmeticException for integers.
                int result = first / second;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter whole numbers only.");
            }
        }
    }
}
