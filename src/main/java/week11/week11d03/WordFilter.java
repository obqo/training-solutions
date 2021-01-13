/*
Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c)
metódus. A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul
a c karakter, majd ezeket visszaadja egy listában.
 */
package week11.week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        if (words == null) {
            throw new IllegalArgumentException("No list!");
        }
        if (c == Character.MIN_VALUE) {
            throw new IllegalArgumentException("No char!");
        }
        for (String word : words) {
            if (word.contains(Character.toString(c))) {
                result.add(word);
            }
        }
        return result;
    }
}
