/*
Készíts egy GradeRounder osztályt, amiben van egy int[] roundGrades(int[] grades) metódus. A grades tömb pontszámokat tartalmaz 0 és 100 között.
A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint: Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb,
mint 3, akkor kerekítsük fel a számot az 5 következő többszörösére. Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell
kerekíteni. Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.
 */
package week12.week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("No list");
        }
        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            result[i] = grades[i] % 5 < 3 ? grades[i] : (grades[i] / 5 + 1) * 5;
        }
        return result;
    }
}
