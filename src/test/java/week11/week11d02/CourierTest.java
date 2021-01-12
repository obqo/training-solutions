package week11.week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    public void testCourierDay4() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(2, 1, 1));
        courier.addRide(new Ride(3, 1, 1));
        courier.addRide(new Ride(5, 1, 1));
        courier.addRide(new Ride(6, 1, 1));
        assertEquals(4, courier.freeDay());
    }


    @Test
    public void testCourierDay1() {
        Courier courier = new Courier();
        courier.addRide(new Ride(2, 1, 1));
        courier.addRide(new Ride(3, 1, 1));
        courier.addRide(new Ride(4, 1, 1));
        courier.addRide(new Ride(6, 1, 1));
        courier.addRide(new Ride(7, 1, 1));
        assertEquals(1, courier.freeDay());
    }

    @Test
    public void testCourierDay6() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(2, 1, 1));
        courier.addRide(new Ride(3, 1, 1));
        courier.addRide(new Ride(4, 1, 1));
        courier.addRide(new Ride(5, 1, 1));
        courier.addRide(new Ride(6, 1, 1));
        courier.addRide(new Ride(7, 1, 1));
        assertEquals(-1, courier.freeDay());
    }


    @Test
    public void testCourierNumber() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(2, 1, 1));
        courier.addRide(new Ride(2, 2, 1));
        courier.addRide(new Ride(2, 3, 1));
        courier.addRide(new Ride(3, 1, 1));
        courier.addRide(new Ride(5, 1, 1));
        courier.addRide(new Ride(6, 1, 1));
        assertEquals(4, courier.freeDay());
    }

    @Test
    public void testCourierThrowRepeat() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 1, 1)));
    }

    @Test
    public void testCourierThrowWrongNum1() {
        Courier courier = new Courier();
        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 2, 1)));
    }

    @Test
    public void testCourierThrowWrongNum2() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 3, 1)));
    }

    @Test
    public void testCourierThrowWrongOrder1() {
        Courier courier = new Courier();
        courier.addRide(new Ride(3, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 1, 1)));
    }

    @Test
    public void testCourierThrowWrongOrder2() {
        Courier courier = new Courier();
        courier.addRide(new Ride(3, 1, 1));
        courier.addRide(new Ride(3, 2, 1));
        courier.addRide(new Ride(3, 3, 1));
        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(3, 1, 1)));
    }

    @Test

    public void testCourierNoRestDay() {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 1));
        courier.addRide(new Ride(1, 2, 1));
        courier.addRide(new Ride(1, 3, 1));
        courier.addRide(new Ride(2, 1, 1));
        courier.addRide(new Ride(2, 2, 1));
        assertEquals(3, courier.freeDay());
    }
}