package week15.week15d01;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void maxValue() {
        Function function = new Function();
        Map<Double, Double> points = Map.of(-1.0,-3.0, 0.0, 1.0, 1.0, -1.0, 2.0, -3.0, 3.0, 1.0);
        //{0.0=1.0, 3.0=1.0}
        assertEquals(2, function.maxValue(points).size());
        assertEquals(1.0, function.maxValue(points).get(0.0));
        assertEquals(1.0, function.maxValue(points).get(3.0));

        assertEquals(100.5, function.maxValue(Map.of(3.4, 100.5)).get(3.4));

        assertThrows(IllegalArgumentException.class, () -> function.maxValue(null));
        assertThrows(IllegalArgumentException.class, () -> function.maxValue(Map.of()));
    }
}