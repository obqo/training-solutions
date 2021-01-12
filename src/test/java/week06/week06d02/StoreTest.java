package week06.week06d02;

import org.junit.jupiter.api.Test;
import week06.week06d02.Category;
import week06.week06d02.Product;
import week06.week06d02.Store;

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
