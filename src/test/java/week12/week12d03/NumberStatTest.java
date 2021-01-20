package week12.week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    NumberStat numberStat = new NumberStat();

    @Test
    void readFile() {
        numberStat.readFile();
        assertEquals("[1, 1, 4, 2, 3, 5, 2, 2, 5]", numberStat.getNumbers().toString());
    }

    @Test
    void minSingleItem() {
        numberStat.readFile();
        assertEquals(3, numberStat.minSingleItem());
    }

    @Test
    void noNumbers() {
        assertThrows(IllegalStateException.class, () -> numberStat.minSingleItem());
    }
}