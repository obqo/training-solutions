/*
A week07d03 csomagban hozz létre egy NumberList osztályt. Ennek legyen egy metódusa isIncreasing(List<Integer>) mely egy számokból álló
listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e és ennek megfelelően igaz vagy hamis
értékkel tér vissza. Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a 1,2,3,3,3,5 számokat növekvőnek tekintjük.
 */
package week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {

    public static boolean isIncreasing(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("List is null");
        }
        if (numbers.size() ==1) {
            return true;
        }
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}