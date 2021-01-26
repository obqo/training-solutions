package week13.week13d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {
    Airport airport = new Airport();

    @Test
    public void readFileTest() {
        airport.readFiles();
        assertEquals("BH2946", airport.getFlies().get(9).getRegNumber());
    }

    @Test
    public void wichIsMoreTest() {
        airport.readFiles();
        assertEquals("Departure", airport.wichIsMore());
    }

    @Test
    public void searchFlyAtRegNumberTest() {
        airport.readFiles();
        assertEquals("Dublin", airport.searchFlyAtRegNumber("FC5354").getCity());
        assertThrows(IllegalArgumentException.class, () -> airport.searchFlyAtRegNumber("AB1234"));
    }

    @Test
    public void searchFliesFromToCityTest() {
        airport.readFiles();
        assertEquals(3, airport.searchFliesFromToCity("Budapest","Arrival").size());
    }

    @Test
    public void searchEarliestFlyTest() {
        airport.readFiles();
        assertEquals("FG3210", airport.searchEarliestFly().getRegNumber());
    }
}