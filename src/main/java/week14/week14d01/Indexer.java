/*
Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes névvel,
mely ezzel a betűvel kezdődik).
Példa:
System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}
 */
package week14.week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        isList(names);
        Map<Character, List<String>> mapOfIndex = new HashMap<>();
        for (String name : names) {
            isValidName(name);
            char initial = name.charAt(0);
            if (!mapOfIndex.containsKey(initial)) {
                mapOfIndex.put(initial, new ArrayList<>());
            }
            mapOfIndex.get(initial).add(name);
        }
        return mapOfIndex;
    }

    private void isList(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("No list!");
        }
    }

    private void isValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
    }
}
