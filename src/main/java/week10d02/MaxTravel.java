/*
Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni.
A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember, 4-esben 2 ember
akar felszállni. A MaxTravel osztály getMaxIndex() metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni.
Maximum 30 megálló lehet.
 */
package week10d02;

import java.util.Arrays;
import java.util.List;

public class MaxTravel {

    public int getMAxIndex(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No list or empty");
        }
        int result = list.get(0);
        int maxCount = 0;
        for (int item : list) {
            if (maxCount < counter(list, item)) {
                maxCount = counter(list, item);
                result = item;
            }
        }
        return result;
    }

    private int counter(List<Integer> list, int number) {
        int count = 0;
        for (int item : list) {
            if (item == number) {
                count++;
            }
        }
        return count;
    }
}
