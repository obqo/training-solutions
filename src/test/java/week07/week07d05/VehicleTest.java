package week07.week07d05;

import org.junit.jupiter.api.Test;
import week07.week07d05.Car;
import week07.week07d05.Motorcycle;
import week07.week07d05.TransmissionType;
import week07.week07d05.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void testVehicle() {
        //Vehicle
        assertEquals(5, new Vehicle().getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, new Vehicle().getTransmissionType());

        assertEquals(5, new Vehicle(TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Vehicle(TransmissionType.AUTOMATIC).getTransmissionType());

        assertEquals(6, new Vehicle(6).getNumberOfGears());
        assertEquals(TransmissionType.MANUAL, new Vehicle(6).getTransmissionType());

        assertEquals(5, new Vehicle(5, TransmissionType.MANUAL).getNumberOfGears());
        assertEquals(3, new Vehicle(3, TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Vehicle(3, TransmissionType.AUTOMATIC).getTransmissionType());
        assertEquals(5, new Vehicle(5, TransmissionType.SEQUENTIAL).getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Vehicle(3, TransmissionType.SEQUENTIAL).getTransmissionType());

        //Car
        assertEquals(5, new Car().getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Car().getTransmissionType());

        assertEquals(5, new Car(TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Car(TransmissionType.AUTOMATIC).getTransmissionType());

        assertEquals(6, new Car(6).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Car(6).getTransmissionType());

        assertEquals(5, new Car(5, TransmissionType.MANUAL).getNumberOfGears());
        assertEquals(3, new Car(3, TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Car(3, TransmissionType.AUTOMATIC).getTransmissionType());
        assertEquals(5, new Car(5, TransmissionType.SEQUENTIAL).getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Car(3, TransmissionType.SEQUENTIAL).getTransmissionType());

        //Motorcycle
        assertEquals(5, new Motorcycle().getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Motorcycle().getTransmissionType());

        assertEquals(5, new Motorcycle(TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Motorcycle(TransmissionType.AUTOMATIC).getTransmissionType());

        assertEquals(6, new Motorcycle(6).getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Motorcycle(6).getTransmissionType());

        assertEquals(5, new Motorcycle(5, TransmissionType.MANUAL).getNumberOfGears());
        assertEquals(3, new Motorcycle(3, TransmissionType.AUTOMATIC).getNumberOfGears());
        assertEquals(TransmissionType.AUTOMATIC, new Motorcycle(3, TransmissionType.AUTOMATIC).getTransmissionType());
        assertEquals(5, new Motorcycle(5, TransmissionType.SEQUENTIAL).getNumberOfGears());
        assertEquals(TransmissionType.SEQUENTIAL, new Motorcycle(3, TransmissionType.SEQUENTIAL).getTransmissionType());
    }
}
