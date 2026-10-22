package se.lexicon;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        System.out.println(first + " + " + second + " = " + (first + second));
        System.out.println(first + " - " + second + " = " + (first - second));
        System.out.println(first + " * " + second + " = " + (first * second));

        if (second != 0) {
            System.out.println(first + " / " + second + " = " + (first / second));
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        scanner.close();
    }
}
