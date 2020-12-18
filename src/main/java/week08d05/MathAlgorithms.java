/*
A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor() , ami paraméterül vár két pozitív egész számot és
visszaadja a legnagyobb közös osztójukat.
 */
package week08d05;

public class MathAlgorithms {

    public static int greatestCommonDivisor(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Numbers must be positive");
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            }
            if (b > a) {
                b -= a;
            }
        }
        return a;
    }
}
