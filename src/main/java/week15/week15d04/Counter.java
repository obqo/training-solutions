/*
Számoljuk össze, hogy egy fájlban hány mássalhangzó, hány magánhangzó és hány egyéb karakter van.
A space-eket ne vegyük figyelembe! A kis- és nagybetű különbség nem számít!
 */
package week15.week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Counter {

    private static final String VOWEL="aeiou";
    private static final String CONSONANT="bcdfghjklmnpqrstvwxyz";

    private Map<String, Integer> charTypeMap = new HashMap<>();

    public void readlines(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            initMap();
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void processLine(String line) {
        for (char item : line.toCharArray()) {
            String str = Character.toString(item).toLowerCase();
            if (!str.equals(" ")) {
                if (VOWEL.contains(str)) {
                    charTypeMap.put("vowel", charTypeMap.get("vowel") + 1);
                }
                else if (CONSONANT.contains(str)) {
                    charTypeMap.put("consonant", charTypeMap.get("consonant") + 1);
                }
                else {
                    charTypeMap.put("other", charTypeMap.get("other") + 1);
                }
            }
        }
    }

    public void initMap() {
        charTypeMap.put("vowel", 0);
        charTypeMap.put("consonant", 0);
        charTypeMap.put("other", 0);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Path file = Path.of("src/main/java/week15/week15d04/data.csv");
        counter.readlines(file);
        System.out.println(counter.charTypeMap);
    }
}
