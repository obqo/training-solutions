/*
A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott
nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy
fuvarját reprezentálja a Ride nevű osztály, adatagokkal, konstruktorra, getterekkel.

Készítsd el a Courier osztályt. Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol.
Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához. Figyeljünk viszont arra,
hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen
be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok. Ha a paraméterül
kapott Ride nem felel meg a feltételeknek dobjunk IllegalArgumentException-t.

pl egy helyes listára: 1 1 12 1 2 11 2 1 10 4 1 19

Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a
korábbit!
 */
package week11.week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (rides.isEmpty()) {
            if (ride.getIndex() == 1) {
                rides.add(ride);
                return;
            } else {
                throw new IllegalArgumentException("Wrong ride index!");
            }
        }
        int last = rides.size() - 1;
        if (rides.get(last).getDay() > ride.getDay()) {
            throw new IllegalArgumentException("Wrong ride day!");
        }
        if (rides.get(last).getDay() == ride.getDay() && ride.getIndex() - rides.get(last).getIndex() != 1 ) {
            throw new IllegalArgumentException("Wrong ride index!");
        }
        if (rides.get(last).getDay() < ride.getDay() && ride.getIndex() != 1 ) {
            throw new IllegalArgumentException("Wrong ride index!");
        }
        rides.add(ride);
    }

    public int freeDay() {
        boolean[] freeDay = new boolean[7];
        for (Ride ride : rides) {
            freeDay[ride.getDay()-1] = true;
        }
        for (int i = 0; i < 7; i++) {
            if (!freeDay[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Courier courier = new Courier();
        courier.addRide(new Ride(1, 1, 20));
        courier.addRide(new Ride(1, 2, 20));
        courier.addRide(new Ride(2, 1, 20));
        courier.addRide(new Ride(3, 1, 20));
        courier.addRide(new Ride(3, 2, 20));
        courier.addRide(new Ride(3, 3, 20));
        System.out.println(courier.freeDay());
    }
}
