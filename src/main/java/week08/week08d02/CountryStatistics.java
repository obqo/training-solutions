/*
Adott a countries.txt állomány, melyet helyezz el a projekt gyökérkönyvtárába. A fájlban az adatok a következők: ország_neve népesség hány_színű_a_zászló
szomszédos_országok_száma. Készíts a week08d02 csomagba egy CountryStatistics osztályt melyben van egy metódus, ami az adatokat beolvassa egy listába.
A lista legyen az osztály privát attribútuma, és legyen hozzá getter metódus, figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát.
Készíts egy metódust maxPopulaton() néven, ami a listából visszaadja a legnagyobb népességű ország minden adatát.
 */
package week08.week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();


    public List<Country> getCountries() {
        return List.copyOf(countries);
    }

    public void readCountry() {
        try (Scanner scanner = new Scanner(CountryStatistics.class.getResourceAsStream("/countries.txt")).useDelimiter(" |(\r\n)|\n")) {
            while (scanner.hasNextLine()) {
                String name = scanner.next();
                int population = scanner.nextInt();
                int coloursOfFlag = scanner.nextInt();
                int numberOfNeighbours = scanner.nextInt();
                countries.add(new Country(name, population, coloursOfFlag, numberOfNeighbours));
            }
        }
    }

    public Country maxPopulation() {
        Country maxPopulationCountry = countries.get(0);
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getPopulation() > maxPopulationCountry.getPopulation()) {
                maxPopulationCountry = countries.get(i);
            }
        }
        return maxPopulationCountry;
    }

    public static void main(String[] args) {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readCountry();
        System.out.println(countryStatistics.maxPopulation().toString());
    }
}
