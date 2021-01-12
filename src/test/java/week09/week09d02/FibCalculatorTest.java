package week09.week09d02;

import org.junit.jupiter.api.Test;
import week09.week09d02.FibCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {

    @Test
    void testFibCalculator() {
        assertEquals(44, FibCalculator.sumEvens(100));
    }
}
