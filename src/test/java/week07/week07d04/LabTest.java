package week07.week07d04;

import org.junit.jupiter.api.Test;
import week07.week07d04.Lab;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LabTest {

    @Test
    public void testLab() {
        Lab lab = new Lab("Öröklődés");
        assertEquals("title='Öröklődés, completed=false, completedAt=null", lab.toString());
        lab.complete();
        assertEquals("title='Öröklődés, completed=true, completedAt=2020-12-10", lab.toString());
        lab.complete(LocalDate.of(2020, 12, 12));
        assertEquals("title='Öröklődés, completed=true, completedAt=2020-12-12", lab.toString());
        Lab otherLab = new Lab("Öröklődés", LocalDate.of(2020, 11, 30));
        assertEquals("title='Öröklődés, completed=true, completedAt=2020-11-30", otherLab.toString());
        otherLab.complete(LocalDate.of(2020, 12, 01));
        assertEquals("title='Öröklődés, completed=true, completedAt=2020-12-01", otherLab.toString());
    }
}
