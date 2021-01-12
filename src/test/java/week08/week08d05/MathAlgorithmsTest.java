package week08.week08d05;

import org.junit.jupiter.api.Test;
import week08.week08d05.MathAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    void testMathAlgorithms() {
        assertEquals(12, MathAlgorithms.greatestCommonDivisor(60, 108));
        assertEquals(1, MathAlgorithms.greatestCommonDivisor(25, 36));
        assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.greatestCommonDivisor(2, 0));
    }
}
