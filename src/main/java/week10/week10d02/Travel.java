/*
Adott egy fájl, utasadat.txt, mely a következőket tartalmazza:
0 20190326-0700 6572582 RVS 20210101
0 20190326-0700 8808290 JGY 7
0 20190326-0700 1680423 TAB 20190420
12 20190326-0716 3134404 FEB 20190301
12 20190326-0716 9529716 JGY 0
Ebből a megálló száma az első oszlop.
Feladat: írj egy Travel.getStopWithMax(InputStream) metódust, mely
visszaadja, hogy melyik megállóban szerettek volna a legtöbben
felszállni.
 */
package week10.week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Travel {

    public int getStopWithMax(InputStream input) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line.split(" ")[0]));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException ("Can not read file", ioe);
        } catch (NullPointerException npe) {
            throw new NullPointerException();
        }
        return getMAxIndex(list);
    }

    private int getMAxIndex(List<Integer> list) {
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

    public static void main(String[] args) {
        Travel travel = new Travel();
        InputStream input = travel.getClass().getResourceAsStream("utasadat.txt");
        System.out.println(travel.getStopWithMax(input));
    }
}
