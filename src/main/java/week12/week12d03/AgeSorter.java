/*
Készítsünk egy osztályt AgeSorter néven, melynek van egy int[] sortAges(int[] ages) metódusa. Az ages tömbben emberek életkorai szerepelnek.
A feladat az, hogy visszaadjunk egy tömböt, mely az életkorokat tartalmazza sorrendbe rendezve. Ne használjunk beépített sorrendbe rendező
algoritmusokat (Collections.sort) a feladat megoldásához!
 */
package week12.week12d03;

import java.util.Arrays;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int[] sortAges = Arrays.copyOf(ages, ages.length);
        for (int i = 0; i < sortAges.length - 1; i++) {
            for (int j = i + 1; j < sortAges.length ; j++) {
                if (sortAges[i] > sortAges[j]) {
                    swap(sortAges, i, j);
                }
            }
        }
        return sortAges;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        AgeSorter ageSorter = new AgeSorter();
        int[] ages = new int[] {1, 1, 4, 2, 3, 5, 2, 2, 5};
        for (int a : ages) {
            System.out.println(a);
        }
        for (int a : ageSorter.sortAges(ages)) {
            System.out.println(a);
        }
    }
}
