//Készíts egy week05d04.Product osztályt melyben egy termékről tárolod a nevét és a lejárati dátumát (LocalDate).
// Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben int year, int month, int day. (public Product(String name, int year, int month, int day))
//A lejárati dátumot a konstruktorban állítsd össze.
//Legyen mindkettőhöz getter metódus.
//Készíts egy week05d04.Store osztályt, melyben van egy Productokat tároló lista. Legyen benne egy addProduct(Product) metódus.
//Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát. Használd a LocalDate.now() és az isBefore() metódusokat.
package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    public List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        if (isValid(product)) {
            productList.add(product);
        }
    }

    public int getNumberOfExpired() {
        int count = 0;
        for (Product product : productList) {
            if (product.getExpire().isBefore(LocalDate.now())) {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(Product product) {
        return (!productList.contains(product) && product.getExpire().isAfter(LocalDate.now()));
    }
}
