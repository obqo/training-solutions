package week05.week05d05;

import org.junit.jupiter.api.Test;
import week05.week05d05.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void testUserGood() {
        User user = new User("Kiss", "Csaba", "a@a.com");
        assertEquals("Kiss Csaba", user.getFullName());
    }

    @Test
    void testUserNotDot() {
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "a@acom"));
    }

    @Test
    void testUserNotAt() {
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "aa.com"));
    }

    @Test
    void testUserNotAtDot() {
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "aacom"));
    }

    @Test
    void testValidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "a@.acom"));
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "@a.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("Kiss", "Csaba", "a@acom."));
        User user = new User("Kiss", "Csaba", "a.b@a.com");
        assertEquals("Kiss Csaba", user.getFullName());
    }
}