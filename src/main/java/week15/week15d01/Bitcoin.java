/*
Egy befektető cég szeretné megnézni, hogy az elmúlt időszakban mikor lett volna érdemes venni, illetve eladni Bitcoint.
Készíts egy metódust, ami paraméterül várja a Bitcoin, valahány napi árfolyamát időrendi sorrendben egy listában, dollárban.
(Egész számok listája) A metódus visszatérési értéke két szám legyen, az első hogy hányadik napon lett volna érdemes venni,
a második pedig, hogy melyik napon lett volna érdemes eladni. Mindezt úgy, hogy a legnagyobb nyereségünk legyen.
 */
package week15.week15d01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bitcoin {

    public Map<String, Integer> maxProfit(List<Integer> prices) {
        Map<String, Integer> maxProfitMap = new HashMap<>();
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = prices.size() - 1; j > i; j--) {
                if (prices.get(j) - prices.get(i) >= diff) {
                    diff = prices.get(j) - prices.get(i);
                    maxProfitMap.put("Buy", i + 1);
                    maxProfitMap.put("Sell", j + 1);
                }
            }
        }
        return maxProfitMap;
    }

    public static void main(String[] args) {
        System.out.println(new Bitcoin().maxProfit(List.of(3, 2, 1, 2, 1, 3, 4, 3, 4)));

    }
}
