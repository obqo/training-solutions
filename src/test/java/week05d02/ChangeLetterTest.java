package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    void testChangeLetter() {
        assertEquals("*lm*", new ChangeLetter().changeVowels("alma"));
        assertEquals("*lm*", new ChangeLetter().changeVowels("Alma"));
        assertEquals("*****", new ChangeLetter().changeVowels("AeIoU"));
        assertEquals("XyZ", new ChangeLetter().changeVowels("XyZ"));
        assertEquals("123$ 3254", new ChangeLetter().changeVowels("123$ 3254"));
        assertEquals("", new ChangeLetter().changeVowels(""));
    }
}
