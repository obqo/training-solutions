package exceptionclass.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) {
        if (accounts == null)
            throw new IllegalArgumentException("Accounts is null");
        this.accounts = accounts;
    }

    public void payment(String accountNumber, double balance) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.subtract(balance);
    }

    public void deposit(String accountNumber, double balance) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.deposit(balance);
    }

    private Account get(String accountNumber) throws InvalidBankOperationException {
        for (Account account : accounts) {
            if (accountNumber.equals(account.getAccountNumber()))
                return account;
        }
        throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
