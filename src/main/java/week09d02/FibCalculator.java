/*
A week09d02 csomagban készíts egy osztályt FibCalculator néven. Ennek legyen egy metódusa long sumEvens(int bound) néven. Ennek a metódusnak a feladata az,
hogy összeadja a páros fibonacci számokat addig, amig a következő fibonacci szám nem nagyobb, mint bound, majd visszadja a végredményt.
 */
package week09d02;

public class FibCalculator {

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static long sumEvens(int bound) {
        long sum = 0;
        int n = 0;
        while (fibonacci(n) < bound) {
            if (even(fibonacci(n))) {
                sum += fibonacci(n);
            }
            n++;
        }
        return sum;
    }

    private static boolean even(int nr) {
        return nr % 2 == 0;
    }
}
