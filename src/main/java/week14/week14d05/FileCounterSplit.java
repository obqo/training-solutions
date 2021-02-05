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

public class FileCounterSplit {

    public Map<String, Integer> wordCounter(String fileName, String... words) {
        Map<String, Integer> result;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            result = processLine(reader, words);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
        return result;
    }

    private Map<String, Integer> processLine(BufferedReader br, String[] words) throws IOException {
        Map<String, Integer> result = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            for (String word : words) {
                modifyMap(result, line, word);
            }
        }
        return result;
    }

    private void modifyMap(Map<String, Integer> result, String line, String word) {
        if (line.toLowerCase().contains(word.toLowerCase())) {
            if (!result.containsKey(word)) {
                result.put(word, 0);
            }
            result.put(word, result.get(word) + 1);
        }
    }

    public static void main(String[] args) {
        FileCounterSplit fc = new FileCounterSplit();
        String fileName = "src/main/java/week14/week14d05/hachiko.srt";
        System.out.println(fc.wordCounter(fileName, "Hachiko", "haza", "pályaudvar", "jó"));
    }
}
