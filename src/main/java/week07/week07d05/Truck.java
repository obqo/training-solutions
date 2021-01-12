package week07.week07d05;

public class Truck  extends Vehicle{

    public Truck() {
    }

    public Truck(int numberOfGears) {
        super(numberOfGears);
    }

    public Truck(TransmissionType transmissionType) {
        super(transmissionType);
    }

    public Truck(int numberOfGears, TransmissionType transmissionType) {
        super(numberOfGears, transmissionType);
    }
}
