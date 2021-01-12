/*
Készíts a week08d02 csomagban egy Lottery osztályt, melynek legyen egy getNumbers() metódusa, ami visszaad egy listát amiben 5 véletlen szám van 1-90
között, tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg, hogy a számok különbözők legyenek!

 */
package week08.week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    public List<Integer> getNumbers(int interval, int numbers) {
        if (interval < numbers) {
            throw new IllegalArgumentException("Not enough numbers in interval");
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (count < numbers) {
            int generate = new Random().nextInt(interval) + 1;
            if (!isIn(list, generate)) {
                list.add(generate);
                count++;
            }
        }
        return list;
    }

    private boolean isIn(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Lottery().getNumbers(90, 5));
        System.out.println(new Lottery().getNumbers(45, 6));
        System.out.println(new Lottery().getNumbers(35, 7));
        System.out.println(new Lottery().getNumbers(10, 11));
    }
}
