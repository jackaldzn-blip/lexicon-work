package se.lexicon.exceptions.exercise03;

public class BankAccount {
    private double balance;

    public BankAccount(double openingBalance) {
        if (!Double.isFinite(openingBalance) || openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative or invalid.");
        }
        balance = openingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        checkPositiveAmount(amount);
        balance += amount;
    }

    // We declare this checked exception in the method signature.
    public void withdraw(double amount) throws InsufficientBalanceException {
        checkPositiveAmount(amount);
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    String.format("Insufficient balance: %.2f available, %.2f requested.", balance, amount));
        }
        balance -= amount;
    }

    private void checkPositiveAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be a positive, finite number.");
        }
    }
}
