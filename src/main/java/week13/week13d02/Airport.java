/*
Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló gépről
van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos ideje.
A fájl:
FC5354 Arrival Dublin 18:16
KH2442 Departure Berlin 15:54
ID4963 Departure Amsterdam 15:22
CX8486 Arrival Brussels 10:37
EJ9251 Departure  Toronto 11:30
KJ7245 Departure Bern 6:18
JN6048 Arrival Moscow 18:39
MN5047 Arrival Athens 9:35
Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
Feladatok:
1. Olvasd be a fájl tartalmát a memóriába.
2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába adjuk
viassza az összes abba városba induló/érkező repülőt.
5. Adjuk vissza a legkorábban induló repülőt!

 */
package week13.week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Fly> flies = new ArrayList<>();

    public List<Fly> getFlies() {
        return new ArrayList<>(flies);
    }

    public void readFiles() {
        InputStreamReader is = new InputStreamReader(Airport.class.getResourceAsStream("cities.txt"));
        try (BufferedReader reader = new BufferedReader(is)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                flies.add(new Fly(splitLine[0], splitLine[1], splitLine[2], makeLocalTimeFromString(splitLine[3])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private LocalTime makeLocalTimeFromString(String s) {
        String[] time = s.split(":");
        return LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));

    }

    public String wichIsMore() {
        int arrivals = 0;
        int departures = 0;
        for (Fly fly : flies) {
            if (fly.getType().equals("Arrival")) {
                arrivals++;
            } else {
                departures++;
            }
        }
        return arrivals > departures ? "Arrival" : "Departure";
    }

    public Fly searchFlyAtRegNumber(String regNumber) {
        for (Fly fly : flies) {
            if (fly.getRegNumber().equals(regNumber)) {
                return fly;
            }
        }
        throw new IllegalArgumentException("Fly not found.");
    }

    public List<Fly> searchFliesFromToCity(String city, String type) {
        List<Fly> result = new ArrayList<>();
        for (Fly fly : flies) {
            if (fly.getCity().equals(city) && fly.getType().equals(type)) {
                result.add(fly);
            }
        }
        return result;
    }

    public Fly searchEarliestFly() {
        Fly earliestFly = firstArrival();

        for (Fly fly : flies) {
            if (fly.getType().equals("Departure") && fly.getTime().isBefore(earliestFly.getTime())) {
                earliestFly = fly;
            }
        }
        return earliestFly;
    }

    private Fly firstArrival() {
        for (Fly fly : flies) {
            if (fly.getType().equals("Departure")) {
                return fly;
            }
        }
        throw new IllegalStateException("No Departure");
    }
}