package week09d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {

    @Test
    void testFibCalculator() {
        assertEquals(44, FibCalculator.sumEvens(100));
    }
}
