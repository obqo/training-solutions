package week06.week06d05;

import org.junit.jupiter.api.Test;
import week06.week06d05.Biscuit;
import week06.week06d05.BiscuitType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BiscuitTest {

    @Test
    public void testBiscuit() {
        assertEquals("SALTY 100g", Biscuit.of(BiscuitType.SALTY, 100).toString());
        assertEquals("CRUMBLY 200g", Biscuit.of(BiscuitType.CRUMBLY, 200).toString());
        assertThrows(IllegalArgumentException.class, () -> Biscuit.of(BiscuitType.CRUMBLY, -1));
        assertThrows(IllegalArgumentException.class, () -> Biscuit.of(null, 100));
    }
}
