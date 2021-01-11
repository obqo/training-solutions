package week11.week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    DivisorFinder divisorFinder = new DivisorFinder();

    @Test
    void findDivisors() {
        assertEquals(1, divisorFinder.findDivisors(425));
        assertEquals(0, divisorFinder.findDivisors(29));
        assertEquals(2, divisorFinder.findDivisors(15));
        assertEquals(5, divisorFinder.findDivisors(-33555));
        assertEquals(3, divisorFinder.findDivisors(41105));
        assertEquals(0, divisorFinder.findDivisors(0));
    }

    @Test
    void findDivisorsWithString() {
        assertEquals(1, divisorFinder.findDivisorsWithString(425));
        assertEquals(0, divisorFinder.findDivisorsWithString(29));
        assertEquals(2, divisorFinder.findDivisorsWithString(15));
        assertEquals(5, divisorFinder.findDivisorsWithString(-33555));
        assertEquals(3, divisorFinder.findDivisorsWithString(41105));
        assertEquals(0, divisorFinder.findDivisorsWithString(0));
    }
}