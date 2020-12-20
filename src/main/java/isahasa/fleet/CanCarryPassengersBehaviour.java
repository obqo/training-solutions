package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {

    private int passengers;
    private final int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        this.passengers = (passengers < maxPassengers) ? passengers : maxPassengers;
        if (passengers < maxPassengers) return 0;
        return passengers - maxPassengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
