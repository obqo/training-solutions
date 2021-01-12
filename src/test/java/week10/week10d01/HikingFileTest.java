package week10.week10d01;

import org.junit.jupiter.api.Test;
import week10.week10d01.HikingFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingFileTest {

    @Test
    public void testHikingFile () {
        assertEquals(40, HikingFile.getElevation("gps.txt").getAscent());
        assertEquals(15, HikingFile.getElevation("gps.txt").getDescent());
    }
}
