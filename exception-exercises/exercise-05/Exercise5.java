import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Enter the first integer: ");
                int first = scanner.nextInt();

                System.out.print("Enter the second integer: ");
                int second = scanner.nextInt();

                System.out.println("Result: " + (first / second));
            } catch (ArithmeticException e) {
                System.out.println("Error: Cannot divide by zero.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter whole numbers only.");
            } finally {
                // Always runs, whether division succeeds or an exception is caught.
                System.out.println("Finally block: The division attempt is complete.");
            }
        }
    }
}
