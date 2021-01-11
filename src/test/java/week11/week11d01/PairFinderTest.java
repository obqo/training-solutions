package week11.week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairs() {
        PairFinder pairFinder = new PairFinder();
        assertEquals(1, pairFinder.findPairs(new int[]{5, 1, 4, 5}));
        assertEquals(3, pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 9, 7, 6, 7}));
        assertEquals(1, pairFinder.findPairs(new int[]{1, 2, 1, 3, 1}));
        assertEquals(0, pairFinder.findPairs(new int[]{5}));
        assertEquals(0, pairFinder.findPairs(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> pairFinder.findPairs(null));
    }
}