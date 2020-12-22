package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {

    @Test
    void testMathAlgorithms() {
        assertEquals(540, MathAlgorithms.leastCommonMultiple(60, 108));
        assertEquals(900, MathAlgorithms.leastCommonMultiple(25, 36));
        assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.leastCommonMultiple(2, 0));
    }
}
