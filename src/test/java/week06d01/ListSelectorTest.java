package week06d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    void testListSelectorBonusGood() {
        assertEquals("[1,3,5]", new ListSelector().selectorBonus(Arrays.asList("1", "2", "3", "4", "5")));
    }

    @Test
    void testListSelectorGood() {
        assertEquals("[135]", new ListSelector().selector(Arrays.asList("1", "2", "3", "4", "5")));
    }

    @Test
    void testListSelectorEmpty() {
        assertEquals("", new ListSelector().selector(Arrays.asList()));
    }

    @Test
    void testListSelectorNull() {
        assertThrows(IllegalArgumentException.class, () -> new ListSelector().selector(null));
    }

}
