package week10d02;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    Travel travel = new Travel();
    InputStream input = travel.getClass().getResourceAsStream("utasadat.txt");
    InputStream input1 = travel.getClass().getResourceAsStream("utasadat1.txt");
    InputStream input2 = travel.getClass().getResourceAsStream("utasadat2.txt");

    @Test
    void getStopWithMaxNoFile() {
        assertThrows(NullPointerException.class, () -> new Travel().getStopWithMax(input1));
    }

    @Test
    void getStopWithMaxInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> new Travel().getStopWithMax(input2));
    }

    @Test
    void getStopWithMax() {
        assertEquals(10, new Travel().getStopWithMax(input));
    }
}