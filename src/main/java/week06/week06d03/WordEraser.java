/*
A WordEraser osztályban legyen egy eraseWord(String words, String word) metódus, mely az első paraméter szöveget úgy változtatja meg,
hogy a második paraméter összes előforulását kitörli belőle. A words paraméterben a szavak szóközzel vannak elválasztva.
A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel. (Mellőzzük a replace és replaceAll használatát)
 */
package week06.week06d03;

import java.util.ArrayList;
import java.util.List;

public class WordEraser {

    public String eraseWordChar(String words, String word) {
        if (isEmpty(words) || isEmpty(word)) {
            throw new IllegalArgumentException("String is null!");
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) != ' ') {
                actual.append(words.charAt(i));
            }
            else {
                if (!actual.toString().equals(word)) {
                    sb.append(actual).append(" ");
                }
                actual = new StringBuilder();
            }
        }
        if (!actual.toString().equals(word)) {
            sb.append(actual);
        }
        return sb.toString().trim();
    }

    public String eraseWordSubstring(String words, String word) {
        if (isEmpty(words) || isEmpty(word)) {
            throw new IllegalArgumentException("String is null!");
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = words.indexOf(' ');
        while (end > -1) {
            String actual = words.substring(start, end);
            if (!actual.equals(word)) {
                sb.append(actual).append(" ");
            }
            start = end + 1;
            end = words.indexOf(' ', start);
        }
        String finish = words.substring(start, words.length());
        if (!finish.equals(word)) {
            sb.append(finish);
        }
        return sb.toString().trim();
    }

    public String eraseWordSplit(String words, String word) {
        if (isEmpty(words) || isEmpty(word)) {
            throw new IllegalArgumentException("String is null!");
        }
        String[] wordArray = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String wA : wordArray) {
            if (!wA.equals(word)) {
                sb.append(wA).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String eraseWordSplitList(String words, String word) {
        if (isEmpty(words) || isEmpty(word)) {
            throw new IllegalArgumentException("String is null!");
        }
        String[] wordArray = words.split(" ");
        List<String> list = new ArrayList<>();
        for (String wA : wordArray) {
            if (!wA.equals(word)) {
                list.add(wA);
            }
        }
        return String.join(" ", list);
    }

    public boolean isEmpty(String string) {
        return string == null;
    }
}
