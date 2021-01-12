package week10.week10d02;

import org.junit.jupiter.api.Test;
import week10.week10d02.MaxTravel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMAxIndexNullList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravel().getMAxIndex(null));
    }

    @Test
    void getMAxIndexEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> new MaxTravel().getMAxIndex(List.of()));
    }

    @Test
    void getMAxIndex() {
        assertEquals(12, new MaxTravel().getMAxIndex(List.of(12,12,0,3,4,4)));
    }
}