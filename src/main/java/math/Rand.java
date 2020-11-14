package math;

import java.util.Random;

public class Rand {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(31) - 10);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextDouble() * 6 - 3);
        }
    }
}
