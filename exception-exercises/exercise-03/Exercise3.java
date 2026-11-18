import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BankAccount account = new BankAccount(100.00);
            System.out.println("Welcome to the simple bank. Opening balance: 100.00");

            while (true) {
                System.out.println("\n1. Check balance  2. Deposit  3. Withdraw  0. Exit");
                System.out.print("Select an option: ");

                try {
                    int option = scanner.nextInt();
                    if (option == 0) {
                        System.out.println("Goodbye!");
                        break;
                    }

                    switch (option) {
                        case 1:
                            System.out.printf("Balance: %.2f%n", account.getBalance());
                            break;
                        case 2:
                            System.out.print("Deposit amount: ");
                            account.deposit(scanner.nextDouble());
                            System.out.printf("New balance: %.2f%n", account.getBalance());
                            break;
                        case 3:
                            System.out.print("Withdrawal amount: ");
                            account.withdraw(scanner.nextDouble());
                            System.out.printf("New balance: %.2f%n", account.getBalance());
                            break;
                        default:
                            System.out.println("Please choose 0, 1, 2, or 3.");
                    }
                } catch (InsufficientBalanceException e) {
                    System.out.println("Withdrawal failed: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid amount: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: please enter a number.");
                    scanner.nextLine(); // Discard invalid input so the loop can continue.
                }
            }
        }
    }
}
