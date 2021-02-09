/*
Adott egy vetélkedő kérdésbankja egy fájlban. A fálban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava.
Olvasd be a fájl tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.
```
Mikor volt a mohacsi vesz?
1526 1 tortenelem
Melyik evben bomlott fel a Nyugat-Romai Birodalom?
476 1 tortenelem
Melyik a legkisebb primszam?
2 1 matematika
Mennyi 64 kobgyoke?
4 2 matematika
Hany atloja van a szabalyos nyolcszognek?
24 2 matematika
Melyik evben kezdodott a Honfoglalas?
895 1 tortenelem
Mikor adtak ki az Aranybullat?
1222 1 tortenelem
Melyik evben adtak ki Angliaban a Magna Chartat?
1215 3 tortenelem
```
1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként.
Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés összes adatával.
4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
 */
package week15.week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {
    private final List<QuizItem> quizItems = new ArrayList<>();

    public void loadFile(String fileName) {
        Path path = Path.of(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String name;
            while ((name = br.readLine()) != null) {
                parse(name, br.readLine());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file", e);
        }
    }

    private void parse(String name, String line) {
        String[] lineArray = line.split(" ");
        quizItems.add(new QuizItem(name, lineArray[0], Integer.parseInt(lineArray[1]), lineArray[2]));
    }

    public Map<String, List<QuizItem>> sortTheme() {
        Map<String, List<QuizItem>> result = new HashMap<>();
        for (QuizItem item : quizItems) {
            if (!result.containsKey(item.getTheme())) {
                result.put(item.getTheme(), new ArrayList<>());
            }
            result.get(item.getTheme()).add(item);
        }
        return result;
    }

    public String maxPointTheme() {
        Map<String, List<QuizItem>> work = sortTheme();
        int max = 0;
        String result = null;
        for (String key : work.keySet()) {
            int sum = 0;
            for (QuizItem item : work.get(key)) {
                sum += item.getPoint();
            }
            if (max < sum) {
                max = sum;
                result = key;
            }
        }
        return result;
    }

    public List<String> getThemeQuestion(String theme) {
        Map<String, List<QuizItem>> temp = sortTheme();
        List<String> result = new ArrayList<>();
        for (QuizItem item : temp.get(theme)) {
            result.add(item.getQuestion());
        }
        return result;
    }

    public QuizItem randomQuestion() {
        List<QuizItem> rand = new ArrayList<>(quizItems);
        Collections.shuffle(rand);
        return rand.get(0);
    }

    public static void main(String[] args) {
        Quiz q = new Quiz();
        q.loadFile("src/main/java/week15/week15d02/kerdesek.txt");
        //1.
        System.out.println(q.getThemeQuestion("matematika"));
        //2.
        System.out.println(q.randomQuestion());
        //3.
        System.out.println(q.sortTheme());
        //4.
        System.out.println(q.maxPointTheme());
    }
}