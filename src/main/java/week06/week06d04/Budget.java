/*
Készíts az week06d04 csomagban egy Budget osztályt, amely a konstruktorában Item példányokat vár listában (List). Az Item tartalmazza az alábbi attribútumokat:
int price, int month, String name. A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát. Írjunk egy metódust, getItemsByMonth néven,
mely egy hónapot vár (1-12) és visszaadja az Itemeket az adott hónapban! Bónusz feladat: ellenőrizzük a bemeneti paramétereket és írjunk tesztet!
 */
package week06.week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> items = new ArrayList<>();

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItemsByMonth(int month) {
        if (items == null) {
            throw new IllegalArgumentException("No list!");
        }
        List<Item> buyItem = new ArrayList<>();
        for (Item item : items) {
            if (item.getMonth() == month) {
                buyItem.add(item);
            }
        }
        return buyItem;
    }
}
