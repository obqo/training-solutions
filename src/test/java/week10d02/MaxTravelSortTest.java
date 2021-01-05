package week10d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelSortTest {

    @Test
    void getMAxIndexNullList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravelSort().getMAxIndex(null));
    }

    @Test
    void getMAxIndexEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravelSort().getMAxIndex(List.of()));
    }

    @Test
    void getMAxIndex() {
        assertEquals(4, new MaxTravelSort().getMAxIndex(List.of(12,1,0,3,4,4)));
    }
}