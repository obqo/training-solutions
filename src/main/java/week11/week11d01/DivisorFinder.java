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
            int lastDigit = n % 10;
            if (lastDigit != 0 && original % lastDigit == 0) {
                divisorsCount++;
            }
            n /= 10;
        }
        return divisorsCount;
    }

    public int findDivisorsWithString(int n) {
        int divisorsCount = 0;
        String number = Integer.toString(Math.abs(n));
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (digit != 0 && n % digit == 0) {
                divisorsCount++;
            }
        }
        return divisorsCount;
    }
}