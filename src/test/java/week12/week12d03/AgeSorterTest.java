package week12.week12d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    AgeSorter ageSorter = new AgeSorter();

    @Test
    void sortAges() {
        int[] ages = new int[] {1, 1, 4, 2, 3, 5, 2, 2, 5};
        String beforeSort = "[1, 1, 4, 2, 3, 5, 2, 2, 5]";
        String aftersort = "[1, 1, 2, 2, 2, 3, 4, 5, 5]";
        assertEquals(beforeSort, Arrays.stream(ages).boxed().collect(Collectors.toList()).toString());
        assertEquals(aftersort, Arrays.stream(ageSorter.sortAges(ages)).boxed().collect(Collectors.toList()).toString());
    }
}