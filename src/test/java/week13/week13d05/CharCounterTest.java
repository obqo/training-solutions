package week13.week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void counter() {
        assertEquals(3, new CharCounter().counter("aAő áé wWx.345"));
        assertThrows(IllegalArgumentException.class, () -> new CharCounter().counter(null));
    }
}