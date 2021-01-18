package week12.week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    GradeRounder gradeRounder = new GradeRounder();

    @Test
    void roundGrades() {
        int[] grades = new int[]{1, 3, 4, 5, 6, 7, 10, 84};
        String result = "[1, 3, 4, 5, 6, 7, 10, 85]";
        assertEquals(result, Arrays.stream(gradeRounder.roundGrades(grades)).boxed().collect(Collectors.toList()).toString());
    }

    @Test
    void roundGradesNoNumbers() {
        assertThrows(IllegalArgumentException.class, () -> gradeRounder.roundGrades(null));
    }
}