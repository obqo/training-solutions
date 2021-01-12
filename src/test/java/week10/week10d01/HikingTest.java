package week10.week10d01;

import org.junit.jupiter.api.Test;
import week10.week10d01.Hiking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HikingTest {

    @Test
    public void testHiking() {
        assertEquals(13.0, Hiking.getPlusElevation(List.of(10.0, 20.0, 15.0, 18.0)), 0.0001);
        assertEquals(0.0, Hiking.getPlusElevation(List.of(10.0)), 0.0001);
        assertEquals(0.0, Hiking.getPlusElevation(List.of()), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> Hiking.getPlusElevation(null));
    }
}
