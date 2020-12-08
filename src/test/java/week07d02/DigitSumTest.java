package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

    @Test
    public void testDigitSum() {
        assertEquals(6, DigitSum.sumOfDigits(123));
        assertEquals(6, DigitSum.sumOfDigits(-123));
        assertEquals(0, DigitSum.sumOfDigits(0));
        assertEquals(10, DigitSum.sumOfDigits(1234));
        assertEquals(6, DigitSum.sumOfDigitsRecursiv(123));
        assertEquals(6, DigitSum.sumOfDigitsRecursiv(-123));
        assertEquals(0, DigitSum.sumOfDigitsRecursiv(0));
        assertEquals(10, DigitSum.sumOfDigitsRecursiv(1234));
        assertEquals(6, DigitSum.sumOfDigitsString(123));
        assertEquals(6, DigitSum.sumOfDigitsString(-123));
        assertEquals(0, DigitSum.sumOfDigitsString(0));
        assertEquals(10, DigitSum.sumOfDigitsString(1234));
        assertEquals(6, DigitSum.sumOfDigitsArray(123));
        assertEquals(6, DigitSum.sumOfDigitsArray(-123));
        assertEquals(0, DigitSum.sumOfDigitsArray(0));
        assertEquals(10, DigitSum.sumOfDigitsArray(1234));
    }
}
