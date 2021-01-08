package week10.week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void findMinSumArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> calc.findMinSum(null));
    }

    @Test
    void findMinSumArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> calc.findMinSum(new int[]{}));
    }

    @Test
    void findMinSumArrayLessItem() {
        assertEquals(2, calc.findMinSum(new int[]{3, -1}));
    }

    @Test
    void findMinSum() {
        assertEquals(4, calc.findMinSum(new int[]{3, -1, 0, 2, 5}));
    }
}