/*
Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa. A metódus feladata, hogy kiírja a
legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből. Példa: ha az arr tartalma [1, 3, 5, 7, 9],
akkor a minimum összeg 1+3+5+7=16.
 */
package week10.week10d05;

import java.util.Arrays;

public class Calculator {

    private static final int ITEMS_NUMBERS = 4;

    public int findMinSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < Math.min(ITEMS_NUMBERS, arr.length); i++) {
            sum += arr[i];
        }
        return sum;
    }
}