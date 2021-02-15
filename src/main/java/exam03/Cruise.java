/*
Utazási iroda hajóutakat szervez. Minden hajóút egy adott hajóval történik,
amelynek neve és befogadóképessége a egy Boat osztályban van tárolva.
Az utasok adott hajóra, adott osztályra foglalnak helyet. A helyfoglaláskor azonban ellenőrizni kell,
hogy a befogadóképesség alapján van-e még hely. Ha nincs, egy kivételt várunk a megfelelő szöveggel.
A CruiseClass enum tárolja a különböző osztályokat. LUXURY, FIRST és SECOND osztályok vannak.
Az ár számolása úgy történik, hogy venni kell a hajóhoz tartozó alapárat,
és meg kell szorozni az osztályhoz tartozó szorzóval, rendre 3,0, 1,8 és 1,0.
bookPassenger(): egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
getPriceForPassenger(): visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
findPassengerByName(): foglalás megkeresése név alapján
getPassengerNamesOrdered(): visszaadja a foglalást végzők neveit ábécé sorrendben
sumAllBookingsCharged(): összegzi, hogy mennyi az összes bevétel
countPassengerByClass(): visszaadja, hogy osztályonként mennyien foglaltak
 */
package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private final Boat boat;
    private final LocalDate sailing;
    private final double basicPrice;
    private final List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() <= passengers.size()) {
            throw new IllegalArgumentException("Boat is full!");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return basicPrice * passenger.getCruiseClass().getMultiplier();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger p : passengers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Can not find name!");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> orderedList = new ArrayList<>();
        for (Passenger p : passengers) {
            orderedList.add(p.getName());
        }
        orderedList.sort(Comparator.naturalOrder());
        return orderedList;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger p : passengers) {
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> counterMap= new HashMap<>();
        for (Passenger p: passengers) {
            CruiseClass key = p.getCruiseClass();
            if (!counterMap.containsKey(key)) {
                counterMap.put(key, 0);
            }
            counterMap.put(key, counterMap.get(key) + 1);
        }
        return counterMap;
    }
}
