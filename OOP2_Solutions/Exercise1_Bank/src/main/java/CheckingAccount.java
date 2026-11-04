/** A checking account incurs a monthly fee. */
public class CheckingAccount extends Account {
    private final double monthlyFee;

    public CheckingAccount(String holder, double balance, double monthlyFee) {
        super(holder, balance);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void processMonth() {
        adjustBalance(-monthlyFee);
        System.out.println(getHolder() + ": monthly fee charged");
    }
}
