package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        System.out.println("Bank account number:");
        Scanner scanner =new Scanner(System.in);
        String accountNumber = scanner.nextLine();
        System.out.println("Bank account owner:");
        String owner = scanner.nextLine();
        System.out.println("Bank account balance:");
        int balance = scanner.nextInt();
        BankAccount bankAccount = new BankAccount(accountNumber, owner, balance);
        System.out.println("Bank account:\n" + bankAccount.getInfo());

        scanner.nextLine();
        System.out.println("Deposit:");
        int amount = scanner.nextInt();
        bankAccount.deposit(amount);
        System.out.println("Bank account after deposit:\n" + bankAccount.getInfo());

        scanner.nextLine();
        System.out.println("Withdraw:");
        amount = scanner.nextInt();
        bankAccount.withdraw(amount);
        System.out.println("Bank account after withdraw:\n" + bankAccount.getInfo());

        scanner.nextLine();
        System.out.println("Transfer Bank account number:");
        accountNumber = scanner.nextLine();
        System.out.println("Transfer Bank account owner:");
        owner = scanner.nextLine();
        System.out.println("Transfer Bank account balance:");
        balance = scanner.nextInt();
        BankAccount anotherBankAccount = new BankAccount(accountNumber, owner, balance);
        System.out.println("Transfer Bank account:\n" + anotherBankAccount.getInfo());

        scanner.nextLine();
        System.out.println("Transfer amount:");
        amount = scanner.nextInt();
        bankAccount.transfer(anotherBankAccount, amount);
        System.out.println("Bank account after transfer:\n" + bankAccount.getInfo());
        System.out.println("Transfer Bank account after transfer:\n" + anotherBankAccount.getInfo());

    }
}
