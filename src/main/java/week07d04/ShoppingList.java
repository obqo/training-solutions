/*
A week07d04.ShoppingList osztályba írj egy long calculateSum(String path) metódust, mely a paraméterként átadott fájlból beolvassa
a bevásárlólista tartalmát, és összegzi az árat. A fájl a következő formátumú sorokat tartalmazza: kenyér;2;30 ahol az első a
termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor esetén 2*30 = 60 értékkel kell számolni.
 */
package week07d04;

import java.util.Scanner;

public class ShoppingList {

    public static long calculateSum(String path) {
        long sum = 0;
        try (Scanner scanner = new Scanner(ShoppingList.class.getResourceAsStream(path)).useDelimiter(";|(\r\n)|\n")) {
            while (scanner.hasNextLine()) {
                scanner.next();
                sum += scanner.nextInt() * scanner.nextInt();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculateSum("/shoppinglist.txt"));
    }
}
