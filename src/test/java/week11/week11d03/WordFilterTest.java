package week11.week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    WordFilter wordFilter = new WordFilter();

    @Test
    void wordsWithChar() {
        assertEquals("[alma, szilva]", wordFilter.wordsWithChar(List.of("alma", "dió", "szilva"), 'a').toString());
        assertEquals("[dió]", wordFilter.wordsWithChar(List.of("alma", "dió", "szilva"), 'ó').toString());
        assertEquals("[]", wordFilter.wordsWithChar(List.of("alma", "dió", "szilva"), 'x').toString());
        assertEquals("[]", wordFilter.wordsWithChar(List.of(), 'x').toString());
        assertThrows(IllegalArgumentException.class, () -> wordFilter.wordsWithChar(List.of("alma", "dió", "szilva"), Character.MIN_VALUE));
        assertThrows(IllegalArgumentException.class, () -> wordFilter.wordsWithChar(null, 'x'));
    }
}