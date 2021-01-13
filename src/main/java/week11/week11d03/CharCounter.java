/*
Készítsünk egy CharCounter osztályt, melyben van egy int countChars(String[] chars) metódus. A feladat az,
hogy összeszámoljuk azokat a karaktereket az összes chars-ban lévő String-ből, amelyek mindegyik String-ben
szerepelnek. Példa: Ha a chars-ban ["abc", "cba", "ab"] szerepel, akkor a visszatérési érték 2, mert az a
és a b karakter szerepel mindegyik String-ben.
 */
package week11.week11d03;

import java.util.Arrays;

public class CharCounter {

    public int countChars(String[] chars) {
        if (chars == null || chars.length == 0) {
            throw new IllegalArgumentException("No list");
        }
        if (chars.length == 1) {
            return chars[0].length();
        } else {
            String first = chars[0];
            int result = 0;
            StringBuilder usedChar = new StringBuilder();
            for (int i = 0; i < first.length(); i++) {
                if (!usedChar.toString().contains(Character.toString(first.charAt(i)))) {
                    usedChar.append(first.charAt(i));
                    if (contains(first.charAt(i), chars)) {
                        result++;
                    }
                }
            }
            return result;
        }
    }

    private boolean contains(char c, String[] chars) {
        boolean included = true;
        for (String item : chars) {
            if (!item.contains(Character.toString(c))) {
                included = false;
            }
        }
        return included;
    }

    public static void main(String[] args) {
        CharCounter charCounter = new CharCounter();
        System.out.println(charCounter.countChars(new String[]{"abc", "cba", "ab"}));
        System.out.println(charCounter.countChars(new String[]{"abc"}));
        System.out.println(charCounter.countChars(new String[]{}));
        System.out.println(charCounter.countChars(null));
    }
}
