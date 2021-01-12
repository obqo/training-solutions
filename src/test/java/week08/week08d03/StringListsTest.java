package week08.week08d03;

import org.junit.jupiter.api.Test;
import week08.week08d03.StringLists;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {

    @Test
    void testStringListsNoEmpty() {
        assertEquals("[1, 2, 3, 4]", StringLists.stringListUnion(
                new ArrayList<>(Arrays.asList("1", "2", "3", "1")),
                new ArrayList<>(Arrays.asList("1", "4"))).toString());
    }

    @Test
    void testStringListsEmpty() {
        assertEquals("[1, 4]", StringLists.stringListUnion(new ArrayList<>(), new ArrayList<>(Arrays.asList("1", "4"))).toString());
        assertEquals("[1, 2, 3]", StringLists.stringListUnion(new ArrayList<>(Arrays.asList("1", "2", "3", "1")), new ArrayList<>()).toString());
    }

    @Test
    void testStringListsNull() {
        assertEquals("[1, 2, 3]", StringLists.stringListUnion(new ArrayList<>(Arrays.asList("1", "2", "3", "1")), null).toString());
        assertEquals("[1, 4]", StringLists.stringListUnion(null, new ArrayList<>(Arrays.asList("1", "4"))).toString());
        assertEquals("[]", StringLists.stringListUnion(null, null).toString());
    }

    @Test
    void testShotestWordsNoEmpty () {
        assertEquals("[aa, bb, dd]", StringLists.shortestWords(new ArrayList<>(Arrays.asList("aaa", "aa", "bb", "cccc", "dd"))).toString());
    }

    @Test
    void testShotestWordsEmpty () {
        assertEquals("[]", StringLists.shortestWords(new ArrayList<>()).toString());
    }

    @Test
    void testShotestWordsNull () {
        assertEquals("[]", StringLists.shortestWords(null).toString());
    }
}
