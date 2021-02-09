/*
Adott egy fájl melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy blokk egy napot jelöl,
és minden ilyen blokk egy dátummal kezdődik. Ezután egy rendelés adatai két sorban találhatók. Az első sor a futár azonosítója,
a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.
```
2020.12.01
FUT_1
1113 Petőfi 12 12:30
FUT_2
1114 Kossuth 9 11:20
FUT_2
1211 Jókai 10 19:30
FUT_3
1191 Kossuth 9 18:12
FUT_1
1144 Tököly 11 16:33
2020.12.02
FUT_1
1123 Ady 12 12:30
....
```
A fájl beolvasása után oldjátok meg a következő feladatokat!
1. Melyik napon volt a legkevesebb rendelés?
2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést.
Ha nincs ilyen akkor dobjunk kivételt. (Vagy Optional)
3. Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
4. Melyik címre szállították a legtöbb pizzát?
 */
package week15.week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Orders {

    private final Map<String, List<Order>> ordersMap = new HashMap<>();

    public void readlines(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            String date = null;
            String courier;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 10) {
                    date = line;
                    ordersMap.put(date, new ArrayList<>());
                    courier = reader.readLine();
                }
                else {
                    courier = line;
                }
                String[] splitLine = reader.readLine().split(" ");
                String address = splitLine[0] + " " + splitLine[1] + " " + splitLine[2];
                String time = splitLine[3];
                ordersMap.get(date).add(new Order(courier, address, time));

            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public String getMinOrdersByDate() {
        String result = null;
        int min = Integer.MAX_VALUE;
        for (String key : ordersMap.keySet()) {
            if (ordersMap.get(key).size() < min) {
                min = ordersMap.get(key).size();
                result = key;
            }
        }
        return result;
    }

    public Optional<Order> getOrderByDateTime(String date, String time) {
        for (Order item : ordersMap.get(date)) {
            if (item.getTime().equals(time)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Map<String, Integer> getStatisticsByCourier() {
        Map<String, Integer> result = new HashMap<>();
        for (String key : ordersMap.keySet()) {
            for (Order item : ordersMap.get(key)) {
                if (!result.containsKey(item.getCourier())) {
                    result.put(item.getCourier(), 0);
                }
                result.put(item.getCourier(), result.get(item.getCourier()) + 1);
            }
        }
        return result;
    }

    private Map<String, Integer> getStatisticsByAddress() {
        Map<String, Integer> result = new HashMap<>();
        for (String key : ordersMap.keySet()) {
            for (Order item : ordersMap.get(key)) {
                if (!result.containsKey(item.getAddress())) {
                    result.put(item.getAddress(), 0);
                }
                result.put(item.getAddress(), result.get(item.getAddress()) + 1);
            }
        }
        return result;
    }

    public String getMaxOrdersByAddress() {
        String result = null;
        int max = Integer.MIN_VALUE;
        for (String key : getStatisticsByAddress().keySet()) {
            if (getStatisticsByAddress().get(key) > max) {
                max = getStatisticsByAddress().get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Orders orders = new Orders();
        Path file = Path.of("src/main/java/week15/week15d02/orders.txt");
        orders.readlines(file);
        System.out.println(orders.ordersMap);
        //1.
        System.out.println(orders.getMinOrdersByDate());
        //2.
        System.out.println(orders.getOrderByDateTime("2020.12.04", "13:20"));
        //3.
        System.out.println(orders.getStatisticsByCourier());
        //4.
        System.out.println(orders.getStatisticsByAddress());
        System.out.println(orders.getMaxOrdersByAddress());
    }

}
