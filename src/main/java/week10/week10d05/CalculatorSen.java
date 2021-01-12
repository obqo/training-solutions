/*
Készítsünk egy Calculator nevű osztályt, melynek van egy findMinMaxSum(int[] arr) metódusa. A metódus feladata, hogy kiírja a
legnagyobb és a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből.
Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16 , a maximum összeg 3+5+7+9=24.
A Calculator osztály tartalmazzon egy main metódust is, amely a konzolról olvassa be a számokat és azokból készít tömböt,
amivel meghívja a findMinMaxSum metódust.
 */
package week10.week10d05;

import java.util.Arrays;

public class CalculatorSen {

    private static final int ITEMS_NUMBERS = 4;

    public MinMax findMinMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        Arrays.sort(arr);
        int minSum = sum(arr, ITEMS_NUMBERS);
        arr = reverseArray(arr);
        int maxSum = sum(arr, ITEMS_NUMBERS);
        return new MinMax(minSum, maxSum);
    }

    private int sum(int[] arr, int itemsNumbers) {
        int sum = 0;
        for (int i = 0; i < Math.min(ITEMS_NUMBERS, arr.length); i++) {
            sum += arr[i];
        }
        return sum;
    }

    private int[] reverseArray(int[] arr) {
        int[] reverse = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverse[arr.length - i - 1] = arr[i];
        }
        return reverse;
    }

    public static void main(String[] args) {
        CalculatorSen calc = new CalculatorSen();
        System.out.println(calc.findMinMaxSum(new int[]{3, -1, 0, 2, 5}).getMin());
        System.out.println(calc.findMinMaxSum(new int[]{3, -1, 0, 2, 5}).getMax());
    }

}
