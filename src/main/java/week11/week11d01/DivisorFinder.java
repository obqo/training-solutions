/*
Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa. A feladat az, hogy
megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket. Példa: a 425-ben
az 5 osztója a számnak, ezért a visszatérési érték 1.
 */
package week11.week11d01;

public class DivisorFinder {

    public int findDivisors(int n) {
        int divisorsCount = 0;
        int original = n;
        while (n != 0) {
            int remainder = n % 10;
            if (original % remainder == 0) {
                divisorsCount++;
            }
            n /= 10;
        }
        return divisorsCount;
    }
}
