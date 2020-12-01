package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testStore() {
        assertEquals(2, new Store(new ArrayList<>(Arrays.asList(
                new Product("ice cream", Category.FROZEN, 300),
                new Product("pommes frites", Category.FROZEN, 700),
                new Product("bread", Category.BAKEDGOODS, 700)))).getProductByCategoryName(Category.FROZEN));
    }
}
