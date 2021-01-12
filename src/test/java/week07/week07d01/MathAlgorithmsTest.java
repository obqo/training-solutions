package week07.week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static week07.week07d01.MathAlgorithms.isPrime;

public class MathAlgorithmsTest {

    @Test
    public void testMathAlgorithms() {
        assertFalse(isPrime(1));
        assertFalse(isPrime(-1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(-2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(-3));
        assertFalse(isPrime(4));
        assertFalse(isPrime(-4));
        assertTrue(isPrime(13));
        assertTrue(isPrime(-13));
        assertTrue(isPrime(Integer.MAX_VALUE));
        assertFalse(isPrime(Long.MAX_VALUE));
    }
}
