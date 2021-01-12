package week08.week08d01;

import org.junit.jupiter.api.Test;
import week08.week08d01.Robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    public void testRobot() {
        Robot robot = new Robot();
        robot.move("FFLLLLLBBBBJJJJJJJ");
        assertEquals(3, robot.getX());
        assertEquals(-3, robot.getY());
        robot.move("FFLBBBJ");
        assertEquals(1, robot.getX());
        assertEquals(-2, robot.getY());
        assertThrows(IllegalArgumentException.class, () -> robot.move("FABULA"));
    }
}
