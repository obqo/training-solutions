/*
Készíts egy DigitSum osztályt és benne sumOfDigits(int x) metóódus mely visszaadja a paraméterül kapott szám számjegyeinek összegét!
pl.: 123 esetén a visszatérési érték 6.
 */
package week07.week07d02;

public class DigitSum {

    public static int sumOfDigits(int x) {
        int sum = 0;
        int nr = abs(x);
        while (nr > 0) {
            sum += nr % 10;
            nr /= 10;
        }
        return sum;
    }

    public static int sumOfDigitsRecursiv(int x) {
        if (abs(x) < 10) {
            return abs(x);
        }
        return abs(x) % 10 + sumOfDigitsRecursiv(abs(x) / 10);
    }

    public static int sumOfDigitsString(int x) {
        String nr = Integer.toString(abs(x));
        int sum = 0;
        for (int i = 0; i < nr.length(); i++) {
            sum += nr.charAt(i) - '0';
        }
        return sum;
    }

    public static int sumOfDigitsArray(int x) {
        String[] digits = String.valueOf(abs(x)).split("");
        int sum = 0;
        for (String  digit : digits) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }

    private static int abs(int x) {
        return Math.abs(x);
    }
}
