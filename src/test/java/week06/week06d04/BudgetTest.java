package week06.week06d04;

import org.junit.jupiter.api.Test;
import week06.week06d04.Budget;
import week06.week06d04.Item;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {

    @Test
    public void testBudget() {
        assertEquals(2, new Budget(new ArrayList<>(Arrays.asList(
                new Item(250, 11, "milk"),
                new Item(350, 6, "ice cream"),
                new Item(250, 11, "bread")))).getItemsByMonth(11).size());
        assertThrows(IllegalArgumentException.class, () -> new Budget(new ArrayList<>(Arrays.asList(
                new Item(-1, 11, "milk")))).getItemsByMonth(11));
        assertThrows(IllegalArgumentException.class, () -> new Budget(new ArrayList<>(Arrays.asList(
                new Item(250, 13, "milk")))).getItemsByMonth(11));
        assertThrows(IllegalArgumentException.class, () -> new Budget(new ArrayList<>(Arrays.asList(
                new Item(250, 11, "")))).getItemsByMonth(11));
        assertThrows(IllegalArgumentException.class, () -> new Budget(new ArrayList<>(Arrays.asList(
                new Item(250, 11, null)))).getItemsByMonth(11));
    }
}
