import java.util.Locale;

/** Shared state and behavior for every bank account. */
public abstract class Account {
    private final String holder;
    private double balance;

    public Account(String holder, double balance) {
        if (holder == null || holder.isBlank()) {
            throw new IllegalArgumentException("Holder name must not be blank.");
        }
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException("Starting balance must be a non-negative finite number.");
        }
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount < 0) {
            throw new IllegalArgumentException("Deposit must be a non-negative finite number.");
        }
        adjustBalance(amount);
    }

    /** Subclasses can apply positive interest or a negative monthly fee. */
    protected void adjustBalance(double change) {
        balance += change;
    }

    /** Each account type supplies its own month-end behavior. */
    public abstract void processMonth();

    public void printSummary() {
        System.out.printf(Locale.US, "%s | Balance: %.2f kr%n", holder, balance);
    }
}
