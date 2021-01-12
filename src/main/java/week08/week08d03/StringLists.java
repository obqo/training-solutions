/*
Készíts week08d03 csomagban egy StringLists osztályt és benne egy stringListsUnion(List<String> first, List<String> second) metódust,
mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából,
de egy elem nem szerepelhet kétszer!
 */
package week08.week08d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLists {

    public static List<String> stringListUnion(List<String> first, List<String> second) {
        List<String> unionList = new ArrayList<>();
        if (!isEmpty(first)) {
            unionList.addAll(first);
        }
        if (!isEmpty(second)) {
            unionList.addAll(second);
        }
        return removeDuplication(unionList);
    }

    private static List<String> removeDuplication(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String string : list) {
            if (!newList.contains(string)) {
                newList.add(string);
            }
        }
        return newList;
    }
/*
Készíts a week08d03 csomagban egy StringLists osztályt és benne egy shortestWords(List<String> words) metódust, mely paraméterül kap egy String listát
és a legrövidebb szavakat vissza adja belőle egy Listában. PL :{"aaa", "aa", "bb", "cccc", "dd"} Itt a legrövidebb szavak az "aa", "bb", "dd".
 */
    public static List<String>shortestWords(List<String> words) {
        List<String> newList = new ArrayList<>();
        if (!isEmpty(words)) {
            int lengthMin = minLength(words);
            for (String item : words) {
                if (item.length() == lengthMin) {
                    newList.add(item);
                }
            }
        }
        return newList;
    }

    private static int minLength(List<String> list) {
        int min = list.get(0).length();
        for (String item : list) {
            if (item.length() < min) {
                min = item.length();
            }
        }
        return min;
    }

    private static boolean isEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }
}
