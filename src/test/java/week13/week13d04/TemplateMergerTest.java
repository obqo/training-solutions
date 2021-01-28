package week13.week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void merge() {
        TemplateMerger tm = new TemplateMerger();
        List<Employee> employees = List.of(
                new Employee("John Doe", 1980),
                new Employee("Jack Doe", 1990));
        Path file = Path.of("src/main/java/week13/week13d04/lineformat.txt");
        String result = "Az alkalmazott neve: John Doe, születési éve: 1980\n" +
                "Az alkalmazott neve: Jack Doe, születési éve: 1990\n";
        assertEquals(result, tm.merge(file, employees));
    }
}