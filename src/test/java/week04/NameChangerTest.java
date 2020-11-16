package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTest {

    @Test
    public void testChangeFirstName() {
        NameChanger nameChanger = new NameChanger("Kiss Béla");
        assertEquals("Kiss Béla", nameChanger.getFullname());
        nameChanger.changeFirstName("Nagy");
        assertEquals("Nagy Béla", nameChanger.getFullname());
    }
}
