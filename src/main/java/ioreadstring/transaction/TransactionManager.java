package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();

    public void uploadListFromFile(String path) {
        Path file = Path.of(path);
        try {
            List<String> content = Files.readAllLines(file);
            for (String str : content) {
                String account[] = str.split(";");
                accountList.add(new BankAccount(account[0], account[1], Double.parseDouble(account[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public void makeTransactions(String path) {
        Path file = Path.of(path);
        try {
            List<String> content = Files.readAllLines(file);
            for (String str : content) {
                String transaction[] = str.split(";");
                for (BankAccount account : accountList) {
                    if (transaction[0].equals(account.getAccountNumber()))
                        account.setBalance(Double.parseDouble(transaction[1]));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }
}
