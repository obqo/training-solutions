package exceptionclass.bank2;

public class Account {

    private String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null)
            throw new IllegalArgumentException("Invalid account number");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100_000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) throws InvalidBankOperationException {
        if (maxSubtract <= 0)
            throw new InvalidAmountBankOperationException();
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) throws InvalidBankOperationException {
        if (amount > maxSubtract || amount <= 0)
            throw new InvalidAmountBankOperationException();
        if (balance < amount)
            throw new LowBalanceBankOperationException();
        this.balance -= amount;
        return this.balance;
    }

    public double deposit(double amount) throws InvalidBankOperationException {
        if (amount <= 0)
            throw new InvalidAmountBankOperationException();
        this.balance += amount;
        return this.balance;
    }
}
