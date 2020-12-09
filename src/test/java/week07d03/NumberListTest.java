package week07d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class NumberListTest {

    @Test
    public void testNumberList() {
        assertTrue(NumberList.isIncreasing(Arrays.asList(1, 2, 3, 3, 5)));
        assertFalse(NumberList.isIncreasing(Arrays.asList(1, 2, 4, 3, 5)));
        assertTrue(NumberList.isIncreasing(Arrays.asList(1, 2)));
        assertFalse(NumberList.isIncreasing(Arrays.asList(1, -1)));
        assertTrue(NumberList.isIncreasing(Arrays.asList(1)));
        assertThrows(IllegalArgumentException.class, () -> NumberList.isIncreasing(null));
    }
}
