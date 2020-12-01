package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive bestPendrive = pendrives.get(0);
        for (Pendrive pendrive1 : pendrives) {
            if (bestPendrive.comparePricePerCapacity(pendrive1) == 1) {
                bestPendrive = pendrive1;
            }
        }
        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive cheapPendrive = pendrives.get(0);
        for (Pendrive pendrive1 : pendrives) {
            if (pendrive1.cheaperThan(cheapPendrive)) {
                cheapPendrive = pendrive1;
            }
        }
        return cheapPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive : pendrives) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }

}
