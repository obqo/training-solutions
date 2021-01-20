/*
Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló listát. Add vissza azt
a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet! Ellenőrizd, hogy olyan listát fogadunk el,
ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma. A fent megírt metódus ezen a listán dolgozzon. A lista
elemeit fájlból töltsük fel. A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:
1,1,4
2,3,5
2,2,5
 */
package week12.week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(NumberStat.class.getResourceAsStream("numbers.txt")))) {
            String line;
            while ((line= reader.readLine()) != null) {
                String[] temp = line.split(",");
                for (String item : temp) {
                    numbers.add(Integer.parseInt(item));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!");
        }
    }

    public int minSingleItem() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("No numbers!");
        }
        int minSingleItem = Integer.MAX_VALUE;
        for (int actual : numbers) {
            List<Integer> listOfAfterActual = numbers.subList(numbers.indexOf(actual) + 1, numbers.size());
            if (!listOfAfterActual.contains(actual) && (actual < minSingleItem)) {
                minSingleItem = actual;
            }
        }
        if (minSingleItem == Integer.MAX_VALUE) {
            throw new IllegalStateException("No single numbers!");
        }
        return minSingleItem;
    }
}