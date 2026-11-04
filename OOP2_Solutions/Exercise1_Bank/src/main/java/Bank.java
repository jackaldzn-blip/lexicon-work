import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** The bank manages a collection of different account implementations. */
public class Bank {
    private final String name;
    private final List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(Objects.requireNonNull(account, "Account must not be null."));
    }

    public void processAllAccounts() {
        for (Account account : accounts) {
            account.processMonth(); // Dynamic dispatch; no instanceof or type check.
        }
    }

    public void printAllSummaries() {
        for (Account account : accounts) {
            account.printSummary();
        }
    }
}
