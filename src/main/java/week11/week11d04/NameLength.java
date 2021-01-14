/*
Adott egy nevek listája. Add vissza egy listában, hogy milyen hosszúságú J karakterrel kezdődő nevek szerepelnek a listában!
Minden szám csak egyszer szerepeljen! A NameLength osztály getLengths(List<String>) metódusába dolgozz!
Ha a bemenet pl. List.of("Joe", "Jack", "Jane", "Jake", "George", "William"), a visszatérési érték [3, 4] legyen!
 */
package week11.week11d04;

import java.util.ArrayList;
import java.util.List;

public class NameLength {

    public List<Integer> getLengths(List<String> words) {
        List<Integer> result = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith("J")) {
                int length = word.length();
                if (!result.contains(length)) {
                    result.add(length);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NameLength().getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }
}
