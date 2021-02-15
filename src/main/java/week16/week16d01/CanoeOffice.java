/*
Kenukölcsönző
Írj egy olyan CanoeRental osztályt, amely String name, CanoeType canoeType, LocalDateTime startTime, LocalDateTime endTime
attribútumokban tárolja egy kenu kölcsönzés kölcsönzési adatait.
A CanoeType egy enum, mely értékei: RED, GREEN és BLUE.
Publikus metódusok:
public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime)
public void setEndTime(LocalDateTime endTime)
public double calculateRentalSum()
Minden kölcsönzés aktív, amíg vissza nem hozták a kenut, azaz ki nem töltötték az endTime értékét.
Írj egy CanoeOffice osztályt, mely tárolja, hogy milyen kölcsönzések történtek (List<CanoeRental>).
A következő metódusokat implementáld:
* addRental(CanoeRental) - hozzáad egy kölcsönzést
* findRentalByName(String name) - megkeres egy AKTÍV kölcsönzést név alapján
* closeRentalByName(String name, LocalDateTime endTime) - megkeres egy AKTÍV kölcsönzést név alapján, beállítja az endTime értékét
* double getRentalPriceByName(String name, LocalDateTime endTime) - kikeresi az AKTÍV kölcsönzést név alapján, és kiszámolja, hogy
a megadott kölcsönzés mennyibe kerülne. A számolás úgy történik, hogy óránként 5000 Ft-ot a szín alapján megszoroz egy értékkel, piros,
zöld és kék esetén rendre 1, 1,2 és 1,5 értékkel. Minden megkezdett óra számít.
* List<CanoeRental> listClosedRentals() - Add vissza a lezárt kölcsönzéseket a startTime alapján sorbarendezve!
* Map<CanoeType, Integer> countRentals() - Számold meg, hány kölcsönzés volt színenként!
 */
package week16.week16d01;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanoeOffice {

    private final List<CanoeRental> canoeRentals = new ArrayList<>();

    private void addRental(CanoeRental canoeRental) {
        canoeRentals.add(canoeRental);
    }

    private CanoeRental findRentalByName(String name) {
        for (CanoeRental cr : canoeRentals) {
            if (cr.getName().equals(name) && cr.getEndTime() == null) {
                return cr;
            }
        }
        throw new IllegalArgumentException("Can not find name!");
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        findRentalByName(name).setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental cr = findRentalByName(name);
        closeRentalByName(name, endTime);
        return cr.calculateRentalSum();
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> copyOfCRL = new ArrayList<>();
        for (CanoeRental cr : canoeRentals) {
            if (cr.getEndTime() != null) {
                copyOfCRL.add(cr);
            }
        }
        copyOfCRL.sort((o1, o2) -> (int) Duration.between(o1.getStartTime(), o2.getStartTime()).toHours());
        return copyOfCRL;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> colourCounterMap = new HashMap<>();
        for (CanoeRental cr : canoeRentals) {
            if (!colourCounterMap.containsKey(cr.getCanoeType())) {
                colourCounterMap.put(cr.getCanoeType(), 0);
            }
            colourCounterMap.put(cr.getCanoeType(), colourCounterMap.get(cr.getCanoeType()) + 1);
        }
        return colourCounterMap;
    }

}
