package week11.week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisors() {
        DivisorFinder divisorFinder = new DivisorFinder();
        assertEquals(1, divisorFinder.findDivisors(425));
        assertEquals(0, divisorFinder.findDivisors(29));
        assertEquals(2, divisorFinder.findDivisors(15));
        assertEquals(5, divisorFinder.findDivisors(-33555));
        assertEquals(3, divisorFinder.findDivisors(4155));
        assertEquals(0, divisorFinder.findDivisors(0));
    }
}