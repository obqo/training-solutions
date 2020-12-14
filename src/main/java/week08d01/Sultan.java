/*
A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből. A börtönben 100 cella van. Mindegyik cella
zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz, ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.  (Ekkor minden cella nyitva lesz) A második napon minden másodikon
fordítsanak egyet, így minden második zárva lesz. A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva
lesz. A week08d01.Sultan osztályba írj egy metódust openDoors() néven,  aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a 100. napon!
Az osztály szabadon bővíthető!
 */
package week08d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sultan {

    public static List<Integer> openDoors(int[] cells, int day) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < day; i++) {
            for (int j = i; j < cells.length; j += i + 1) {
                cells[j] *= -1;
                if (j == i && cells[j] == 1) {
                    list.add(j + 1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] cells = new int[100];
        Arrays.fill(cells, -1);
        System.out.println(openDoors(cells, 100));
    }


}
