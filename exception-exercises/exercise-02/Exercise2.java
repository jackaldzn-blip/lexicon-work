import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    // 'throws' tells the caller to handle our checked custom exception.
    public static int readNumberInRange(Scanner scanner) throws OutOfRangeException {
        System.out.print("Enter an integer between 1 and 100: ");
        int number = scanner.nextInt(); // Can throw InputMismatchException.

        if (number < 1 || number > 100) {
            throw new OutOfRangeException("The number must be between 1 and 100.");
        }
        return number;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                int number = readNumberInRange(scanner);
                System.out.println("Valid number: " + number);
            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be an integer.");
            } catch (OutOfRangeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
