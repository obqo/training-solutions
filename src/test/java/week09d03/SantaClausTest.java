package week09d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SantaClausTest {

    private static final List<Person> persons = Arrays.asList(
            new Person("John", 10),
            new Person("Jane", 13),
            new Person("Jack", 15),
            new Person("Joe", 25),
            new Person("Bill", 45));

    @Test
    void testSantaClaus() {
        assertThrows(IllegalArgumentException.class, () -> new SantaClaus(null));
        SantaClaus santaClaus = new SantaClaus(persons);
        santaClaus.getThroughChimneys();
        System.out.println(santaClaus.getPeople());
    }
}
