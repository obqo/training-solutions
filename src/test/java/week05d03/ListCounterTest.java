package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    void testListCounter() {
        assertEquals(1, new ListCounter().listCount(Arrays.asList("alma", "dió")));
        assertEquals(0, new ListCounter().listCount(Arrays.asList("körte", "dió")));
        assertEquals(1, new ListCounter().listCount(Arrays.asList("Alma", "dió")));
        assertEquals(2, new ListCounter().listCount(Arrays.asList("alma", "dió", "Anglia")));
        assertEquals(0, new ListCounter().listCount(Arrays.asList()));
        assertEquals(0, new ListCounter().listCount(Arrays.asList("")));
    }
}
