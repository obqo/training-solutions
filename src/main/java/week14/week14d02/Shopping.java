/*
A következő feladatban online bevásárlással kapcsolatos staisztikákat kell megoldani.
Minden vásárlás a következőképpen épül fel. Vásárló egyedi azonosítója, a vásárlás egyedi azonosítója
majd a rendelt termékek, melyek után zárójelben szerepel azok ára. Ezeket egy fájlban tároljuk.
Adatok:
```
BK123-1211: bread(200),soda(120),carrot(320)
RA22-112: tomato(300),sugar(100),salt(100),choclate(200)
BK123-111: beer(300),chips(250),potato(300)
RA22-1145: peas(300),yoghurt(200),milk(200),chicken(1300),bread(200)
SM123-11: pork_belly(1200),ketchup(800),corn(250),alufoil(300)
GT23-011: bread(200),tomato(300),salt(100)
RA22-01112: salami(300),sour_cream(250)
SM123-120: dogfood(900),potato(300),tomato(200),chicken(1300),fish(3000),tuna(1200),pasta(200)
BK123-567: corn(200),jam(800),Nutella(1200),cereal(1200)
```
A fájlban egy vásárlóhoz több rendelés is tartozhat. Olvasd be és tárold el a memóriában az adatokat.
Fontos, hogy a webáruház ismerje a vásárlóit a vásárlók pedig ismerjék összes vásárlásukat.
A fájlban a vásárlások időrendi sorrendben szerepelnek egyénenként. Tehát mindig a legújabb vásárlás van legelöl a listában.
Oldd meg az alábbi feladatokat:
1. Készíts egy metódust, ami visszaadja vásárlási azonosító alapján az adott vásárlás összértékét.
2. Készíts egy metódust, ami egy vásárló alapján visszaadja, hogy az adott vásárló mennyit pénzt költött eddig összesen a webáruházban.
3. Készíts egy metódus, ami a vásárlónak ABC sorrendbe rendezi egy vásárláson belül a termékeket, vásárlás azonosító alapján.
(Bónusz: megoldhatod úgy, hogy vagy név vagy ár alapján rendezze annak megfelelően, hogy hogyan hívjuk a metódust.)
Fontos, hogy ne rendezzük át az eredeti listát egy másolatot rendezzünk és azt adjuk vissza.
4. Készíts egy metódust, ami visszaadja, adott termék neve alapján, hogy összesen hányat rendeletek belőle a fájl alapján.

 */
package week14.week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shopping {

    private final List<Basket> baskets = new ArrayList<>();

    public void readFiles() {
        InputStreamReader is = new InputStreamReader(Shopping.class.getResourceAsStream("orders-sen.txt"));
        try (BufferedReader reader = new BufferedReader(is)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(": ");
                String id = splitLine[0].split("-")[1];
                String buyer = splitLine[0].split("-")[0];
                baskets.add(new Basket(id, buyer, productsStringToList(splitLine[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private List<Product> productsStringToList(String str) {
        List<Product> products = new ArrayList<>();
        String[] splitLine = str.split(",");
        for (String s : splitLine) {
            String[] split = s.split("\\(");
            products.add(new Product(split[0], Integer.parseInt(split[1].replace(")", ""))));
        }
        return products;
    }

    public int basketPrice(String id) {
        int result = 0;
        int index = findIndexById(id);
        for (Product product : baskets.get(index).getProducts()) {
            result += product.getPrice();
        }
        return result;
    }

    private int findIndexById(String id) {
        return Collections.binarySearch(baskets, new Basket(id, null, null), new Comparator<>() {
            public int compare(Basket b1, Basket b2)
            {
                return b1.getId().compareTo(b2.getId());
            }
        }) + baskets.size();
    }

    public int buyerSpent(String buyer) {
        int result = 0;
        for (Basket basket : baskets) {
            if (basket.getBuyer().equals(buyer)) {
                for (Product product : basket.getProducts()) {
                    result += product.getPrice();
                }
            }
        }
        return result;
    }

    public TreeSet<String> getPruductsByOrderedId(String id) {
        TreeSet<String> products = new TreeSet<>();
        int index = findIndexById(id);
        for (Product product : baskets.get(index).getProducts()) {
            products.add(product.getName());
        }
        return products;
    }

    public Map<String, Integer> getMapOfProducts() {
        Map<String, Integer> map = new HashMap<>();
        for (Basket basket : baskets) {
            for (Product item : basket.getProducts()) {
                if (!map.containsKey(item.getName())) {
                    map.put(item.getName(), 1);
                }
                else {
                    map.put(item.getName(), map.get(item.getName()) + 1);
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        shopping.readFiles();
        System.out.println(shopping.baskets);
        System.out.println(shopping.basketPrice("112")); //1.
        System.out.println(shopping.buyerSpent("BK123")); //2.
        System.out.println(shopping.getPruductsByOrderedId("112")); //3.
        System.out.println(shopping.getMapOfProducts()); //4.
    }
}
