/*
Hozz létre egy Product osztályt melynek adattagjai a név, kategória és ár, rendre, String, String int. Készíts egy Store osztályt benne egy Product listával,
amit konstruktorban kap meg. Legyen egy getProductByCategoryName(Category), ami visszaadja, hogy a paraméterül kapott kategóriából hány darab van a listában.
Bónusz: A kategória legyen enum FROZEN,DAIRY,BAKEDGOODS,OTHER felsorolókkal.
 */
package week06.week06d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {

    List<Product> products = new ArrayList<>();

    public Store(List<Product> products) {
        this.products = products;
    }

    public int getProductByCategoryName(Category category) {
        int count = 0;
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Store(new ArrayList<>(Arrays.asList())));
    }
}
