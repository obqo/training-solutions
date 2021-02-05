/*
A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy countWords() metódust,
mely paraméterül várja a fájlt, varargsban szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a szövegben.
Legyenek mondjuk a beadott szavak: "Hachiko", "haza", "pályaudvar", "jó"
 */
package week14.week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileCounter {

    public Map<String, Integer> countWords(String fileName, String... words) {
        Map<String, Integer> mapOfWords = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String str : words) {
                    if (line.contains(str)) {
                        if (!mapOfWords.containsKey(str)) {
                            mapOfWords.put(str, 0);
                        }
                        mapOfWords.put(str, mapOfWords.get(str) + 1);
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return mapOfWords;
    }
}
