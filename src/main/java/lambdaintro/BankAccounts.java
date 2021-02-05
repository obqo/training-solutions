/*
Készíts egy BankAccount osztályt accountNumber, nameOfOwner és balance attribútumokkal.
Készíts egy BankAccounts osztályt, mely konstruktorban BankAccount listát vár.
A metódusok rendre új listát készítenek, rendezik a következő szabályok alapján, és adják vissza.
Rendezés bankszámlaszám alapján
Rendezés rendelkezésre álló összeg alapján, de előjeltől függetlenül
Rendezés rendelkezésre álló összeg alapján, az előjel számítson, de csökkenő sorrendben
Név alapján, de ha a név megegyezik, akkor bankszámlaszám alapján. Amennyiben nincs kitöltve a név (értéke null, elől szerepeljen)
Implementációs javaslat
Kizárólag lambda kifejezéseket vagy method reference-eket használj.
Használd a következő metódusokat (persze a megfelelő paraméterezéssel): Comparator.naturalOrder(),
Comparator.comparing(), Comparator.reversed(), Comparator.nullsFirst(), Comparator.thenComparing().
 */
package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private final List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.naturalOrder());
        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.comparing((other) -> Math.abs(other.getBalance())));
        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        ordered.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return ordered;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        ordered.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator))
                .thenComparing(BankAccount::getAccountNumber));
        return ordered;
    }
}
