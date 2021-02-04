/*
Legyen egy szerződés (Contract) osztály, melynek van egy String client és egy List<Integer> monthlyPrices attribútuma.
Az előbbi a szerződő neve, a második pedig a havonta fizetendő összeg.
Legyen egy ContractCreator osztály, melynek van egy ContractCreator(String client, List<Integer> monthlyPrices) konstruktora,
mely létrehoz egy szerződéssablont, a paraméterként megadott adatokkal, melyet összesen EGY attribútumban tárolj!
Majd írj egy create(String name) metódust, mely a sablon alapján létrehoz egy új szerződést,
de a nevet kicseréli a paraméterként megadott névre.
Próbáld ki, hogy a visszaadott szerződésben módosítod a 12. havi értéket. Ha létrehozol egy új szerződést a sablon alapján,
akkor a 12 havi érték az eredeti sablon alapján van kitöltve?
 */
package week14.week14d04;

import java.util.List;

public class ContractCreator {

    private final Contract contract;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        contract = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(new Contract(name, contract.getMonthlyPrices()));
    }

    public Contract getContract() {
        return contract;
    }
}
