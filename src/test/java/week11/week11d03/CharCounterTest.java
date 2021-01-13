package week11.week11d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    CharCounter charCounter = new CharCounter();

    @Test
    void countChars() {
        assertEquals(2, charCounter.countChars(new String[] {"aabc", "caba", "aab"}));
        assertEquals(3, charCounter.countChars(new String[] {"abc"}));
        assertThrows(IllegalArgumentException.class, () -> charCounter.countChars(new String[] {}));
        assertThrows(IllegalArgumentException.class, () -> charCounter.countChars(null));
    }
}