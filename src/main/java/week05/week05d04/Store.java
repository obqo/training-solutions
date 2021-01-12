//Készíts egy Product osztályt melyben egy termékről tárolod a nevét és a lejárati dátumát (LocalDate).
// Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben int year, int month, int day. (public Product(String name, int year, int month, int day))
//A lejárati dátumot a konstruktorban állítsd össze.
//Legyen mindkettőhöz getter metódus.
//Készíts egy Store osztályt, melyben van egy Productokat tároló lista. Legyen benne egy addProduct(Product) metódus.
//Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát. Használd a LocalDate.now() és az isBefore() metódusokat.
package week05.week05d04;

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
        boolean validName = true;
        for (Product product1 : productList) {
            if (product1.getName().equals(product.getName())) {
                validName = false;
            }
        }
        return (validName && product.getExpire().isAfter(LocalDate.now()));
    }
}
