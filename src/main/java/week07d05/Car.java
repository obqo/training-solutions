package week07d05;

public class Car extends Vehicle{

    public Car() {
        super(TransmissionType.AUTOMATIC);
    }

    public Car(int numberOfGears) {
        super(numberOfGears, TransmissionType.AUTOMATIC);
    }

    public Car(TransmissionType transmissionType) {
        super(transmissionType);
    }

    public Car(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }
}
