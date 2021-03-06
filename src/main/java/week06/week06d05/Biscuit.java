/*
Készíts a week06d05 csomagban egy Biscuit nevű osztályt, amelynek van 2 attribútuma: BiscuitType type és int gramAmount. A BiscuitType legyen felsorolásos típus
a 3 kedvenc kekszfajtáddal. A Biscuit nevű osztálynak legyen egy static metódusa of néven, mely paraméterként egy BiscuitType-ot, és egy int gramAmount-ot vár és
visszaad egy új Biscuit objektumot amelyet a megadott paraméterek alapján hoz létre. Bónusz feladat: konzolra írás esetén a Biscuit jelenítse meg a type és a
gramAmount mezőket!
 */
package week06.week06d05;

public class Biscuit {

    private BiscuitType biscuitType;
    private int gramAmount;

    public Biscuit(BiscuitType biscuitType, int gramAmount) {
        if (biscuitType == null) {
            throw new IllegalArgumentException("Type missing!");
        }
        if (gramAmount < 0) {
            throw new IllegalArgumentException("Gram amount can't negative");
        }
        this.biscuitType = biscuitType;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount) {
        return new Biscuit(biscuitType, gramAmount);
    }

    public String toString() {
        return biscuitType.toString()  +" " + gramAmount + "g";
    }
}
