/*
Írj egy metódust, amely megszámolja, hogy hány különböző betű van
egy szóban. A kis és nagybetűk közötti különbség nem számít!
A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az
angol ábécé betűit!
 */
package week13.week13d05;

import java.util.HashSet;
import java.util.Set;

public class CharCounter {

    public int counter(String word) {
        if (word == null) {
            throw new IllegalArgumentException("No word");
        }
        Set<Character> charSet = new HashSet<>(stringToSet(word.toLowerCase()));
        charSet.retainAll(stringToSet(a_z()));
        return charSet.size();
    }

    private String a_z(){
        StringBuilder sb = new StringBuilder();
        for (char c ='a'; c <='z'; c++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private Set<Character> stringToSet(String str) {
        Set<Character> charSet = new HashSet<>();
        for (Character ch : str.toCharArray()) {
            charSet.add(ch);
        }
        return charSet;
    }
}

/*
    public int counter(String word) {
        if (word == null) {
            throw new IllegalArgumentException("No word");
        }
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.toLowerCase().charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                charSet.add(ch);
            }
        }
        return charSet.size();
    }
 */