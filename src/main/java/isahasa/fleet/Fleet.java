package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int passangers, int cargoWeigtht) {
        int remainingPersons = passangers;
        int remainingCargo = cargoWeigtht;
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers) {
                remainingPersons = ((CanCarryPassengers) ship).loadPassenger(remainingPersons);
            }
            if (ship instanceof CanCarryGoods) {
                remainingCargo = ((CanCarryGoods) ship).loadCargo(remainingCargo);
            }
        }
        waitingPersons = remainingPersons;
        waitingCargo = remainingCargo;
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
