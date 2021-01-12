/*
Legyen a classpath-on egy `examples.md` fájl, mely a gyakorlati feladatok leírásait tartalmazza
a következő formátumban! A `ExamplesStore` osztályba írj egy `getTitlesOfExamples()`
metódust, mely visszaadja a feladatok címeit egy listában!
```
# Első feladat
Írj egy programot, amely
kiírja az összeadás eredményét!
# Második feladat
Írj egy programot,
mely kiírja a kivonás eredményét!
```
 */
package week08.week08d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamplesStore {

    public static List<String> getTitlesOfExamples() {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(ExamplesStore.class.getResourceAsStream("/examples.md")).useDelimiter("(\r\n)|\n")) {
            while (scanner.hasNextLine()) {
                String line = scanner.next();
                if (line.startsWith("#")) {
                    list.add(line);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getTitlesOfExamples());
    }
}
