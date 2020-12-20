package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers{

    private final CanCarryPassengers canCarryPassengers;

    public Liner(int maxPassangers) {
        this.canCarryPassengers = new CanCarryPassengersBehaviour(maxPassangers);
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
