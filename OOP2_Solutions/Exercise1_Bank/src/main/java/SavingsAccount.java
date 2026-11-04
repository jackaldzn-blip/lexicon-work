/** A savings account earns interest each month. */
public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String holder, double balance, double interestRate) {
        super(holder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void processMonth() {
        adjustBalance(getBalance() * interestRate);
        System.out.println(getHolder() + ": interest credited");
    }
}
