package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelArrayTest {

    @Test
    void getMAxIndexNullList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravelArray().getMAxIndex(null));
    }

    @Test
    void getMAxIndexEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravelArray().getMAxIndex(List.of()));
    }

    @Test
    void getMAxIndex() {
        assertEquals(4, new MaxTravelArray().getMAxIndex(List.of(12,12,0,3,4,4)));
    }
}