package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    void testSayHello() {
        assertEquals("Hello John Doe", new Gentleman().sayHello("John Doe"));
        assertEquals("Hello Anonymous", new Gentleman().sayHello(""));
    }
}
