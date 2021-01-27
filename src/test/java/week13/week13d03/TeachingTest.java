package week13.week13d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeachingTest {

    Teaching teaching = new Teaching();
    @Test
    void hoursPerWeekTest() {
        assertEquals(18, teaching.hoursPerWeek("Farkas Farkas"));
        assertEquals(0, teaching.hoursPerWeek("xyz"));
    }
}