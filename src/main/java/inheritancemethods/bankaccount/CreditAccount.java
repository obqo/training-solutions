package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (getBalance() + overdraftLimit < amount + costOfTransaction(amount)) {
            return false;
        }
        if (getBalance() >= amount + costOfTransaction(amount)) {
            super.transaction(amount);
        } else {
            overdraftLimit -= amount + costOfTransaction(amount) - getBalance();
            balanceToZero();
        }
        return true;
    }
}
