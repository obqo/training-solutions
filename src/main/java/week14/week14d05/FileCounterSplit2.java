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

public class FileCounterSplit2 {

    public Map<String, Integer> countWords(String fileName, String... words) {
        Map<String, Integer> mapOfWords = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mapOfWords = mergeMap(countOfWordsInLine(line, words), mapOfWords);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return mapOfWords;
    }

    private Map<String, Integer> mergeMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        map2.forEach((key, value) -> result.merge(key, value, Integer::sum));
        return result;
    }

    private Map<String, Integer> countOfWordsInLine(String line, String... words) {
        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String str : words) {
            if (line.toLowerCase().contains(str.toLowerCase())) {
                if (!mapOfWords.containsKey(str)) {
                    mapOfWords.put(str, 0);
                }
                mapOfWords.put(str, mapOfWords.get(str) + 1);
            }
        }
        return mapOfWords;
    }

    public static void main(String[] args) {
        FileCounterSplit2 fc = new FileCounterSplit2();
        String fileName = "src/main/java/week14/week14d05/hachiko.srt";
        System.out.println(fc.countWords(fileName, "Hachiko", "haza", "pályaudvar", "jó"));
    }
}
