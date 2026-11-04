/** Run this class to demonstrate Exercise 1. */
public class App {
    public static void main(String[] args) {
        Bank bank = new Bank("Lexicon Bank");

        bank.addAccount(new SavingsAccount("Ali", 1000, 0.02));
        bank.addAccount(new CheckingAccount("Sara", 500, 25));
        bank.addAccount(new LoanAccount("Omar", 5000, 0.03));

        System.out.println("Starting balances:");
        bank.printAllSummaries();

        System.out.println("\nProcessing month-end:");
        bank.processAllAccounts();

        System.out.println("\nUpdated balances:");
        bank.printAllSummaries();
    }
}
