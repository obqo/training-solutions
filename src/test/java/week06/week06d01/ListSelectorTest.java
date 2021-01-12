package week06.week06d01;

import org.junit.jupiter.api.Test;
import week06.week06d01.ListSelector;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    void testListSelectorBonusGood() {
        assertEquals("[1,3,5]", new ListSelector().selectorBonus(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"))));
    }

    @Test
    void testListSelectorGood() {
        assertEquals("[135]", new ListSelector().selector(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"))));
    }

    @Test
    void testListSelectorEmpty() {
        assertEquals("", new ListSelector().selector(new ArrayList<>()));
    }

    @Test
    void testListSelectorNull() {
        assertThrows(IllegalArgumentException.class, () -> new ListSelector().selector(null));
    }

}
