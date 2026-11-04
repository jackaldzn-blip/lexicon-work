/** Tiny dependency-free checks. Run with java -ea -cp out BankExerciseTest. */
public class BankExerciseTest {
    private static void expectIllegalArgument(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException exception) {
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException");
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Ali", 1000, 0.02);
        CheckingAccount checking = new CheckingAccount("Sara", 500, 25);
        LoanAccount loan = new LoanAccount("Omar", 5000, 0.03);

        Bank bank = new Bank("Lexicon Bank");
        bank.addAccount(savings);
        bank.addAccount(checking);
        bank.addAccount(loan);
        bank.processAllAccounts();

        assert Math.abs(savings.getBalance() - 1020) < 0.0001;
        assert Math.abs(checking.getBalance() - 475) < 0.0001;
        assert Math.abs(loan.getBalance() - 5150) < 0.0001;

        savings.deposit(80);
        assert Math.abs(savings.getBalance() - 1100) < 0.0001;

        expectIllegalArgument(() -> new SavingsAccount("  ", 100, 0.02));
        expectIllegalArgument(() -> new CheckingAccount("Sara", -1, 25));
        expectIllegalArgument(() -> savings.deposit(-10));

        System.out.println("All Exercise 1 checks passed.");
    }
}
