package week14.week14d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IndexerTest {

    @Test
    void index() {
        assertThrows(IllegalArgumentException.class, () -> new Indexer().index(null));
        assertThrows(IllegalArgumentException.class, () -> new Indexer().index(Arrays.asList("")));
        assertEquals("{A=[Abraham], L=[Lujza, Luis], M=[Magdolna], O=[Odon]}",
                new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Luis")).toString());
        assertEquals("{A=[Abraham], L=[Lujza, Luis], M=[Magdolna], O=[Odon, Odon]}",
                new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Luis", "Odon")).toString());
    }
}